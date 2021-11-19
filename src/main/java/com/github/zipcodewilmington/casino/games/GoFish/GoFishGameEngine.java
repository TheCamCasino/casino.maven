package com.github.zipcodewilmington.casino.games.GoFish;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.deck.Card;
import com.github.zipcodewilmington.casino.games.deck.Deck;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;

public class GoFishGameEngine implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.YELLOW);
    private Deck deck = new Deck();

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

    public static void main(String[] args) {   //Testing purposes
        GoFishGameEngine engine = new GoFishGameEngine();
        engine.run();
    }
    private String getGoldFishDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to GoFish!, to continue, press enter")
                .toString());
    }
    @Override
    public void run() {
        getGoldFishDashboardInput();
        //Start user input
        String input = console.getStringInput("Are you ready to play? (enter 'yes' or 'y')");
        // The game starts when you agree to play
        if (input.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("y")) ;
        dealCards();
        playGame();
    }
    //Game Loop
    public void playGame() {
        while (!gameOver) {
        showPlayersHand();
         playerHaveTurn();
        chooseCardChoice();
        }
    }
    public void showPlayersHand() {
        System.out.println();
        System.out.println("Opponent Hand: " + opponentHand.showPlayerHand());
        System.out.println("Player Hand: " + playerHand.showPlayerHand());
    }

    public void playerHaveTurn() {
        if (chooseCardChoice() != opponentHand.showPlayerHand()) {
            System.out.println();
            console.getStringInput("GoFish");
            goFish();
            showPlayersHand();
        } else if(chooseCardChoice() == opponentHand.showPlayerHand()) {
            System.out.println();
            playGame();
        }
    }


    private void removeRanksAI(GoFishHand opponentHand, String input) {
        ArrayList<Card> phand = opponentHand.getPlayerHand();
        for (int i = 0; i < phand.size(); i++) {
            if(phand.get(i).getRank().toString().equals(input)) {
                phand.remove(phand.get(i));
                i--;
            }
            playerHand.setPlayerHand(phand);
        }
    }

    public void goFish() {
        Deck deck = new Deck();
        deck.shuffle();
        for(int i = 0; i < 1; i++) {
            playerHand.addPlayerCards(deck.dealCard());
        }
    }

    public void dealCards() {
        Deck deck = new Deck();
        deck.shuffle();
        for (int i = 0; i < 5; i++) {
            opponentHand.addPlayerCards(deck.dealCard());
            playerHand.addPlayerCards(deck.dealCard());
        }
    }

    public String chooseCardChoice() {
        /*
        to test: if we stole - their hand doesnt have the stolen cards anymore
                               our hand does have the stolen cards
                if we didn't steal - show that their hand didn't change
                                     our hand drew a card
         */
        System.out.println();
        String input = console.getStringInput("Choose a card to request");
        ArrayList<String> opponentRank = opponentHand.getRank();
        ArrayList<Card> stolenCards = new ArrayList<>();
        if(opponentRank.contains(input)) {
            for(Card card : opponentHand.getPlayerHand()) {
                if(card.getRank().toString().equals(input)) {
                    stolenCards.add(card);
                }
            }
            removeRanks(opponentHand, input);
            playerHand.addCards(stolenCards);
        }

     return null;
    }
    public void setIsOver(boolean flag) {
        this.gameOver = flag;
    }
//    public String chooseCardChoiceAI() {
//        System.out.println();
//        String AI =  "Do you have any + ";
//        ArrayList<String> playerRank = playerHand.getRank();
//        ArrayList<Card> stolenCards = new ArrayList<>();
//        if(playerRank.contains(opponentHand)) {
//            for(Card card : opponentHand.getPlayerHand()) {
//                if(card.getRank().toString().equals(input)) {
//                    stolenCards.add(card);
//                }
//            }
//            removeRanks(opponentHand, input);
//            playerHand.addCards(stolenCards);
//            showPlayersHand();
//        }
//
//        return null;
//    }

    // Removing the stolen card from the opponents hand
    public void removeRanks(GoFishHand hand, String input) {
        ArrayList<Card> ophand = hand.getPlayerHand();
        for (int i = 0; i < ophand.size(); i++) {
            if(ophand.get(i).getRank().toString().equals(input)) {
                ophand.remove(ophand.get(i));
                i--;
            }
                opponentHand.setPlayerHand(ophand);
        }
    }

    @Override
    public void add (PlayerInterface player){

    }

    @Override
    public void remove (PlayerInterface player){

    }

}

