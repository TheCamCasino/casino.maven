package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import org.junit.Assert;
import org.junit.Test;

public class CasinoAccountTest {

    @Test
    public void setUserNameTest() {
        // Given
        CasinoAccount casinoAccount = new CasinoAccount("John", "Wick", 1111);
        String expected = "Keanu";

        // When
        casinoAccount.setUserName(expected);
        String actual = casinoAccount.getUserName();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setUserPasswordTest() {
        // Given
        CasinoAccount casinoAccount = new CasinoAccount("John", "Wick", 1111);
        String expected = "Reeves";

        // When
        casinoAccount.setUserPassword(expected);
        String actual = casinoAccount.getUserPassword();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setUserBalanceTest() {
        // Given
        CasinoAccount casinoAccount = new CasinoAccount("John", "Wick", 1111);
        Integer expected = 1234567;

        // When
        casinoAccount.setUserBalance(expected);
        Integer actual = casinoAccount.getUserBalance();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest() {
        CasinoAccount casinoAccount = new CasinoAccount("John", "Wick", 1111);
        String expected = "Account Name is: John";

        // When

        // Then
        Assert.assertEquals(expected, casinoAccount.toString());
    }

}
