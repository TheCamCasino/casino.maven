package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

public class BlackjackGameEngine implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.YELLOW);
    private PlayerInterface player;

    @Override
    public void add(PlayerInterface player) {
        this.player = player;
    }

    @Override
    public void remove(PlayerInterface player) {
        this.player = null;
    }

    @Override
    public void run() {
        //welcome to blackjack

        //
    }

    public void bjStart() {

    }


}
