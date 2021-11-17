package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.deck.Card;
import com.github.zipcodewilmington.casino.games.deck.Rank;
import com.github.zipcodewilmington.casino.games.deck.Suit;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    @Test
    public void getCardSuit() {
        //Given
        Card card = new Card(Suit.DIAMONDS, null);
        Suit expected = Suit.DIAMONDS;

        //When
        Suit actual = card.getSuit();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCardRank() {
        //Given
        Card card = new Card(null, Rank.JACK);
        Rank expected = Rank.JACK;

        //When
        Rank actual = card.getRank();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSuitAndRank(){
        //Given
        Card expected = new Card(Suit.SPADES, Rank.SEVEN);

        //When
        Suit actualSuit = expected.getSuit();
        Rank actualRank = expected.getRank();

        //Then
        Assert.assertEquals(expected.getSuit(), actualSuit);
        Assert.assertEquals(expected.getRank(), actualRank);

    }
}
