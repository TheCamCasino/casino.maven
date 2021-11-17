package com.github.zipcodewilmington.casino.games.GoldFish;

import com.github.zipcodewilmington.casino.games.deck.Rank;
import com.github.zipcodewilmington.casino.games.deck.Suit;

public class GoldFishCards {

    //Fields
    private Suit suit;
    private Rank rank;
    private boolean isCardUp;

    // Constructor
    public GoldFishCards(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        isCardUp = true;
    }

    // Methods
    public String getSuit() {
        return suit.toString();
    }

    public String getRank() {
        return rank.toString();
    }
    public void turnCard() {
        isCardUp = !isCardUp;
    }
    public String toString() {
        String str = "";
        if(isCardUp) {
            str += rank.toString() + " of " +
                    suit.toString();
        } else {
            str = "Card down (unable to show card)";
        }
        return str;
    }
}