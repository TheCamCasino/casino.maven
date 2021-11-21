package com.github.zipcodewilmington.casino.games.GoFish;

import com.github.zipcodewilmington.casino.games.deck.Card;
import com.github.zipcodewilmington.casino.games.deck.Deck;
import com.github.zipcodewilmington.casino.games.deck.Rank;
import com.github.zipcodewilmington.casino.games.deck.Suit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GoFishGameEngineTest {

    private GoFishGameEngine goFishGameEngine;
    private GoFishHand testHand;
    private GoFishHandTest playerHand;
    private GoFishHandTest opponentHand;

    @Before
    public void setup() {
        goFishGameEngine = new GoFishGameEngine();
        testHand = new GoFishHand();

        Card twoOfHearts = new Card(Suit.HEARTS, Rank.TWO);
        Card threeOfHearts = new Card(Suit.HEARTS, Rank.THREE);
        Card twoOfDiamonds = new Card(Suit.DIAMONDS, Rank.TWO);
        Card threeOfDiamonds = new Card(Suit.DIAMONDS, Rank.THREE);
        Card twoOfSpades = new Card(Suit.SPADES, Rank.TWO);
        Card threeOfSpades = new Card(Suit.SPADES, Rank.THREE);
        Card twoOfClubs = new Card(Suit.CLUBS, Rank.TWO);

        testHand.addPlayerCards(twoOfHearts);
        testHand.addPlayerCards(threeOfHearts);
        testHand.addPlayerCards(twoOfDiamonds);
        testHand.addPlayerCards(threeOfDiamonds);
        testHand.addPlayerCards(twoOfSpades);
        testHand.addPlayerCards(threeOfSpades);
        testHand.addPlayerCards(twoOfClubs);
    }

    @Test
    public void isOver_flagSetToFalseByDefault_isFalseTest() {
        // given
        boolean expected = false;
        // when
        boolean actual = goFishGameEngine.isOver();
        // then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void removeRanksTestNull() {
        // given
        testHand = new GoFishHand();

        String givenConsolePlayerInput = "";

        String expectedHandString = "";
        // when
        goFishGameEngine.removeRanks(testHand, givenConsolePlayerInput);
        String returnedHandString = testHand.showPlayerHand();
        //  then
        Assert.assertEquals(expectedHandString, returnedHandString);
    }

    @Test
    public void deckIncomingTest() {
        Deck deck = new Deck();
        //Given
        Integer expected = 52;

        //When
        Integer actual = deck.cardsLeft();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void countBHelp() {

        Integer actual = goFishGameEngine.countBooks(testHand.getPlayerHand());
        Integer expected = 1;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void countRemainingBooks() {
        // Tie equals -1;
        Integer actual = goFishGameEngine.countRemainingBooks(testHand.getPlayerHand(), testHand.getPlayerHand());
        Integer expected = -1;
        Assert.assertEquals(expected, actual);
    }

}








