package com.github.zipcodewilmington.casino.games.GoFish;

import com.github.zipcodewilmington.casino.games.deck.Card;
import com.github.zipcodewilmington.casino.games.deck.Rank;
import com.github.zipcodewilmington.casino.games.deck.Suit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class GoFishHandTest {

    GoFishHand testHand;

    @Before
    public void setUp(){
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
    public String showPlayerHand() {
        //Given
        GoFishHand goFishHand = new GoFishHand();
        goFishHand.dealCards();

        //When
        String actual = testHand.showPlayerHand();

        //Expected
        String expected = "[2♥][3♥][2♦][3♦][2♠][3♠][2♣]";

        Assert.assertEquals(actual, expected);
        return actual;
    }

    @Test
    public void isConstructorNull() {
        //Given
        String expected = "[]";
        GoFishHand goFishHand = new GoFishHand();

        //When
    }
    @Test

    public void addCardsTest() {
        // Given
        GoFishHand testHand2 = new GoFishHand();
        Card fourOfSpades = new Card(Suit.SPADES, Rank.FOUR);
        Card fiveOfClubs = new Card(Suit.CLUBS, Rank.FIVE);
        testHand2.addPlayerCards(fourOfSpades);
        testHand2.addPlayerCards(fiveOfClubs);
        // When
        testHand.addCards(testHand2.getPlayerHand());
        // Then
        Integer actual = testHand.getPlayerHand().size();
        Integer expected = 9;
        Assert.assertEquals(expected,actual);

    }


    @Test
    public void getRank() {

        // When
        ArrayList<String> actual = testHand.getRank();
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("2", "3", "2", "3", "2", "3", "2"));
        // Then
        Assert.assertEquals(expected, actual);
    }
}

