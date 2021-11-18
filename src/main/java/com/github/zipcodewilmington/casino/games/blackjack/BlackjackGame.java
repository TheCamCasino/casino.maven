package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.games.deck.Deck;
import com.github.zipcodewilmington.casino.games.deck.Hand;

import java.util.Locale;

public class BlackjackGame {
    Deck deck;
    Hand playerHand;
    Hand dealerHand;
    Integer playerBet;

    public BlackjackGame() {
        this.playerHand = new Hand();
        this.dealerHand = new Hand();
        this.deck = new Deck();
        deck.shuffle();
    }

    public String printPlayerHand() {
        return "Player's cards:\n" +
                playerHand.showPlayerHand();
    }

    public void startingCards() {
        //deal 2 cards to dealer, but only show one card for now
        dealerHand.addCardToHand(deck.dealCard());
        System.out.println("Dealer's cards:\n" +
                dealerHand.showPlayerHand() + "[ ?? ]\n");
        dealerHand.addCardToHand(deck.dealCard());

        //deal 2 cards to player and show
        playerHand.addCardToHand(deck.dealCard());
        playerHand.addCardToHand(deck.dealCard());
        System.out.println(printPlayerHand());
    }

    //hit and stand
    public void hitStand(String input) {

        if (input.toLowerCase().equals("hit")) {
            playerHand.addCardToHand(deck.dealCard());
            System.out.println(printPlayerHand());
        } else if (input.toLowerCase().equals("stand")) {

        } else {
            System.out.println();
        }
    }

    //win or loss
    public Boolean isAWin() {
        return null;
    }

    //check ace or 11


    //

}
