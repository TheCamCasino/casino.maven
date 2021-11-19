package com.github.zipcodewilmington.casino.games.GoFish;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoFishHandTest {

    @Test
    void showPlayerHand() {
        //Given
        GoFishHand goFishHand = new GoFishHand();
        goFishHand.dealCards();

        //When
        String actual = goFishHand.showPlayerHand();

        //Expected
        String expected = "";

        Assert.assertEquals(actual,expected);

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

    @Test
    void dealCards() {
    }
}