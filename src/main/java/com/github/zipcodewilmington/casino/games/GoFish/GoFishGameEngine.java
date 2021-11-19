package com.github.zipcodewilmington.casino.games.GoFish;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.deck.Card;
import com.github.zipcodewilmington.casino.games.deck.Deck;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;

public class GoFishGameEngine implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    private Deck deck = new Deck();

    private GoFishPlayer player;
    private GoFishPlayer opponent;
    private GoFishHand playerHand;
    private GoFishHand opponentHand;

    public GoFishGameEngine() {
        CasinoAccount casinoAccount = new CasinoAccount("Test","password", 500);
        CasinoAccount casinoAccount2 = new CasinoAccount("Test2","password2", 500);
        this.player = new GoFishPlayer(casinoAccount);
        this.opponent = new GoFishPlayer(casinoAccount2);
        this.playerHand = new GoFishHand();
        this.opponentHand = new GoFishHand();

    }

    public static void main(String[] args) {   //Testing purposes
        GoFishGameEngine engine = new GoFishGameEngine();
        engine.run();

    }
    @Override
    public void run() {

        //Start user input
        String input = console.getStringInput("Are you ready to play? (enter 'yes' or 'y')");
        // The game starts when you agree to play
        if (input.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("y")) ;
        dealCards();
        System.out.println("Opponent Hand: " + opponentHand.showPlayerHand());
        System.out.println("Player Hand: " + playerHand.showPlayerHand());
        chooseCardChoice();
    }

    private String getGoldFishDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to GoFish!")
                .toString());
    }

    public void dealCards() {
        Deck deck = new Deck();
        deck.shuffle();
        for (int i = 0; i < 7; i++) {
            opponentHand.addPlayerCards(deck.dealCard());
            playerHand.addPlayerCards(deck.dealCard());
        }
    }

    public String chooseCardChoice() {
        String input = console.getStringInput("Choose a card to request");
        ArrayList<String> opponentRank = opponentHand.getRank();
        ArrayList<Card> stolenCards = new ArrayList<>();
        if(opponentRank.contains(input)) {
            for(Card card : opponentHand.getPlayerHand()) {
                if(card.getRank().equals(input)) {
                    stolenCards.add(card);
                }
            }
            removeRanks(opponentHand, input);
            playerHand.addCards(stolenCards);
            System.out.println("Opponent Hand: " + opponentHand.showPlayerHand());
            System.out.println("Player Hand: " + playerHand.showPlayerHand());
        }

     return null;
    }

    // Removing the stolen card from the opponents hand
    public void removeRanks(GoFishHand hand, String input) {
        ArrayList<Card> ophand = hand.getPlayerHand();
        for (int i = 0; i < ophand.size(); i++) {
            if(ophand.get(i).getRank().equals(input)) {
                ophand.remove(ophand.get(i));
                //i--;
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
        public void fish () {

        }

    }

