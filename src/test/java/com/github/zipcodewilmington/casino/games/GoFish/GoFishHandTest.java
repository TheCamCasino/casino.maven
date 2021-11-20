package com.github.zipcodewilmington.casino.games.GoFish;

import org.junit.Assert;
import org.junit.jupiter.api.Test;



class GoFishHandTest {

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
    }
    @Test

    void addCardsTest() {
        // Given

        // When


        // Then

    }

    @Test
    void clearHand() {
        // Given

        // When

        // Then

    }

    @Test
    void getRank() {
        // Given

        // When

        // Then

    }
}

