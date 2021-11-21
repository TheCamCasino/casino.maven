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
        playerHand.addCard(expected);
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
        playerHand.addCard(queenOfHearts);
        playerHand.addCard(jackOfClubs);
        playerHand.addCard(sevenOfDiamonds);

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
        playerHand.addCard(card);
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
        String expected = "" + queenOfHearts + jackOfClubs + sevenOfDiamonds;

        //When
        playerHand.addCard(queenOfHearts);
        playerHand.addCard(jackOfClubs);
        playerHand.addCard(sevenOfDiamonds);

        String actual = playerHand.showHand();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void handValueTest() {
        //Given
        Hand hand = new Hand();
        Card sixOfHearts = new Card(Suit.HEARTS, Rank.SIX);
        Card queenOfSpades = new Card(Suit.SPADES, Rank.QUEEN);
        Integer expected = 16;

        //When
        hand.addCard(sixOfHearts);
        hand.addCard(queenOfSpades);
        Integer actual = hand.getValue();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void handValueWithAceOverTwentyOneTest() {
        //Given
        Hand hand = new Hand();
        Card eightOfHearts = new Card(Suit.HEARTS, Rank.EIGHT);
        Card queenOfSpades = new Card(Suit.SPADES, Rank.QUEEN);
        Card aceOfSpades = new Card(Suit.SPADES, Rank.ACE);
        Integer expected = 19;

        //When
        hand.addCard(eightOfHearts);
        hand.addCard(queenOfSpades);
        hand.addCard(aceOfSpades);
        Integer actual = hand.getValue();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void handValueOneAceTest() {
        //Given
        Hand hand = new Hand();
        Card twoOfDiamonds = new Card(Suit.DIAMONDS, Rank.TWO);
        Card aceOfSpades = new Card(Suit.SPADES, Rank.ACE);
        Integer expected = 13;

        //When
        hand.addCard(twoOfDiamonds);
        hand.addCard(aceOfSpades);
        Integer actual = hand.getValue();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsFaceCardTrueTest() {
        //Given
        Hand hand = new Hand();
        Card jackOfClubs = new Card(Suit.CLUBS, Rank.JACK);
        Boolean expected = true;

        //When
        hand.addCard(jackOfClubs);
        Boolean actual = hand.containsTenCard();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsFaceCardFalseTest() {
        //Given
        Hand hand = new Hand();
        Card twoOfClubs = new Card(Suit.CLUBS, Rank.TWO);
        Boolean expected = false;

        //When
        hand.addCard(twoOfClubs);
        Boolean actual = hand.containsTenCard();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsAceTrueTest() {
        //Given
        Hand hand = new Hand();
        Card aceOfDiamonds = new Card(Suit.DIAMONDS, Rank.ACE);
        Boolean expected = true;

        //When
        hand.addCard(aceOfDiamonds);
        Boolean actual = hand.containsAce();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsAceFalseTest() {
        //Given
        Hand hand = new Hand();
        Card twoOfClubs = new Card(Suit.CLUBS, Rank.TWO);
        Boolean expected = false;

        //When
        hand.addCard(twoOfClubs);
        Boolean actual = hand.containsAce();

        //Then
        Assert.assertEquals(expected, actual);
    }

}
