package com.github.zipcodewilmington.casino.games.GoFish;

import com.github.zipcodewilmington.Casino;
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

    @Before
    public void setup() {
        goFishGameEngine = new GoFishGameEngine();
        testHand = new GoFishHand();
    }

    @Test
    public void isOver_flagSetToFalseByDefault_isFalse() {
         // given
        boolean expected = false;
        // when
        boolean returned = goFishGameEngine.isOver();
        // then
        Assert.assertEquals(false, returned);
    }

    @Test
    public void isOver_flagSetToFalseByDefault_isTrue() {
        // given
        goFishGameEngine.setIsOver(true);
        // when
        boolean returned = goFishGameEngine.isOver();
        // then
        Assert.assertTrue(returned);
    }


    @Test
    public void isConstructorNull() {

    }

    @Test
    public void dealShuffleTest() {
     Deck deck = new Deck();

    }
    @Test
    public void dealCardsTest() {


        deck.shuffle();
        for (int i = 0; i < 5; i++) {
            opponentHand.addPlayerCards(deck.dealCard());
            playerHand.addPlayerCards(deck.dealCard());
    }

    @Test
    public void chooseCardChoiceTest() {

    }


    @Test
    public void removeRanksTest() {
        // given
        Card twoOfHearts = new Card(Suit.HEARTS, Rank.TWO);
        Card threeOfHearts = new Card(Suit.HEARTS, Rank.THREE);
        testHand.addPlayerCards(twoOfHearts);
        testHand.addPlayerCards(threeOfHearts);

        String givenConsolePlayerInput = "3";

        String expectedHandString = "[2♥]";
        // when
        goFishGameEngine.removeRanks(testHand, givenConsolePlayerInput);
        String returnedHandString = testHand.showPlayerHand();
        //  then
         Assert.assertEquals(expectedHandString, returnedHandString);
    }

    @Test
    public void addTest() {
        // given
        Card twoOfHearts = new Card(Suit.HEARTS, Rank.TWO);
        Card threeOfHearts = new Card(Suit.HEARTS, Rank.THREE);
        testHand.addPlayerCards(twoOfHearts);
        testHand.addPlayerCards(threeOfHearts);
        // when


        // then
       // Assert.assertEquals(expectedHand, returnedHand);
    }
    @Test
    public void showPlayersHandTest() {  //Showing both player's hand
        //
    }
    @Test
    public void remove() {
    }

    @Test
    public void fish() {
    }

}