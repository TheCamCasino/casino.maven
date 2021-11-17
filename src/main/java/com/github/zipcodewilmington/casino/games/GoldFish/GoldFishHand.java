package com.github.zipcodewilmington.casino.games.GoldFish;

import com.github.zipcodewilmington.casino.games.deck.Card;
import com.github.zipcodewilmington.casino.games.deck.Rank;
import com.github.zipcodewilmington.casino.games.deck.Suit;

public class GoldFishHand {

    public static void main(String[] args) {
        Card test1, test2;
        test1 = new Card(Suit.HEARTS, Rank.ACE); //Need Ace 1;
        test2 = new Card(Suit.CLUBS, Rank.QUEEN);

        System.out.println(test1.toString() + "\n" + test2.toString());

        //Flip cards
        test1.toString();
        test2.toString();
    }

}
