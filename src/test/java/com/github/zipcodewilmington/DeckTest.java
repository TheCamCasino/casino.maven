package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.deck.*;
import org.junit.Assert;
import org.junit.Test;

public class DeckTest {
    Hand playerHand = new Hand();
    Deck deck = new Deck();

    @Test
    public void deckHasFiftyTwoCardsTest() {
        //Given
        Integer expected = 52;

        //When
        Integer actual = deck.cardsLeft();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealACardTest() {
        //Given
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
        Card card = new Card(Suit.CLUBS, Rank.ACE);

        //When
        deck.shuffle();
        Card dealtCard = deck.dealCard();

        //Then
        Assert.assertNotEquals(card, dealtCard);
    }

    @Test
    public void dealCardToPlayerHandTest() {
        //Given
        Integer expected = 4;
        deck.shuffle();

        //When
        playerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());

        Integer actual = playerHand.getHandSize();

        //Then
        Assert.assertEquals(expected, actual);
    }

}
