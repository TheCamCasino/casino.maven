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

    public void setPlayerHand(Hand hand) {
        this.playerHand = hand;
    }

    public Hand getDealerHand() {
        return this.dealerHand;
    }

    public void setDealerHand(Hand hand) {
        this.dealerHand = hand;
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

    public String dealerPlay() {
        if (dealerHand.getValue() > 17 && !bust(getDealerHand())) {
            return "dealer stands";
        } else if (dealerHand.getValue() < 17) {
            dealerHand.addCard(deck.dealCard());
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

    public void displayHands() {
        System.out.println(new StringBuilder()
                .append("Dealer's Cards")
                .append("\n" + dealerHand.showHand())
                .append("\nPlayer's Cards")
                .append("\n" + playerHand.showHand())
                .append("\nPlayer's hand value: " + playerHand.getValue())
                .toString());
    }

    public void displayHandsOneHidden() {
        System.out.println(new StringBuilder()
                .append("\u001BDealer's Cards")
                .append("\n" + dealerHand.getPlayerCard(0) + "[??]\n")
                .append("\nPlayer's Cards")
                .append("\n" + playerHand.showHand())
                .append("\nPlayer's hand value: " + playerHand.getValue())
                .toString());
    }
}
