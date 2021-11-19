package com.github.zipcodewilmington.casino.games.GoFish;

import com.github.zipcodewilmington.casino.games.deck.Card;
import com.github.zipcodewilmington.casino.games.deck.Rank;
import com.github.zipcodewilmington.casino.games.deck.Suit;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GoFishHandTest {

    @Test
    void showPlayerHand() {
        //Given
        GoFishHand goFishHand = new GoFishHand();
        goFishHand.dealCards();

        //When
        String actual = goFishHand.showPlayerHand();

        //Expected
        String expected = "";

        Assert.assertEquals(actual,expected);

    }

    @Test
    void addPlayerCards() {
    }

    @Test
    void clearHand() {
    }

    @Test
    void getRank() {
        //Given

    }

    @Test
    public void getPlayerHandTest() {
        //Given
        GoFishHand player = new GoFishHand();
        Card queenOfHearts = new Card(Suit.HEARTS, Rank.QUEEN);
        Card jackOfClubs = new Card(Suit.CLUBS, Rank.JACK);
        Card sevenOfDiamonds = new Card (Suit.DIAMONDS, Rank.SEVEN);
        List<Card> list = Arrays.asList(queenOfHearts, jackOfClubs, sevenOfDiamonds);
        ArrayList<Card> expected = new ArrayList<>();
        expected.addAll(list);

        //When
        player.addPlayerCards(queenOfHearts);
        player.addPlayerCards(jackOfClubs);
        player.addPlayerCards(sevenOfDiamonds);

        System.out.println(expected);
        System.out.println(player.getPlayerHand());

        //Then
        //Assert.assertArrayEquals(expected.toString(), player.getPlayerHand().toString());

    }

    @Test
    public void getPlayerCardTest() {

    }

    @Test
    public void removeCardTest() {
        //Given
        GoFishHand player = new GoFishHand();
        Card queenOfHearts = new Card(Suit.HEARTS, Rank.QUEEN);
        Card jackOfClubs = new Card(Suit.CLUBS, Rank.JACK);
        Card sevenOfDiamonds = new Card (Suit.DIAMONDS, Rank.SEVEN);

        GoFishHand dealer = new GoFishHand();

        //When
        player.addPlayerCards(queenOfHearts);
        player.addPlayerCards(jackOfClubs);
        player.addPlayerCards(sevenOfDiamonds);

        dealer.addPlayerCards(jackOfClubs);

        dealer.removeCard(jackOfClubs, dealer.getPlayerHand(), player.getPlayerHand());

        System.out.println(player.getPlayerHand());
        System.out.println(dealer.getPlayerHand());
    }

    @Test
    void dealCards() {
    }
}