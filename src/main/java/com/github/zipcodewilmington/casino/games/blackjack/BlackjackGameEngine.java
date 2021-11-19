package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

public class BlackjackGameEngine implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.YELLOW);
    private PlayerInterface player;
    private BlackjackGame bj = new BlackjackGame();
    private Integer playerBet;
    private Integer balance;
    private String input;
    //private BlackjackPlayer player1;

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
        System.out.println("\u001B[33m>>> ♠ ♠ ♠ Welcome to Blackjack! ♠ ♠ ♠ <<<");
        balance = player.getArcadeAccount().getUserBalance();
        playerBet = 0;
        String blackjackDashboardInput;

            do {
                if (balance <= 0) {
                    throw new RuntimeException("No money? No games for you!");
                }
                blackjackDashboardInput = getBlackjackDashboardInput();

                if (blackjackDashboardInput.equalsIgnoreCase("yes")) {
                    bj.newRound();

                    //if playerBet exceeds player's balance, player must bet a different amount
                    playerBet = getBetInput();

                    while (playerBet > balance) {
                        System.out.println("Your bet exceeds your account balance of: " + balance +
                                "\nPlease bet a different amount.");
                        playerBet = getBetInput();
                    }

                    //deal and show starting cards
                    bj.startingCards();
                    System.out.println(bj.showPlayerAndDealerHands());

                    //player gets to hit or stand
                    input = getHitStandInput();
                    while (input.equalsIgnoreCase("hit")) {
                        bj.hit();

                        System.out.println(bj.showPlayerAndDealerHands());

                        if (bj.playerBust()) {
                            player.getArcadeAccount().setUserBalance(balance - playerBet);
                            balance = player.getArcadeAccount().getUserBalance();
                            System.out.println("Busted! You've lost this round. " +
                                    "Your current balance is: " + balance);
                        }
                        input = getHitStandInput();
                    }

                    if (input.equalsIgnoreCase("stand")) {
                        //player stands and dealer plays
                        System.out.println(bj.showPlayerAndFullDealerHands());
                        if (bj.dealerPlay()) {
                            System.out.println(bj.showPlayerAndFullDealerHands());

                            if (bj.playerHandValue() < bj.dealerHandValue()) {
                                player.getArcadeAccount().setUserBalance(balance - playerBet);
                                balance = player.getArcadeAccount().getUserBalance();
                                System.out.println("House wins this round.\n" +
                                        "Your current balance is: " + balance);

                            } else if (bj.playerHandValue() > bj.dealerHandValue()){
                                player.getArcadeAccount().setUserBalance(balance + playerBet);
                                balance = player.getArcadeAccount().getUserBalance();
                                System.out.println("You win this round! \n" +
                                        "Your current balance is: " + balance);

                            } else if (bj.playerHandValue().equals(bj.dealerHandValue())) {
                                System.out.println("This round is a tie. Your bet is returned to you.");
                            }
                        } else {
                            player.getArcadeAccount().setUserBalance(balance + playerBet);
                            balance = player.getArcadeAccount().getUserBalance();

                            System.out.println(bj.showPlayerAndFullDealerHands() +
                                    "You win this round! \n" +
                                    "Your current balance is: " + balance);
                        }
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

    private String getBlackjackDashboardInput() {
        return console.getStringInput("Would you like to start a new round of Blackjack?\n" +
                "[ yes ] [ no ]");
    }

    private Integer getBetInput() {
        Integer balance = player.getArcadeAccount().getUserBalance();
        return console.getIntegerInput("How much would you like to bet?\n" +
                "Your current balance is: " + balance);
    }

    private String getHitStandInput() {
        return console.getStringInput("Would you like to: \n" +
                "[ hit ] or [ stand ] ?");
    }

}
