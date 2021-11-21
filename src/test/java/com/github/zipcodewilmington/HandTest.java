package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.deck.Card;
import com.github.zipcodewilmington.casino.games.deck.Hand;
import com.github.zipcodewilmington.casino.games.deck.Rank;
import com.github.zipcodewilmington.casino.games.deck.Suit;
import org.junit.Assert;
import org.junit.Test;

public class HandTest {
    private Hand playerHand = new Hand();

    @Test
    public void addCardToHandTest() {
        //Given
        Card expected = new Card(Suit.CLUBS, Rank.JACK);

        //When
        playerHand.addCardToHand(expected);
        Card actual = playerHand.getPlayerCard(0);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandSizeTest() {
        //Given
        Card queenOfHearts = new Card(Suit.HEARTS, Rank.QUEEN);
        Card jackOfClubs = new Card(Suit.CLUBS, Rank.JACK);
        Card sevenOfDiamonds = new Card (Suit.DIAMONDS, Rank.SEVEN);
        Integer expected = 3;

        //When
        playerHand.addCardToHand(queenOfHearts);
        playerHand.addCardToHand(jackOfClubs);
        playerHand.addCardToHand(sevenOfDiamonds);

        Integer actual = playerHand.getHandSize();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void clearHandTest() {
        //Given
        Card card = new Card(Suit.HEARTS, Rank.QUEEN);
        Integer expected = 0;

        //When
        playerHand.addCardToHand(card);
        playerHand.clearHand();

        Integer actual = playerHand.getHandSize();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void showPlayerHand() {
        //Given
        Card queenOfHearts = new Card(Suit.HEARTS, Rank.QUEEN);
        Card jackOfClubs = new Card(Suit.CLUBS, Rank.JACK);
        Card sevenOfDiamonds = new Card (Suit.DIAMONDS, Rank.SEVEN);
        String expected = queenOfHearts.toString() + jackOfClubs.toString() + sevenOfDiamonds.toString();

        //When
        playerHand.addCardToHand(queenOfHearts);
        playerHand.addCardToHand(jackOfClubs);
        playerHand.addCardToHand(sevenOfDiamonds);

        String actual = playerHand.showPlayerHand();

        //Then
        Assert.assertEquals(expected, actual);
    }

}
