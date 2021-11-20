package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.blackjack.BlackjackGame;
import com.github.zipcodewilmington.casino.games.deck.*;
import org.junit.Assert;
import org.junit.Test;

public class BlackjackGameTest {

    @Test
    public void bjConstructorTest() {
        //Given
        Deck deck = new Deck();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
        BlackjackGame bj = new BlackjackGame(deck, playerHand, dealerHand);

        //When
        Deck actualDeck = bj.getDeck();
        Hand actualPlayerHand = bj.getPlayerHand();
        Hand actualDealerHand = bj.getDealerHand();

        //Then
        Assert.assertEquals(deck, actualDeck);
        Assert.assertEquals(playerHand, actualPlayerHand);
        Assert.assertEquals(dealerHand, actualDealerHand);
    }

    @Test
    public void hitPlayerHandTest() {
        //Given
        BlackjackGame bj = new BlackjackGame();
        Hand hand = bj.getPlayerHand();
        Integer expected = 3;

        //When
        bj.hit(hand);
        bj.hit(hand);
        bj.hit(hand);
        Integer actual = hand.getHandSize();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playerWinsTest() {
        //Given
        BlackjackGame bj = new BlackjackGame();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        Card sixOfHearts = new Card(Suit.HEARTS, Rank.EIGHT);
        Card queenOfSpades = new Card(Suit.SPADES, Rank.QUEEN);

        Card aceOfSpades = new Card(Suit.SPADES, Rank.ACE);
        Card twoOfDiamonds = new Card(Suit.DIAMONDS, Rank.TWO);

        String expected = "player";

        //When player hand is greater
        playerHand.addCard(sixOfHearts);
        playerHand.addCard(queenOfSpades);
        dealerHand.addCard(aceOfSpades);
        dealerHand.addCard(twoOfDiamonds);

        String actual = bj.checkWinner(playerHand, dealerHand);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealerWinsTest() {
        //Given
        BlackjackGame bj = new BlackjackGame();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        Card sixOfHearts = new Card(Suit.HEARTS, Rank.EIGHT);
        Card queenOfSpades = new Card(Suit.SPADES, Rank.QUEEN);

        Card aceOfSpades = new Card(Suit.SPADES, Rank.ACE);
        Card twoOfDiamonds = new Card(Suit.DIAMONDS, Rank.TWO);

        String expected = "dealer";

        //When player hand is greater
        playerHand.addCard(sixOfHearts);
        playerHand.addCard(twoOfDiamonds);
        dealerHand.addCard(queenOfSpades);
        dealerHand.addCard(aceOfSpades);

        String actual = bj.checkWinner(playerHand, dealerHand);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playerDealerTieTest() {
        //Given
        BlackjackGame bj = new BlackjackGame();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        Card eightOfHearts = new Card(Suit.HEARTS, Rank.EIGHT);
        Card queenOfSpades = new Card(Suit.SPADES, Rank.QUEEN);

        Card eightOfClubs = new Card(Suit.CLUBS, Rank.EIGHT);
        Card queenOfHearts = new Card(Suit.HEARTS, Rank.QUEEN);

        String expected = "tie";

        //When player hand is greater
        playerHand.addCard(eightOfHearts);
        playerHand.addCard(queenOfSpades);
        dealerHand.addCard(eightOfClubs);
        dealerHand.addCard(queenOfHearts);

        String actual = bj.checkWinner(playerHand, dealerHand);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void bustTrueTest() {
        //Given
        BlackjackGame bj = new BlackjackGame();
        Hand hand = new Hand();

        Card tenOfClubs = new Card(Suit.CLUBS, Rank.TEN);
        Card kingOfDiamonds = new Card(Suit.DIAMONDS, Rank.KING);
        Card threeOfHearts = new Card(Suit.HEARTS, Rank.THREE);

        Boolean expected = true;

        //When
        hand.addCard(tenOfClubs);
        hand.addCard(kingOfDiamonds);
        hand.addCard(threeOfHearts);

        Boolean actual = bj.bust(hand);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void bustFalseTest() {
        //Given
        BlackjackGame bj = new BlackjackGame();
        Hand hand = new Hand();

        Card tenOfClubs = new Card(Suit.CLUBS, Rank.TEN);
        Card kingOfDiamonds = new Card(Suit.DIAMONDS, Rank.KING);

        Boolean expected = false;

        //When
        hand.addCard(tenOfClubs);
        hand.addCard(kingOfDiamonds);

        Boolean actual = bj.bust(hand);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void initialHandTest() {
        //Given
        BlackjackGame bj = new BlackjackGame();
        Integer expected = 2;

        //When
        bj.initialHand();
        Integer playerHandSize = bj.getPlayerHand().getHandSize();
        Integer dealerHandSize = bj.getDealerHand().getHandSize();

        //Then
        Assert.assertEquals(expected, playerHandSize);
        Assert.assertEquals(expected, dealerHandSize);
    }

    @Test
    public void doubleDownTest() {
        //Given
        BlackjackGame bj = new BlackjackGame();
        Integer expected = 3;

        //When
        bj.initialHand();
        bj.doubleDown();
        Integer playerHandSize = bj.getPlayerHand().getHandSize();

        //Then
        Assert.assertEquals(expected, playerHandSize);
    }

}
