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

    public void setDealerHand(Hand hand) {
        this.dealerHand = hand;
    }

    public void hit(Hand hand) {
        hand.addCard(deck.dealCard());
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

    public void dealerPlay() {
        while (true) {
            if (bust(dealerHand)) {
                break;
            } else if (dealerHand.getValue() >= 17 && dealerHand.getValue() < 22) {
                break;
            } else if (dealerHand.getValue() < 17) {
                hit(dealerHand);
            }
        }
    }

    public String checkWinner(Hand playerHand, Hand dealerHand) {
        Integer playerHandValue = playerHand.getValue();
        Integer dealerHandValue = dealerHand.getValue();
        Boolean dealerIsBust = bust(dealerHand);
        Boolean isBlackjack = checkIfBlackjack(playerHand).equals("blackjack");

            if (isBlackjack) {
                if (playerHandValue > dealerHandValue) {
                    return "bj win";
                } else if (playerHandValue < dealerHandValue && dealerIsBust) {
                    return "bj win dealer bust";
                }
            } else if (playerHandValue > dealerHandValue) {
                return "std win";
            } else if (playerHandValue < dealerHandValue && dealerIsBust) {
                return "win dealer bust";
            } else if (playerHandValue < dealerHandValue) {
                return "dealer win";
            }
            return "tie";
    }

    public void newRound() {
        dealerHand.clearHand();
        playerHand.clearHand();
    }

    public String checkIfBlackjack(Hand hand) {
        if (hand.getHandSize().equals(2) && hand.containsAce() && hand.containsTenCard()) {
            return "blackjack";
        } else {
            return "not blackjack";
        }
    }

    public void displayHands() {
        System.out.println(new StringBuilder()
                .append("Dealer's Cards")
                .append("\n" + dealerHand.showHand())
                .append("\nPlayer's Cards")
                .append("\n" + playerHand.showHand())
                .append("\nPlayer's hand value: " + playerHand.getValue()));
    }

    public void displayHandsOneHidden() {
        System.out.println(new StringBuilder()
                .append("\u001BDealer's Cards")
                .append("\n" + dealerHand.getPlayerCard(0) + "[??]\n")
                .append("\nPlayer's Cards")
                .append("\n" + playerHand.showHand())
                .append("\nPlayer's hand value: " + playerHand.getValue()));
    }

    public void displayDoubleDown() {
        System.out.println(new StringBuilder()
                .append("\u001BDealer's Cards")
                .append("\n" + dealerHand.showHand())
                .append("\nPlayer's Cards")
                .append("\n" + playerHand.getPlayerCard(0)
                        + playerHand.getPlayerCard(1) + "[??]"));
    }
}
