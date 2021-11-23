package com.github.zipcodewilmington.casino.games.deck;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    public void getPrimaryValueTest() {
        // Given
        Card jackOfDiamonds = new Card(Suit.DIAMONDS, Rank.JACK);
        Integer expected = 11;

        // When
        Integer actual = jackOfDiamonds.getRank().getPrimaryValue();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSecondaryValueTest() {
        // Given
        Card jackOfDiamonds = new Card(Suit.DIAMONDS, Rank.JACK);
        Integer expected = 10;

        // When
        Integer actual = jackOfDiamonds.getRank().getSecondaryValue();

        // Then
        Assert.assertEquals(expected, actual);
    }
}