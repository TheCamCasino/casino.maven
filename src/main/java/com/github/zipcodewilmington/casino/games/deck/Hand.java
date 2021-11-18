package com.github.zipcodewilmington.casino.games.deck;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> playerHand;

    public Hand() {
        this.playerHand = new ArrayList<>();
    }

    public void addCardToHand(Card card) {
        this.playerHand.add(card);
    }

    public String showPlayerHand() {
        String showPlayerCards = "";

        for (Card card : playerHand) {
            showPlayerCards += card;
        }

        return showPlayerCards;
    }

    public void clearHand() {
        this.playerHand.removeAll(this.playerHand);
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public Integer getHandSize() {
        return playerHand.size();
    }

    public Card getPlayerCard(int index) {
        return playerHand.get(index);
    }

    public void setPlayerHand(ArrayList<Card> playerHand) {
        this.playerHand = playerHand;
    }
}
