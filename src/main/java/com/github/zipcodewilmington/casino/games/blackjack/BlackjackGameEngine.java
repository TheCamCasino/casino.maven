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

        do {
            bj.newRound();
            playerBet = getBetInput();

            while (playerBet > balance || playerBet < 0) {
                System.out.println("That is an invalid bet amount. Please try again.");
            }

            bj.initialHand();
            bj.displayHandsOneHidden();

            String playInput;

            do {
                playInput = getPlayInput();

                while (playInput.equalsIgnoreCase("h")) {
                    bj.hit(bj.getPlayerHand());
                    bj.displayHandsOneHidden();

                    if (bj.bust(bj.getPlayerHand())) {

                        player.getArcadeAccount().setUserBalance(balance - playerBet);
                        player.getArcadeAccount().getUserBalance();

                        System.out.println("Busted! You've lost this round." +
                                "\nYour current balance is: " + balance);
                        break;
                    }
                    playInput = getPlayInput();
                }

                if (playInput.equalsIgnoreCase("s")) {
                    bj.displayHands();
                    bj.dealerPlay();
                    String winningPlayer = bj.checkWinner(bj.getPlayerHand(), bj.getDealerHand());
                    WLOutput(winningPlayer);
                    gameRuns = false;
                }
            } while (gameRuns);

            String continuePlay = getContinueInput();
            if (continuePlay.equals("no")) {
                break;
            }

        } while (balance > 0);
    }

    private void deductPlayerBalance() {
        player.getArcadeAccount().setUserBalance(balance - playerBet);
        player.getArcadeAccount().getUserBalance();
    }

    private void increasePlayerBalanceStandard() {
        player.getArcadeAccount().setUserBalance(balance + playerBet);
        player.getArcadeAccount().getUserBalance();
    }

    private void increasePlayerBetDouble() {
        player.getArcadeAccount().setUserBalance(balance + (playerBet*2));
        player.getArcadeAccount().getUserBalance();
    }

    private void WLOutput(String winner) {
        String isBlackjack;

        if (winner.equals("dealer stands")) {
            winner = bj.checkWinner(bj.getPlayerHand(), bj.getDealerHand());
            isBlackjack = bj.checkIfBlackjack(bj.getPlayerHand());

            if (winner.equals("player") && isBlackjack.equals("blackjack")) {

                increasePlayerBetDouble();
                System.out.println("You got blackjack! Your winnings are doubled." +
                        "\nYour current balance is: " + balance);

            } else if (winner.equals("player")) {

                increasePlayerBalanceStandard();
                System.out.println("You win this round!" +
                        "\nYour current balance is: " + balance);

            } else if (winner.equals("dealer")) {

                deductPlayerBalance();
                System.out.println("Sorry! Dealer wins this round." +
                        "\nYour current balance is: " + balance);

            } else if (winner.equals("tie")) {
                System.out.println("This round is a tie. Your bet is returned to you.");
            }

        } else if (winner.equals("dealer hits")) {
            isBlackjack = bj.checkIfBlackjack(bj.getPlayerHand());
            if (bj.bust(bj.getDealerHand()) && isBlackjack.equals("blackjack")) {
                bj.displayHands();
                increasePlayerBetDouble();
                System.out.println("Dealer busted and you got blackjack! Your winnings are doubled." +
                        "\nYour current balance is: " + balance);
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
        return console.getStringInput(new StringBuilder()
                .append("\nWould you like to play another round?")
                .append("\n[ yes ] [ no ]")
                .toString());
    }

    private Integer getBetInput() {
        balance = player.getArcadeAccount().getUserBalance();
        return console.getIntegerInput(new StringBuilder()
                .append("\nHow much would you like to bet?")
                .append("\nYour current balance is: " + balance)
                .toString());
    }

    private String getPlayInput() {
        return console.getStringInput(new StringBuilder()
                .append("\nWould you like to:")
                .append("\n[ h - hit ] [ s - stand ] [ dd - double down ]?")
                .toString());
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
