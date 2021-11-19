package com.github.zipcodewilmington.casino.games.GoFish;

import com.github.zipcodewilmington.casino.games.deck.Card;
import com.github.zipcodewilmington.casino.games.deck.Deck;

import java.util.ArrayList;


public class GoFishHand {

private ArrayList<Card> playerHand;

    public GoFishHand() {
        this.playerHand = new ArrayList<>();
    }

   public String showPlayerHand() {
        String showCards = "";
        for (Card card : playerHand) {
            showCards += card.toString();

        }
        return showCards;
   }

   public void addPlayerCards(Card card) {
        this.playerHand.add(card);
   }

   public void clearHand() {
        this.playerHand.removeAll(this.playerHand);
   }

   public ArrayList<String> getRank() {
       ArrayList<String> ranks = new ArrayList<String>();
       for (Card card : playerHand) {
           ranks.add(card.getRank().toString());
       }
       return ranks;
   }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(ArrayList<Card> hand) {
        this.playerHand = hand;
    }

    public void addCards(ArrayList<Card> cardsToAdd) {
        for (Card card : cardsToAdd) {
            this.playerHand.add(card);
        }
    }

    public void dealCards() {
        Deck deck = new Deck();
        deck.shuffle();
        for (int i = 0; i < 7; i++) {
            addPlayerCards(deck.dealCard());
        }

    }

}
