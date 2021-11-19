package com.github.zipcodewilmington.casino.games.Roulette;

import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

public class RouletteGame implements GameInterface {
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
        do {
            playerInput = RouletteBoardStartingMethod();

            int winningNumber = game.spinWheel();

            if(playerInput.equalsIgnoreCase("help")){
                game.bettingTypes();
                continue;
            }else {
                console.getStringInput((new StringBuilder()
                        .append("The Winning number is " + winningNumber)
                        .toString()));
                String[] playerBets = playerInput.split(" ");
                int balanceChange = game.determineWinnings(playerBets, winningNumber);
                RoulettePlayer.accountBalance(balanceChange);


            }} while (!"Leave Table".equals(playerInput));

    }
    private String RouletteBoardStartingMethod() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Roulette Table")
                .append("\nPlease bet on your numbers using this format, with each separated by a space:")
                .append("\n\t[#:amount to bet] [type of bet,number1,number2,number3,number4:amount]")
                .toString());
    }
}
