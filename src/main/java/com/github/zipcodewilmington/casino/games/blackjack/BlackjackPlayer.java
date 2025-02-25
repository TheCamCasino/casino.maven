package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class BlackjackPlayer implements PlayerInterface {
    private CasinoAccount casinoAccount;

    public BlackjackPlayer(CasinoAccount casinoAccount) {
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
}
