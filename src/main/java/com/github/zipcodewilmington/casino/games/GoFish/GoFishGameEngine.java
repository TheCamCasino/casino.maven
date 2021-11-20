package com.github.zipcodewilmington.casino.games.GoFish;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.deck.Card;
import com.github.zipcodewilmington.casino.games.deck.Deck;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GoFishGameEngine implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.YELLOW);
    private Deck deck = new Deck();
    private PlayerInterface player;
    private GoFishHand playerHand;
    private GoFishHand opponentHand;
    private boolean gameOver = false;

    public boolean isOver() {
        return gameOver;
    }

    public GoFishGameEngine() {
        this.playerHand = new GoFishHand();
        this.opponentHand = new GoFishHand();
    }

    private String getGoldFishDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to GoFish!, to continue, press enter")
                .toString());
    }

    @Override
    public void run() {
        getGoldFishDashboardInput();  //Start user input
        String input = console.getStringInput("Are you ready to play? (enter 'yes' or 'y')\n");
        if (input.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("y")) ;
        dealCards();
        try {
            playGame();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void playGame() throws InterruptedException {  //Game Loop
        while (!gameOver) {
            showPlayersHand();
            playerChooseCard();
            aiTurn();
        }
        checkWhoWon();
    }

    public int countRemainingBooks(ArrayList<Card> hand1, ArrayList<Card> hand2) {
        int getWin = -1;
        if(countBHelp(hand1) > countBHelp(hand2) ) {
            getWin = 0;//Player1
        } else if(countBHelp(hand1) > countBHelp(hand2) ) {
            getWin = 1;//Player 2
        }
        return getWin;
    }

    public int countBHelp(ArrayList<Card> hand1) {
        int count = 0;
        int bookCount = 0;
        for (int i = 0; i < hand1.size(); i++) {
            for (int j = 0; j <  hand1.size(); j++) {
                if(count == 4) {
                    break;
                }
                if(hand1.get(i).getRank() == hand1.get(j).getRank()) {
                    count++;
                }
            }
            if(count == 4) {
                bookCount++;//Ad one to count should count be 4
            }
            count = 0;//Should the overall loop continue, reset to 0
        }
        return bookCount;
    }

    public void checkWhoWon() {  //End condition to check who won based on amount of cards only
        if(countRemainingBooks(playerHand.getPlayerHand(), opponentHand.getPlayerHand()) == 0) {
            System.out.println("Player 1 Won!");
        } else if(countRemainingBooks(playerHand.getPlayerHand(), opponentHand.getPlayerHand()) == 1) {
            System.out.println("Player 2 Won!");
        } else {
            System.out.println("Tie!");
        }
    }

    public void showPlayersHand() {  //Showing both player's hand
        System.out.println();
        System.out.println("Player Hand: \n" + playerHand.showPlayerHand());
    }

    public void playerChooseCard() {   //Condition to choice card for Player
        System.out.println();
        String input = console.getStringInput("Select a card\n");
        ArrayList<String> opponentRank = opponentHand.getRank();  // Placing opponent hand in Arraylist
        ArrayList<Card> stolenCards = new ArrayList<>();  // Getting a new Arraylist for stolenCards
        if (opponentRank.contains(input)) {   // If opponent's rank/card matches user input
            for (Card card : opponentHand.getPlayerHand()) {
                if (card.getRank().toString().equals(input)) {  //If ran equals input toString
                    stolenCards.add(card);
                }
            }
            removeRanks(opponentHand, input);
            playerHand.addCards(stolenCards);
        } else {
            System.out.println("GoFish");
            goFish(playerHand);
        }
    }

    public void removeRanks(GoFishHand hand, String input) {
        ArrayList<Card> ophand = hand.getPlayerHand();
        for (int i = 0; i < ophand.size(); i++) {
            if (ophand.get(i).getRank().toString().equals(input)) {
                ophand.remove(ophand.get(i));
                i--;
            }
            hand.setPlayerHand(ophand);
        }
    }

    public void goFish(GoFishHand goFishDraw) {
        if (deck.cardsLeft() != 0) {
            goFishDraw.addPlayerCards(deck.dealCard());
        } else {
            System.out.println("No cards left");
            gameOver=true;
        }
    }

    public void dealCards() {
        deck.shuffle();
        for (int i = 0; i < 5; i++) {
            opponentHand.addPlayerCards(deck.dealCard());
            playerHand.addPlayerCards(deck.dealCard());
        }
    }

    public String aiChoice() {
        int aiChoice;
        Random rand = new Random();
        aiChoice = rand.nextInt(opponentHand.getPlayerHand().size());
        String aiInput = opponentHand.getPlayerHand().get(aiChoice).getRank().toString();
        return aiInput;
    }

    public void aiTurn() throws InterruptedException {
        String input = "";
        showPlayersHand();
        System.out.println("Opponent's Turn...");
        TimeUnit.SECONDS.sleep(1);
        input = aiChoice();
        System.out.println("Opponent is looking for " + input + "s");
        TimeUnit.SECONDS.sleep(1);
        ArrayList<String> playerRank = playerHand.getRank();
        ArrayList<Card> stolenCards = new ArrayList<>();
        if (playerRank.contains(input)) {
            for (Card card : playerHand.getPlayerHand()) {
                if (card.getRank().toString().equals(input)) {
                    stolenCards.add(card);
                }
            }
            removeRanks(playerHand, input);
            opponentHand.addCards(stolenCards);
        } else {
            goFish(opponentHand);
        }
    }

    @Override
    public void add (PlayerInterface player){
    this.player = player;
    }

    @Override
    public void remove (PlayerInterface player){
        this.player = null;

    }
    public void setIsOver(boolean flag) {
        this.gameOver = flag;
    }

}

