package com.github.zipcodewilmington.casino.games.deck;

import java.util.Stack;

public class Deck {
    private Stack<Card> cardStack = new Stack<>();

    public Deck() {
        for(Suit suit : Suit.values()) { // 4 suits
            for(Rank rank : Rank.values()) { // 13 ranks
                cardStack.push(new Card(suit, rank)); //52 cards expressed in a few lines
            }
        }
    }

    public Card getCard() {
        return cardStack.pop();
    }
}
