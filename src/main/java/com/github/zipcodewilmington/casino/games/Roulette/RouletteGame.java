package com.github.zipcodewilmington.casino.games.Roulette;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

public class RouletteGame implements GameInterface {

    private final IOConsole console = new IOConsole(AnsiColor.RED);
    private PlayerInterface player;
    private RouletteInterface RG = new RouletteInterface();
    private Integer balance = 0;
    private String playerInput;

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

        balance = player.getArcadeAccount().getUserBalance();

        do {
            playerInput = RouletteBoardStartingMethod();
            int winningNumber = RG.spinWheel();

            if(playerInput.equalsIgnoreCase("help")){
                RG.bettingTypes();
            }else if(playerInput.equalsIgnoreCase("")) {
                System.out.println("Please enter a valid choice");
            }else {
                if (RG.totalBetAmount(playerInput) <= balance) {
                    try {
                        int balanceChange = RG.determineWinnings(playerInput, winningNumber);
                        player.getArcadeAccount().setUserBalance(balance + balanceChange);
                    } catch (Exception e) {

                    }
                }else{
                    console.getStringInput(new StringBuilder()
                            .append("Amount too large for your balance")
                            .append("\nPlease enter a valid amount")
                            .toString());
                }
            }
        } while (!playerInput.equalsIgnoreCase("Leave Table"));
    }
    private String RouletteBoardStartingMethod() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Roulette Table")
                .append("\nPlease bet on your numbers using this format, with each bet separated by a space:")
                .append("\n\t\t[Type of Bet,#1,#2,#3,#4:amount to bet.] ")
                .append("\n\t\t in example, to bet 50 on a corner bet of 1,2,5,6--corner,1,2,5,6:50")
                .toString());
    }
}
