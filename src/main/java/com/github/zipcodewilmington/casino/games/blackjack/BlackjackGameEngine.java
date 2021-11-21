package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.deck.Hand;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Locale;

public class BlackjackGameEngine implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.YELLOW);
    private PlayerInterface player;
    private Integer playerBet;
    private Integer balance;
    private String input;
    private BlackjackGame bj = new BlackjackGame();
    private String playInput;
    private String continueInput;
    private String winner;

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
        welcomeToBlackjack();

        //user selects if they want to play or leave
        while (input != "exit") {
            input = getBJDashboardInput().toLowerCase();
            switch (input) {
                case "play":
                    bjStart();
                case "rules":
                    rules();
                    break;
                default:
                    input = getBJDashboardInput().toLowerCase();
            }
        }
    }

    private void welcomeToBlackjack() {
        System.out.println("┬ ┬┌─┐┬  ┌─┐┌─┐┌┬┐┌─┐  ┌┬┐┌─┐\n" +
                "│││├┤ │  │  │ ││││├┤    │ │ │\n" +
                "└┴┘└─┘┴─┘└─┘└─┘┴ ┴└─┘   ┴ └─┘\n" +
                "╔╗ ╦  ╔═╗╔═╗╦╔═ ╦╔═╗╔═╗╦╔═  ┬\n" +
                "╠╩╗║  ╠═╣║  ╠╩╗ ║╠═╣║  ╠╩╗  │\n" +
                "╚═╝╩═╝╩ ╩╚═╝╩ ╩╚╝╩ ╩╚═╝╩ ╩  o");
    }

    public void bjStart() {
        balance = player.getArcadeAccount().getUserBalance();
        playerBet = 0;
        Boolean gameRuns = true;


        while (gameRuns) {
            bj.newRound();
            playerBet = getBetInput();

            bj.initialHand();
            bj.displayHandsOneHidden();

            playInput = getPlayInput();

            while (playInput.equalsIgnoreCase("h")) {
                bj.hit(bj.getPlayerHand());
                bj.displayHandsOneHidden();

                if (bj.bust(bj.getPlayerHand())) {
                    player.getArcadeAccount().setUserBalance(balance - playerBet);
                    balance = player.getArcadeAccount().getUserBalance();

                    System.out.println("Busted! You've lost this round." +
                            "\nYour current balance is: " + balance);

                    continueInput = getContinueInput();
                    if (continueInput.equalsIgnoreCase("no")) {
                        gameRuns = false;
                    }
                    break;
                }
                playInput = getPlayInput();
            }

            if (playInput.equalsIgnoreCase("s")) {
                bj.displayHands();
                bj.dealerPlay();

                winner = bj.checkWinner(bj.getPlayerHand(), bj.getDealerHand());

                if (winner.equals("player")) {
                }
            }
        }

    }



    private String getBJDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to Blackjack, " + player.getArcadeAccount().getUserName() + "!")
                .append("\nWhat would you like to do?")
                .append("\n[ play ] [ rules ] [ exit ]")
                .toString());
    }

    private String getContinueInput() {
        while(true) {
            String output = console.getStringInput(new StringBuilder()
                    .append("\nWould you like to play a new round?")
                    .append("\n[ yes ] [ no ]")
                    .toString());
            if (output.equalsIgnoreCase("yes")
                    || output.equalsIgnoreCase("no")) {
                return output;
            }
        }
    }

    private Integer getBetInput() {
        balance = player.getArcadeAccount().getUserBalance();

        while (true) {
            Integer output = console.getIntegerInput(new StringBuilder()
                    .append("\nHow much would you like to bet?")
                    .append("\nYour current balance is: " + balance)
                    .toString());
            if (output < 1) {
                System.out.println("You must bet at least $1.");
            } else if (output > balance) {
                System.out.println("You cannot bet more than you have." +
                        "\nCurrent balance: " + balance);
            } else {
                return output;
            }
        }
    }

    private String getPlayInput() {
        while(true) {
            String output = console.getStringInput(new StringBuilder()
                    .append("\nWould you like to:")
                    .append("\n[ h - hit ] [ s - stand ] [ dd - double down ]?")
                    .toString());
            if (output.equalsIgnoreCase("h")
            || output.equalsIgnoreCase("s")
            || output.equalsIgnoreCase("dd")) {
                return output;
            }
        }
    }

    private void rules() {
        System.out.println(new StringBuilder()
                .append("\nObjective: Try to get as close to 21 as possible without going over.")
                .append("\nDuring your turn, you can choose to either hit, stand or double-down.")
                .append("\nIf you go over 21, you bust! If your first two cards total to 21, that is considered a Blackjack.")
                .append("\nIf you win with Blackjack, you'll get double your bet amount.")
                .append("\nAnd that's it! Good luck!")
                .append("\n- Credits to Bicycle Cards\n")
                .toString());
    }


}
