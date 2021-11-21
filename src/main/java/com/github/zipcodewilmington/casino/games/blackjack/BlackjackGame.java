package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.games.deck.Deck;
import com.github.zipcodewilmington.casino.games.deck.Hand;

public class BlackjackGame {

    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;

    public BlackjackGame() {
        this.deck = new Deck();
        this.playerHand = new Hand();
        this.dealerHand = new Hand();
        deck.shuffle();
    }

    public BlackjackGame(Deck deck, Hand playerHand, Hand dealerHand) {
        this.deck = deck;
        this.playerHand = playerHand;
        this.dealerHand = dealerHand;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public Hand getPlayerHand() {
        return this.playerHand;
    }

    public Hand getDealerHand() {
        return this.dealerHand;
    }

    public void hit(Hand hand) {
        hand.addCard(deck.dealCard());
    }

    public String checkWinner(Hand playerHand, Hand dealerHand) {
        Integer playerHandValue = playerHand.getValue();
        Integer dealerHandValue = dealerHand.getValue();

        if (playerHandValue > dealerHandValue) {
            return "player";
        } else if (playerHandValue < dealerHandValue) {
            return "dealer";
        } else if (playerHandValue.equals(dealerHandValue)) {
            return "tie";
        }
        return null;
    }

    public Boolean bust(Hand hand) {
        if (hand.getValue() > 21) {
            return true;
        }
        return false;
    }

    public void initialHand() {
        dealerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());
    }

    public void doubleDown() {
        playerHand.addCard(deck.dealCard());
    }

    public String dealerPlay(Hand hand) {
        if (hand.getValue() > 17) {
            return "dealer stands";
        } else if (hand.getValue() < 17) {
            hand.addCard(deck.dealCard());
            return "dealer hits";
        }
        return null;
    }

    public void newRound() {
        dealerHand.clearHand();
        playerHand.clearHand();
    }

    public String checkIfBlackjack(Hand hand) {
        if (hand.getHandSize().equals(2) && hand.containsAce() && hand.containsTenCard()) {
            return "blackjack";
        }
        return null;
    }

    public String displayHands() {
        return new StringBuilder()
                .append("Dealer's Cards")
                .append("\n" + dealerHand.showHand())
                .append("\nPlayer's Cards")
                .append("\n" + playerHand.showHand())
                .append("\nPlayer's hand value: " + playerHand.getValue())
                .toString();
    }

    public String displayHandsOneHidden() {
        return new StringBuilder()
                .append("\u001BDealer's Cards")
                .append("\n" + dealerHand.getPlayerCard(0) + "[??]\n")
                .append("\n" + "\u001BPlayer's Cards")
                .append("\n" + "\u001B" + playerHand.showHand())
                .append("\n" + "\u001BPlayer's hand value: " + playerHand.getValue())
                .toString();
    }
}
