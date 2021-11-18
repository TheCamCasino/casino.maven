package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

public class BlackjackGameEngine implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.YELLOW);
    private PlayerInterface player;
    private BlackjackGame gamePlay = new BlackjackGame();
    private Integer playerBet;
    private Boolean winner = false;
    private String input;

    @Override
    public void run() {
        Integer balance;
        System.out.println(">>> ♠ ♠ ♠ Welcome to Blackjack! ♠ ♠ ♠ <<<");

        while (!winner) {
            String blackjackDashboardInput;
            balance = player.getArcadeAccount().getUserBalance();

            do {
                blackjackDashboardInput = getBlackjackDashboardInput();

                if (blackjackDashboardInput.equalsIgnoreCase("yes")) {

                    //if playerBet exceeds player's balance, player must bet a different amount
                    playerBet = getBetInput();
                    while (playerBet > balance) {
                        System.out.println("Your bet exceeds your account balance of: " + balance +
                                "\nPlease bet a different amount.");
                        playerBet = getBetInput();
                    }

                    //deal and show starting cards
                    gamePlay.startingCards();
                    System.out.println(gamePlay.showPlayerAndDealerHands());

                    //player gets to hit or stand
                    input = getHitStandInput();
                    while (input.equalsIgnoreCase("hit")) {
                        gamePlay.hit();

                        System.out.println(gamePlay.showPlayerAndDealerHands());

                        if (gamePlay.playerBust()) {
                            System.out.println("Busted! You've lost this round.");
                            balance = balance - playerBet;
                            break;
                        }
                        input = getHitStandInput();
                    }

                /*
                Game flow:
                    - player is prompted to make a bet
                        - player's bet cannot exceed balance
                    - player is dealt 2 cards & dealer is dealt 2 cards
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

            } while (!blackjackDashboardInput.equalsIgnoreCase("no"));

        }


    }

    private String getBlackjackDashboardInput() {
        return console.getStringInput("Would you like to start a new round of Blackjack?\n" +
                "[ yes ] [ no ]");
    }

    private Integer getBetInput() {
        Integer balance = player.getArcadeAccount().getUserBalance();
        return console.getIntegerInput("How much would you like to bet? (whole values only)\n" +
                "Your current balance is: " + balance);
    }

    private String getHitStandInput() {
        return console.getStringInput("What would you like to do?\n" +
                "[ hit ] [ stand ]");
    }

    @Override
    public void add(PlayerInterface player) {
        this.player = player;
    }

    @Override
    public void remove(PlayerInterface player) {
        this.player = null;
    }
}
