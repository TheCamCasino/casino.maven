package com.github.zipcodewilmington.casino.games.GoFish;


import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.deck.Card;
import com.github.zipcodewilmington.casino.games.deck.Deck;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;

import java.util.Random;

public class GoFishGameEngine implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.YELLOW);
    private Deck deck = new Deck();
    private Integer playerBet;
    private Integer balance;
    private GoFishHand playerHand;
    private GoFishHand opponentHand;
    private boolean gameOver = false;
    private PlayerInterface player;


    public GoFishGameEngine() {
        this.playerHand = new GoFishHand();
        this.opponentHand = new GoFishHand();
    }

    private String getGoldFishDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to GoFish!")
                .toString());
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
        int getWin = -1;  // If tie
        if(countBooks(hand1) > countBooks(hand2) ) {
            getWin = 0;//Player1
        } else if(countBooks(hand2) > countBooks(hand1) ) {
            getWin = 1;//Player 2
        }
        return getWin;
    }

    public int countBooks(ArrayList<Card> hand1) {
        int count = 0;
        int bookCount = 0;
        ArrayList<String>checkedNum = new ArrayList<>(); //array list to store already checked ranks
        for (int i = 0; i < hand1.size(); i++) {
            if(!checkedNum.contains(hand1.get(i).getRank().toString())){
                checkedNum.add(hand1.get(i).getRank().toString());           //will only Do J loop if the rank has not already been checked for
            for (int j = 0; j < hand1.size(); j++) {
                if (count == 4) {
                    break;
                }
                    if (hand1.get(i).getRank() == hand1.get(j).getRank()) {
                        count++;
                    }
                    if (count == 4) {
                        bookCount++;//Ad one to count should count be 4
                        count = 0;//Should the overall loop continue, reset to 0
                      }
                    }
                }
            }

        return bookCount;
    }

    public String checkWhoWon() {  //End condition to check who won based on amount of cards only
        if(countRemainingBooks(playerHand.getPlayerHand(), opponentHand.getPlayerHand()) == 0) {
            System.out.println();
            System.out.println("You Won!!!\nPlayer1 Book Count: " + countBooks(playerHand.getPlayerHand()) + "\n" +"Opponent Book Count: "+
                    countBooks(opponentHand.getPlayerHand()));
            player.getArcadeAccount().setUserBalance(balance + playerBet);
            System.out.println("Your current balance is" + balance);
            return "Player1";
        } else if(countRemainingBooks(playerHand.getPlayerHand(), opponentHand.getPlayerHand()) == 1) {
            System.out.println();
            System.out.println("Opponent Won!!!\nPlayer1 Book Count " + countBooks(playerHand.getPlayerHand()) + "\n" +"Opponent Book Count: "+
                    countBooks(opponentHand.getPlayerHand()));
            System.out.println("Your current balance is $" + balance);
            return "Player2";

        } else {
            System.out.println("It was a Tie!");
            return "Tie";
        }
    }

    public void showPlayersHand() {  //Showing both player's hand
        System.out.println();
        System.out.println("Player Hand: " + playerHand.showPlayerHand());
    }

    public boolean isOver() {
        return gameOver;
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
            System.out.println();
            System.out.println(">)))>  GoFish  >)))>");
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

    public void aiTurn() {
        String input = "";
        showPlayersHand();
        System.out.println("Opponent's Turn...\n");
        input = aiChoice();
        System.out.println("Opponent is looking for " + input + "s\n");
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
    public void run() {
        getGoldFishDashboardInput();  //Start user input
        String input = console.getStringInput("Are you ready to play? (please press enter)\n");
        if (input.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("y")) ;
        balance = player.getArcadeAccount().getUserBalance();
        playerBet = getBetInput();
        player.getArcadeAccount().setUserBalance(balance - playerBet);
        balance = player.getArcadeAccount().getUserBalance();
        dealCards();
        try {
            playGame();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Integer getBetInput() {
        return console.getIntegerInput(new StringBuilder()
                .append("\n >)))>  >)))> Your current balance is: " + balance)
                .append(" >)))>  >)))>' Please place your bet")
                .toString());
    }
    @Override
    public void add (PlayerInterface player){
    this.player = player;
    }

    @Override
    public void remove(PlayerInterface player) {
        this.player = null;
    }

    public void setIsOver(boolean flag) {
        this.gameOver = flag;
    }

}

