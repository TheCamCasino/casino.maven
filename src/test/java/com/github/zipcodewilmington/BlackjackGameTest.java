package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.blackjack.BlackjackGame;
import com.github.zipcodewilmington.casino.games.deck.Card;
import com.github.zipcodewilmington.casino.games.deck.Rank;
import com.github.zipcodewilmington.casino.games.deck.Suit;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BlackjackGameTest {
    BlackjackGame bj = new BlackjackGame();
    ArrayList<Card> presetCards = new ArrayList<>();
    Card queenOfHearts = new Card(Suit.HEARTS, Rank.QUEEN);
    Card jackOfClubs = new Card(Suit.CLUBS, Rank.JACK);
    Card sevenOfDiamonds = new Card(Suit.DIAMONDS, Rank.SEVEN);
    Card aceOfSpades = new Card(Suit.SPADES, Rank.ACE);
    Card fiveOfHearts = new Card(Suit.HEARTS, Rank.FIVE);

    @Test
    public void startingCardsPlayerTest() {
        //Given
        bj.startingCards();
        Integer expected = 2;

        //When
        Integer actual = bj.getPlayerHandSize();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void startingCardsDealerTest() {
        //Given
        bj.startingCards();
        Integer expected = 2;

        //When
        Integer actual = bj.getDealerHandSize();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealerPlayTrueTest() {
        //Given
        bj.newRound();
        presetCards.add(queenOfHearts);
        presetCards.add(jackOfClubs);
        Boolean expected = true;

        //When
        bj.setDealerHand(presetCards);
        Boolean actual = bj.dealerPlay();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealerBustTest() {
        //Given
        bj.newRound();
        presetCards.add(queenOfHearts);
        presetCards.add(jackOfClubs);
        presetCards.add(sevenOfDiamonds);
        Boolean expected = true;

        //When
        bj.setDealerHand(presetCards);
        Boolean actual = bj.dealerBust();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playerBustTest() {
        //Given
        bj.newRound();
        presetCards.add(aceOfSpades);
        presetCards.add(queenOfHearts);
        presetCards.add(jackOfClubs);
        presetCards.add(sevenOfDiamonds);
        Boolean expected = true;

        //When
        bj.setPlayerHand(presetCards);
        Boolean actual = bj.playerBust();

        //Then
        Assert.assertEquals(expected, actual);
    }
}
