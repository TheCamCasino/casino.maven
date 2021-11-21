package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.CasinoTextArt;
import com.github.zipcodewilmington.utils.IOConsole;

public class BlackjackGameEngine implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.WHITE);
    private final IOConsole cyanConsole = new IOConsole(AnsiColor.CYAN);
    private final IOConsole redConsole = new IOConsole(AnsiColor.RED);
    private CasinoTextArt welcomeArt = new CasinoTextArt();
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
        welcomeArt.welcomeToBlackjackArt();

        //user selects if they want to play or leave
        while (input != "exit") {
            input = getBJDashboardInput().toLowerCase();
            switch (input) {
                case "play":
                    bjStart();
                    break;
                case "rules":
                    rules();
                    break;
                case "exit":
                    return;
            }
        }
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

                    redConsole.println("\nBusted! You've lost this round." +
                            "\nCurrent balance is: " + balance);
                    break;
                }
                playInput = getPlayInput();
            }

            if (playInput.equalsIgnoreCase("dd")) {
                bj.hit(bj.getPlayerHand());
                bj.displayDoubleDown();
                playInput = "s";
            }

            if (playInput.equalsIgnoreCase("s")) {
                bj.dealerPlay();
                winner = bj.checkWinner(bj.getPlayerHand(), bj.getDealerHand());

                if (winner.equals("bj win")) {
                    bj.displayHands();
                    player.getArcadeAccount().setUserBalance(balance + (playerBet*2));
                    balance = player.getArcadeAccount().getUserBalance();

                    cyanConsole.println("\nYou got Blackjack! Your winnings are doubled." +
                            "\nCurrent balance is: " + balance);

                }
                else if (winner.equals("bj win dealer bust")) {
                    bj.displayHands();
                    player.getArcadeAccount().setUserBalance(balance + (playerBet*2));
                    balance = player.getArcadeAccount().getUserBalance();

                    cyanConsole.println("\nDealer busts! You got Blackjack! Your winnings are doubled." +
                            "\nCurrent balance is: " + balance);

                }
                else if (winner.equals("std win")) {
                    bj.displayHands();
                    player.getArcadeAccount().setUserBalance(balance + playerBet);
                    balance = player.getArcadeAccount().getUserBalance();

                    cyanConsole.println("\nYou win this round." +
                            "\nCurrent balance is: " + balance);

                }
                else if (winner.equals("win dealer bust")) {
                    bj.displayHands();
                    player.getArcadeAccount().setUserBalance(balance + playerBet);
                    balance = player.getArcadeAccount().getUserBalance();

                    cyanConsole.println("\nDealer busts! You win this round." +
                            "\nCurrent balance is: " + balance);

                } else if (winner.equals("dealer win")) {
                    bj.displayHands();
                    player.getArcadeAccount().setUserBalance(balance - playerBet);
                    balance = player.getArcadeAccount().getUserBalance();

                    redConsole.println("You lose this round!" +
                            "\nCurrent balance is: " + balance);

                } else {
                    bj.displayHands();
                    System.out.println("\nThis round is a tie.");
                }
            }

            continueInput = getContinueInput();
            if (continueInput.equalsIgnoreCase("no")) {
                gameRuns = false;
            }
        }
    }

    private String getBJDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("\nWelcome to Blackjack, " + player.getArcadeAccount().getUserName() + "!")
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
                System.out.println("\nYou must bet at least $1.");
            } else if (output > balance) {
                System.out.println("\nYou cannot bet more than you have." +
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
        cyanConsole.println(new StringBuilder()
                .append("\nObjective: Try to get as close to 21 as possible without going over.")
                .append("\nDuring your turn, you can choose to either hit, stand or double-down.")
                .append("\nIf you go over 21, you bust! If your first two cards total to 21, that is considered a Blackjack.")
                .append("\nIf you win with Blackjack, you'll get double your bet amount.")
                .append("\nAnd that's it! Good luck!")
                .append("\n- Credits to Bicycle Cards")
                .toString());
    }


}
