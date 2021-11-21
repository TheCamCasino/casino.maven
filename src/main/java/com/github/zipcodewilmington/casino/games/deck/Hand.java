package com.github.zipcodewilmington.casino.games.deck;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> playerHand;

    public Hand() {
        this.playerHand = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.playerHand.add(card);
    }

    public String showHand() {
        String showPlayerCards = "";

        for (Card card : playerHand) {
            showPlayerCards += card;
        }

        return showPlayerCards;
    }

    public void clearHand() {
        this.playerHand.removeAll(this.playerHand);
    }

    public Integer getValue() {
        Integer sum = 0;
        for(Card card : playerHand) {
            sum += card.getRank().getSecondaryValue();
        }

        if (sum > 21) {
            for (Card card : playerHand) {
                if(card.getRank().equals(Rank.ACE)) {
                    sum -= 10;
                }
            }
        }
        return sum;
    }

    public Integer getHandSize() {
        return playerHand.size();
    }

    public Card getPlayerCard(int index) {
        return playerHand.get(index);
    }

    public Boolean containsTenCard() {
        for (Card card : playerHand) {
            if (card.getRank().getSecondaryValue().equals(10)) {
                return true;
            }
        }
        return false;
    }

    public Boolean containsAce() {
        for (Card card : playerHand) {
            if (card.getRank().equals(Rank.ACE)) {
                return true;
            }
        }
        return false;
    }
}
