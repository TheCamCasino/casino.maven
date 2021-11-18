package com.github.zipcodewilmington.casino.games.Roulette;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Locale;
import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class RouletteInterface {

    public static int spinWheel() {
        int spin = (int) (Math.random() * 38);
        int result = spin;
        return result;
    }

    public static int determineWinnings(String[] playerBets, int winningNumber) {
        int balanceChange = 0;

        for (String playerbet : playerBets) {
            String[] whereBet = playerbet.split(":");
            String[] typeBet = whereBet[0].split(",");
            int bet = Integer.parseInt((whereBet[1]));
            int spot1 = Integer.parseInt(typeBet[1]);
            int spot2 = 0;
            int spot3 = 0;
            int spot4 = 0;

            try {
                spot2 = Integer.parseInt(whereBet[2]);
                spot3 = Integer.parseInt(whereBet[3]);
                spot4 = Integer.parseInt(whereBet[4]);

            }catch (Exception e){

            }
            String word = typeBet[0].toUpperCase(Locale.ROOT);
            switch (word) {
                case "RED":
                    balanceChange = balanceChange - bet;
                    if (checkIfRed(winningNumber)) {
                        balanceChange = balanceChange + (2 * bet);
                    }
                    break;
                case "BLACK":
                    balanceChange = balanceChange - bet;
                    if (checkIfBlack(winningNumber)) {
                        balanceChange = balanceChange + (2 * bet);
                    }
                    break;
                case "EVEN":
                    balanceChange = balanceChange - bet;
                    if (checkIfEven(winningNumber)) {
                        balanceChange = balanceChange + (2 * bet);
                    }
                    break;
                case "ODD":
                    balanceChange = balanceChange - bet;
                    if (checkIfOdd(winningNumber)) {
                        balanceChange = balanceChange + (2 * bet);
                    }
                    break;
                case "HIGH":
                    balanceChange = balanceChange - bet;
                    if (checkIfHigh(winningNumber)) {
                        balanceChange = balanceChange + (2 * bet);
                    }
                    break;
                case "LOW":
                    balanceChange = balanceChange - bet;
                    if (checkIfLow(winningNumber)) {
                        balanceChange = balanceChange + (2 * bet);
                    }
                    break;
                case "COLUMN1":
                    balanceChange = balanceChange - bet;
                    if (checkIfColumn1(winningNumber)) {
                        balanceChange = balanceChange + (3 * bet);
                    }
                    break;
                case "COLUMN2":
                    balanceChange = balanceChange - bet;
                    if (checkIfColumn2(winningNumber)) {
                        balanceChange = balanceChange + (3 * bet);
                    }
                    break;
                case "COLUMN3":
                    balanceChange = balanceChange - bet;
                    if (checkIfColumn3(winningNumber)) {
                        balanceChange = balanceChange + (3 * bet);
                    }
                    break;
                case "1STDOZEN":
                    balanceChange = balanceChange - bet;
                    if (checkIfDozen1(winningNumber)) {
                        balanceChange = balanceChange + (3 * bet);
                    }
                    break;
                case "2NDDOZEN":
                    balanceChange = balanceChange - bet;
                    if (checkIfDozen2(winningNumber)) {
                        balanceChange = balanceChange + (3 * bet);
                    }
                    break;
                case "3RDDOZEN":
                    balanceChange = balanceChange - bet;
                    if (checkIfDozen3(winningNumber)) {
                        balanceChange = balanceChange + (3 * bet);
                    }
                    break;
                case "SPLIT":
                    balanceChange = balanceChange - bet;
                    if (checkIfSplit(winningNumber,spot1,spot2)){
                        balanceChange = balanceChange + (bet * 18);
                    }
                    break;
                case "CORNER":
                    balanceChange = balanceChange - bet;
                    if(checkIfCorner(winningNumber,spot1,spot2,spot3,spot4)){
                        balanceChange = balanceChange + (bet * 9);
                    }
                    break;
                case "LINE":
                    balanceChange = balanceChange - bet;
                    if(checkIfLine(winningNumber,spot1,spot2)){
                        balanceChange = balanceChange + (bet * 6);
                    }
                    break;
                case "TRIO":
                    balanceChange = balanceChange - bet;
                    if(checkIfTrio(winningNumber,spot1,spot2,spot3)){
                        balanceChange = balanceChange + (bet * 12);
                    }
                    break;
                case "STRAIGHT":
                    balanceChange = balanceChange - bet;
                    if (checkOneNumber(winningNumber,spot1)){
                        balanceChange = balanceChange + (bet *37);
                    }
                    break;
            }
            System.out.println(balanceChange);
        }
        return balanceChange;
    }

    private static boolean checkIfTrio(int winningNumber, int spot1, int spot2, int spot3) {
        return true;
    }

    private static boolean checkIfLine(int winningNumber, int spot1, int spot2) {
        return true;
    }

    private static boolean checkIfCorner(int winningNumber, int spot1, int spot2, int spot3, int spot4) {
        return true;
    }

    private static boolean checkIfSplit(int winningNumber, int spot1, int spot2) {
        return true;
    }

    private static boolean checkOneNumber(int winningNumber, int spot1) {
        return  true;
    }

    private static boolean checkIfDozen3(int winningNumber) {
        return true;
    }

    private static boolean checkIfDozen2(int winningNumber) {
        return true;
    }

    private static boolean checkIfDozen1(int winningNumber) {
        return true;
    }

    private static boolean checkIfColumn3(int winningNumber) {
        return true;
    }

    private static boolean checkIfColumn2(int winningNumber) {
        return true;
    }

    private static boolean checkIfColumn1(int winningNumber) {
        return true;
    }

    private static boolean checkIfLow(int winningNumber) {
        return true;
    }

    private static boolean checkIfHigh(int winningNumber) {
        return true;
    }

    private static boolean checkIfOdd(int winningNumber) {
        return true;
    }

    private static boolean checkIfEven(int winningNumber) {
        return true;
    }

    private static boolean checkIfBlack(int winningNumber) {
        return true;
    }

    private static boolean checkIfRed(int winningNumber) {
        return true;
    }

    public static void bettingTypes() {
        final IOConsole console = new IOConsole(AnsiColor.GREEN);
        console.getStringInput((new StringBuilder()
                .append("Valid betting types are:")
                .append("\n[Straight] [Red/Black] [Even/Odd]")
                .append("\n[High/Low] [Columns 1,2,or 3] [1st, 2nd, or 3rd Dozen]")
                .append("\n[Split] [Corner] [Line] [Trio]")
                .toString()));

    }
}