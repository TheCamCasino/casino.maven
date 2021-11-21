package com.github.zipcodewilmington.casino.games.GoFish;

import com.github.zipcodewilmington.casino.CasinoAccount;
import org.junit.Assert;
import org.junit.Test;


public class GoFishPlayerTest {

    @Test
    public void getBalanceTest() {
        //Given
        CasinoAccount casinoAccount = new CasinoAccount("John", "Smith", 200);
        GoFishPlayer player = new GoFishPlayer(casinoAccount);
        Integer expected = 200;

        //When
        Integer actual = player.getBalance();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getUserNameTest() {
        //Given
        CasinoAccount casinoAccount = new CasinoAccount("John", "Smith", 200);
        GoFishPlayer player = new GoFishPlayer(casinoAccount);
        String expected = "John";

        //When
        String actual = player.getUserName();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getUserPasswordTest() {
        //Given
        CasinoAccount casinoAccount = new CasinoAccount("John", "Smith", 200);
        GoFishPlayer player = new GoFishPlayer(casinoAccount);
        String expected = "Smith";

        //When
        String actual = player.getUserPassword();

        //Then
        Assert.assertEquals(expected, actual);
    }
}