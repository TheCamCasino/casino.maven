package com.github.zipcodewilmington.casino.games.GoFish;

import com.github.zipcodewilmington.casino.games.deck.Card;
import com.github.zipcodewilmington.casino.games.deck.Deck;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class GoFishHandTest {

    @Test
    public void GoFishHand() {
        //Given
        GoFishHand goFishHand = new GoFishHand();
        goFishHand = new GoFishHand();
    }


    @Test
    void showPlayerHand() {
        //Given
        GoFishHand goFishHand = new GoFishHand();
        goFishHand.dealCards();

        //When
        String actual = goFishHand.showPlayerHand();

        //Expected
        String expected = goFishHand.showPlayerHand();

        Assert.assertEquals(actual, expected);
    }

    @Test
    void isConstructorNull() {
        //Given
        String expected = "[]";
        GoFishHand goFishHand = new GoFishHand();

        //When
        System.out.println(goFishHand.getPlayerHand().toString());
    }

    @Test
    void addPlayerCards() {


    }


    @Test
    void clearHand() {
    }

    @Test
    void getRank() {


    }
}

