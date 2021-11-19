package com.github.zipcodewilmington.casino.games.Roulette;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Arrays;
import java.util.Locale;


/**
 * Created by leon on 7/21/2020.
 */
public class RouletteInterface {

    public int spinWheel() {
        int spin = (int) (Math.random() * 38);
        int result = spin;
        return result;
    }

    public int determineWinnings(String[] playerBets, int winningNumber) {
        int balanceChange = 0;
        int totalbet = 0;

        for (String playerbet : playerBets) {

            String[] whereBet = playerbet.split(":");
            String[] typeBet = whereBet[0].split(",");
            int bet = Integer.parseInt((whereBet[1]));
            int spot1 = 0;
            int spot2 = 0;
            int spot3 = 0;
            int spot4 = 0;
            totalbet = totalbet + bet;

            try {
                spot1 = Integer.parseInt(typeBet[1]);
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

        }
        if(balanceChange > 0) {
            System.out.println("you have won " + balanceChange + "");
        }else if(balanceChange <= 0){
            System.out.println("you have lost " + balanceChange + "");
        }
        return balanceChange;
    }

    public boolean checkIfTrio(int winningNumber, int spot1, int spot2, int spot3) {
        if(checkIfSplit(winningNumber,spot1,spot2) || (checkOneNumber(winningNumber,spot3))){
            return true;
        }else {
            return false;
        }
    }

    public static boolean checkIfLine(int winningNumber, int spot1, int spot2) {
        if (winningNumber >= spot1 && winningNumber <= spot2){
            return true;
        }else{
            return false;
        }
    }

    public static boolean checkIfCorner(int winningNumber, int spot1, int spot2, int spot3, int spot4) {
        if(checkIfSplit(winningNumber,spot1,spot2) || checkIfSplit(winningNumber,spot3,spot4)){
            return true;
        }else{
            return false;
        }
    }

    public static boolean checkIfSplit(int winningNumber, int spot1, int spot2) {
        if(checkOneNumber(winningNumber,spot1) || checkOneNumber(winningNumber,spot2)){
            return true;
        }else {
            return false;
        }
    }

    public static boolean checkOneNumber(int winningNumber, int spot1) {
        if(winningNumber == spot1){
            return true;
        }else{
            return false;
        }
    }

    public static boolean checkIfDozen3(int winningNumber) {
        if(winningNumber > 24 && winningNumber < 37){
            return true;
        }else{
            return false;
        }
    }

    public static boolean checkIfDozen2(int winningNumber) {
        if(winningNumber > 12 && winningNumber < 25){
            return true;
        }else{
            return false;
        }
    }

    public static boolean checkIfDozen1(int winningNumber) {
        if(winningNumber > 0 && winningNumber < 13){
            return true;
        }else{
            return false;
        }
    }

    public static boolean checkIfColumn3(int winningNumber) {
        int[] Column3 = {3,6,9,12,15,18,21,24,27,30,33,36};
        for (int i = 0; i < Column3.length; i++) {
            if (Column3[i] == winningNumber){
                return true;
            }
        }
        return false;
    }

    public static boolean checkIfColumn2(int winningNumber) {
        int[] Column2 = {2,5,8,11,14,17,20,23,26,29,32,35};
        for (int i = 0; i < Column2.length; i++) {
            if (Column2[i] == winningNumber){
                return true;
            }
        }
        return false;
    }

    public static boolean checkIfColumn1(int winningNumber) {
        int[] Column1 = {1,4,7,10,13,16,19,22,25,28,31,34};
        for (int i = 0; i < Column1.length; i++) {
            if (Column1[i] == winningNumber){
                return true;
            }
        }
        return false;
    }

    public static boolean checkIfLow(int winningNumber) {
        if(winningNumber < 19){
            return true;
        }else{
            return false;
        }
    }

    public static boolean checkIfHigh(int winningNumber) {
        if(winningNumber > 18) {
            return true;
        }else{
            return false;
        }
    }

    public static boolean checkIfOdd(int winningNumber) {
        if((winningNumber % 2) != 0) {
            return true;
        }else{
            return false;
        }
    }

    public static boolean checkIfEven(int winningNumber) {
        if((winningNumber % 2) == 0) {
            return true;
        }else{
            return false;
        }
    }

    public static boolean checkIfBlack(int winningNumber) {
        if(!checkIfRed(winningNumber)){
        return true;
        } else{
            return false;
        }
    }

    public static boolean checkIfRed(int winningNumber) {
        int[] redNumbers = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
        for (int i = 0; i < redNumbers.length; i++) {
            if (redNumbers[i] == winningNumber){
                return true;
            }
        }
        return false;
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