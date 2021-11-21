package com.github.zipcodewilmington.casino.games.GoFish;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class GoFishPlayer implements PlayerInterface {
    private CasinoAccount casinoAccount;

    public GoFishPlayer(CasinoAccount casinoAccount) {
      this.casinoAccount = casinoAccount;
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return this.casinoAccount;

    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }


    public Integer getBalance() {
        return this.casinoAccount.getUserBalance();
    }

    public String getUserName() {
        return this.casinoAccount.getUserName();
    }

    public String getUserPassword() {
        return this.casinoAccount.getUserPassword();
    }

}
