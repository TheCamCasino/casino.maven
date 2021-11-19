package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.games.deck.Card;
import com.github.zipcodewilmington.casino.games.deck.Deck;
import com.github.zipcodewilmington.casino.games.deck.Hand;
import com.github.zipcodewilmington.casino.games.deck.Rank;

import java.util.ArrayList;

public class BlackjackGame {
    Deck deck;
    Hand playerHand;
    Hand dealerHand;

    public BlackjackGame() {
        this.playerHand = new Hand();
        this.dealerHand = new Hand();
        this.deck = new Deck();
        deck.shuffle();
    }

    public String showPlayerAndDealerHands() {
        return "Dealer's cards:\n" +
                dealerHand.getPlayerCard(0) + "[??]\n" +
                "Player's cards:\n" +
                playerHand.showPlayerHand() + "\n" +
                "Current hand value: " + playerHandValue() + "\n";
    }

    public String showPlayerAndFullDealerHands() {
        return "Dealer's cards:\n" +
                dealerHand.showPlayerHand() + "\n" +
                "Player's cards:\n" +
                playerHand.showPlayerHand() + "\n" +
                "Current hand value: " + playerHandValue() + "\n";
    }

    public void startingCards() {
        //deal 2 cards to dealer
        dealerHand.addCardToHand(deck.dealCard());
        dealerHand.addCardToHand(deck.dealCard());

        //deal 2 cards to player
        playerHand.addCardToHand(deck.dealCard());
        playerHand.addCardToHand(deck.dealCard());
    }

    //hit
    public void hit() {
        playerHand.addCardToHand(deck.dealCard());
    }

    //dealer and player hand values
    public Integer playerHandValue() {
        return playerHand.getValue();
    }

    public Integer dealerHandValue() {
        return dealerHand.getValue();
    }

    public Integer getPlayerHandSize() {
        return playerHand.getHandSize();
    }

    public Integer getDealerHandSize() {
        return dealerHand.getHandSize();
    }

    public Boolean dealerPlay() {
        if (dealerHandValue() < 17) {
            dealerHand.addCardToHand(deck.dealCard());

            if (dealerBust()) {
                return false;
            } else if (dealerBust()) {
                return false;
            }
            return true;
        }
        return true;
    }

    public Boolean playerBlackjack() {
        Rank firstCard = playerHand.getPlayerCard(0).getRank();
        Rank secondCard = playerHand.getPlayerCard(1).getRank();
        Rank jack = Rank.JACK;
        Rank queen = Rank.QUEEN;
        Rank king = Rank.KING;
        Rank ace = Rank.ACE;

        Boolean isTwentyOne = playerHand.getValue().equals(21);

        if (isTwentyOne) {
            if (firstCard.equals(jack) && secondCard.equals(ace)
                    || firstCard.equals(ace) && secondCard.equals(jack)) {
                return true;
            } else if (firstCard.equals(queen) && secondCard.equals(ace)
                    || firstCard.equals(ace) && secondCard.equals(queen)) {
                return true;
            } else if (firstCard.equals(king) && secondCard.equals(ace)
                    || firstCard.equals(ace) && secondCard.equals(king)) {
                return true;
            }
        }
        return false;
    }

    public Boolean playerBust() {
        if (playerHand.getValue() > 21) {
            return true;
        }
        return false;
    }

    public Boolean dealerBust() {
        if (dealerHand.getValue() > 21) {
            return true;
        }
        return false;
    }

    public void newRound() {
        playerHand.clearHand();
        dealerHand.clearHand();
    }

    public Integer setDealerHand(ArrayList<Card> cards) {
        dealerHand.setPlayerHand(cards);
        return playerHandValue();
    }

    public Integer setPlayerHand(ArrayList<Card> cards) {
        playerHand.setPlayerHand(cards);
        return playerHandValue();
    }

}
