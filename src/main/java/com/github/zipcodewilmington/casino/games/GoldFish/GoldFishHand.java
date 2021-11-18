package com.github.zipcodewilmington.casino.games.GoldFish;

import com.github.zipcodewilmington.casino.games.deck.Card;
import java.util.ArrayList;


public class GoldFishHand {
    private ArrayList<Card> cards;

    //constructor set the cards to a new arraylist
    public GoldFishHand() {
        cards = new ArrayList<>();

    }

    public void clear() {
        // Clearing all cards
        cards.clear();
    }

    public void add(Card card) {
        // adding a card
        cards.add(card);
    }

    public String showGoldFishHand() {
        String hand = "";
        for (Card c : cards) {
            hand += hand.toString();
        }
    return hand;   // Will show hand
    }
    public boolean giveCard(Card card, GoldFishHand otherHand) {
        // Give card if card matches GoldFish
        if (!cards.contains(card)) {
            return false;
        } else {
            // removes card from hand
            cards.remove(card);
            // was able to give card to other player
            otherHand.add(card);
            return true;
        }
    }
}