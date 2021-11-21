package com.github.zipcodewilmington.casino.games.Roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class RoulettePlayer implements PlayerInterface {
    private CasinoAccount casinoAccount;

    public RoulettePlayer(CasinoAccount casinoAccount){
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
}