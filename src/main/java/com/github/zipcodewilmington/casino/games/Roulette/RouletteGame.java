package com.github.zipcodewilmington.casino.games.Roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

public class RouletteGame implements GameInterface {
    private PlayerInterface player;
    private final IOConsole console = new IOConsole(AnsiColor.RED);

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        String playerInput;
        RouletteInterface game = new RouletteInterface();
        boolean leaveTable = true;

        do {
            playerInput = RouletteBoardStartingMethod();

            int winningNumber = game.spinWheel();

            if(playerInput.equalsIgnoreCase("help")){
                game.bettingTypes();
            }else if(playerInput.equalsIgnoreCase("Leave Table")) {
                leaveTable = false;
                //break;
            }
//            else if(playerInput.equalsIgnoreCase("")) {
//                System.out.println("Please enter a choice");
//            }
            else {
                    console.getStringInput((new StringBuilder()
                            .append("The Winning number is " + winningNumber)
                            .toString()));
                    String[] playerBets = playerInput.split(" ");
                    int balanceChange = game.determineWinnings(playerBets, winningNumber);
                    System.out.println(balanceChange);
                }
        } while (leaveTable);
    }
    private String RouletteBoardStartingMethod() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Roulette Table")
                .append("\nPlease bet on your numbers using this format, with each separated by a space:")
                .append("\n\t[Type of Bet,#1,#2,#3,#4:amount to bet.] ")
                .toString());
    }
}
