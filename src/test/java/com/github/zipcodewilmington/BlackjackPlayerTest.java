package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.blackjack.BlackjackPlayer;
import org.junit.Assert;
import org.junit.Test;

public class BlackjackPlayerTest {

    @Test
    public void getBalanceTest() {
        //Given
        CasinoAccount casinoAccount = new CasinoAccount("John", "Smith", 200);
        BlackjackPlayer player = new BlackjackPlayer(casinoAccount);
        Integer expected = 200;

        //When
        Integer actual = player.getBalance();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAccountTest() {
        //Given
        CasinoAccount expected = new CasinoAccount("John", "Smith", 200);
        BlackjackPlayer player = new BlackjackPlayer(expected);

        //When
        CasinoAccount actual = player.getArcadeAccount();

        //Then
        Assert.assertEquals(expected, actual);
    }
}
