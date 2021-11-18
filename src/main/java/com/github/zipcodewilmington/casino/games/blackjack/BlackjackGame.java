package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.games.deck.Deck;
import com.github.zipcodewilmington.casino.games.deck.Hand;

import java.util.Locale;

public class BlackjackGame {
    Deck deck = new Deck();
    Hand playerHand = new Hand();
    Hand dealerHand = new Hand();



    //hit and stand
    public void hitStand(String input) {
        if (input.toLowerCase().equals("hit")) {

        } else if (input.toLowerCase().equals("stand")) {

        } else {

        }
    }

    //win or loss
    public Boolean isAWin() {
        return null;
    }

    //check ace or 11


    //

}
