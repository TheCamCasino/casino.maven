package com.github.zipcodewilmington.casino.games.Roulette;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class RouletteInterface {

    public static int spinWheel() {
        int spin = (int)(Math.random() * 38);
        int result = spin;
        return result;
    }

    public static int determineWinnings(String[] playerBets, int winningNumber) {
        int balanceChange = 0;

        for(String playerbet:playerBets){
            String[] breakdown = playerbet.split(":");
            int numberBetOn = Integer.valueOf(breakdown[0]);

            if (numberBetOn < 38){

            }
        }

        return balanceChange;
    }

    public static void bettingTypes() {
        final IOConsole console = new IOConsole(AnsiColor.GREEN);
        console.getStringInput((new StringBuilder()
                .append("Valid betting types are:")
                .append("\n[The exact number] [Red/Black] [Even/Odd]")
                .append("\n[High/Low] [Columns 1,2,or 3] [1st, 2nd, or 3rd Dozen]")
                .append("\n[Split] [Corner] [Line] [Trio]")
                .toString()));

    }
}