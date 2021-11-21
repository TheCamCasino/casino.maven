package com.github.zipcodewilmington.casino.games.deck;

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }

    public String toString() {
        return "[" + this.rank + "" + this.suit + "]";
    }

    public Suit getSuit() {
        return suit;
    }

}
