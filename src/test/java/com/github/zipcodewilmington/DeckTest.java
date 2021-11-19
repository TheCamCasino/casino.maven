package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.deck.Card;
import com.github.zipcodewilmington.casino.games.deck.Deck;
import com.github.zipcodewilmington.casino.games.deck.Rank;
import com.github.zipcodewilmington.casino.games.deck.Suit;
import org.junit.Assert;
import org.junit.Test;

public class DeckTest {

    @Test
    public void deckHasFiftyTwoCardsTest() {
        //Given
        Deck deck = new Deck();
        Integer expected = 52;

        //When
        Integer actual = deck.cardsLeft();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealACardTest() {
        //Given
        Deck deck = new Deck();
        Integer expected = 51;

        //When
        deck.dealCard();
        Integer actual = deck.cardsLeft();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shuffleTest() {
        //Given
        Deck deck = new Deck();
        Card card = new Card(Suit.CLUBS, Rank.ACE);

        //When
        deck.shuffle();
        Card dealtCard = deck.dealCard();

        //Then
        Assert.assertNotEquals(card, dealtCard);
    }

}
