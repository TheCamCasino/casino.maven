package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

public class BlackjackGameEngine implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.YELLOW);
    PlayerInterface player;

    @Override
    public void add(PlayerInterface player) {
        this.player = player;
    }

    @Override
    public void remove(PlayerInterface player) {
        this.player = null;
    }

    @Override
    public void run() {
        String blackjackDashboardInput;
        Integer playerBet;

        do {
            blackjackDashboardInput = getBlackjackDashboardInput();

            if (blackjackDashboardInput.equalsIgnoreCase("play")) {
                playerBet = getBetInput();
                Integer balance = player.getArcadeAccount().getUserBalance();

                //if playerBet exceeds player's balance, player must bet a different amount
                while (playerBet > balance) {
                    System.out.println("Your bet exceeds your account balance of: " + balance +
                            "\nPlease bet a different amount.");
                    playerBet = getBetInput();
                }

                /*
                Game flow:
                    - player is prompted to make a bet
                    - player's bet cannot exceed balance
                    - player is dealt 2 cards
                    - dealer is dealt 2 cards
                    - player goes first, prompted to hit/stand/split
                    - check player's hand for total - bust(immediate loss)/blackjack
                    - dealer goes next if player stands or has blackjack
                    - dealer reveals 2nd card
                    - if dealer hand total = 17, stand
                    - if dealer hand total <= 16, hit
                    - compare player and dealer hands for winner
                    - increase or decrease player balance
                 */

            }

        } while (!blackjackDashboardInput.equalsIgnoreCase("leave"));

    }

    private String getBlackjackDashboardInput() {
        return console.getStringInput("Welcome to Blackjack!\n" +
                "What would you like to do?\n" +
                "[ play ] [ leave ]");
    }

    private Integer getBetInput() {
        return console.getIntegerInput("How much would you like to bet? (whole values only)");
    }
}
