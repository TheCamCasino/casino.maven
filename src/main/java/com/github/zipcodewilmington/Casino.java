package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.GoFish.GoFishGameEngine;
import com.github.zipcodewilmington.casino.games.GoFish.GoFishPlayer;
import com.github.zipcodewilmington.casino.games.blackjack.BlackjackGameEngine;
import com.github.zipcodewilmington.casino.games.blackjack.BlackjackPlayer;
import com.github.zipcodewilmington.casino.games.Roulette.RoulettePlayer;
import com.github.zipcodewilmington.casino.games.Roulette.RouletteGame;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public class Casino implements Runnable {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    @Override
    public void run() {
        String arcadeDashBoardInput;
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();

            if ("login".equals(arcadeDashBoardInput)) {
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName);

                boolean isValidLogin = casinoAccount != null;

                if (isValidLogin && accountPassword.equals(casinoAccount.getUserPassword())) {

                    String gameSelectionInput;

                    while (true) {
                        gameSelectionInput = getGameSelectionInput().toUpperCase();
                        Boolean logout = false;

                        switch (gameSelectionInput) {
                            case "GOFISH":
                                play(new GoFishGameEngine(), new GoFishPlayer(casinoAccount));
                                break;
                            case "ROULETTE":
                                play(new RouletteGame(), new RoulettePlayer(casinoAccount));
                                break;
                            case "BLACKJACK":
                                play(new BlackjackGameEngine(), new BlackjackPlayer(casinoAccount));
                                break;
                            case "LOGOUT":
                                logout = true;
                                break;
                            default:
                                System.out.println(gameSelectionInput + " is an invalid game selection. Please try again.");
                                break;
                        }
                        if (logout) {
                            break;
                        }
                    }

                } else {
                    System.out.println("Invalid username or password. Please try again.");
                }

            } else if ("create-account".equals(arcadeDashBoardInput)) {
                console.println("Welcome to the account-creation screen.");
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");

                CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword);
                casinoAccountManager.registerAccount(newAccount);
            }

        } while (!"logout".equals(arcadeDashBoardInput));
    }

    private String getArcadeDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Arcade Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ create-account ], [ login ]")
                .toString());
    }

    private String getGameSelectionInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Game Selection Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ BLACKJACK ], [ GOFISH ], [ ROULETTE ], [ LOGOUT ]")
                .toString());
    }

    private void play(Object gameObject, Object playerObject) {
        GameInterface game = (GameInterface)gameObject;
        PlayerInterface player = (PlayerInterface)playerObject;
        game.add(player);
        game.run();
    }
}
