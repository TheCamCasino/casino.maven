package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import org.junit.Assert;
import org.junit.Test;

public class CasinoAccountManagerTest {

    @Test
    public void CasinoAccountManagerTest() {
        //Given
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        CasinoAccount spongebob = casinoAccountManager.createAccount("sponge", "bob");

        //When
        casinoAccountManager.registerAccount(spongebob);
        CasinoAccount actual = casinoAccountManager.getAccount("sponge");

        //Then
        Assert.assertEquals(spongebob, actual);
    }


}
