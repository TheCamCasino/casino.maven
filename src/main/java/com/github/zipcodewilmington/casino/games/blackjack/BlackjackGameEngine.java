package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Locale;

public class BlackjackGameEngine implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.YELLOW);
    private PlayerInterface player;
    private Integer playerBet;
    private Integer balance;
    private String input;

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
        welcomeToBlackjack();
        //user selects if they want to play or leave
        input = getBJDashboardInput().toLowerCase();

        switch (input) {
            case "play":
                bjStart();
                break;
            case "rules":
                rules();
                break;
            case "exit":
                break;
        }

    }

    private String welcomeToBlackjack() {
        return new StringBuilder()
                .append("┬ ┬┌─┐┬  ┌─┐┌─┐┌┬┐┌─┐  ┌┬┐┌─┐\n" +
                        "│││├┤ │  │  │ ││││├┤    │ │ │\n" +
                        "└┴┘└─┘┴─┘└─┘└─┘┴ ┴└─┘   ┴ └─┘\n" +
                        "╔╗ ╦  ╔═╗╔═╗╦╔═ ╦╔═╗╔═╗╦╔═  ┬\n" +
                        "╠╩╗║  ╠═╣║  ╠╩╗ ║╠═╣║  ╠╩╗  │\n" +
                        "╚═╝╩═╝╩ ╩╚═╝╩ ╩╚╝╩ ╩╚═╝╩ ╩  o")
                .toString();
    }

    public void bjStart() {

    }

    private String getBJDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to Blackjack, " + player.getArcadeAccount().getUserName() + "!")
                .append("What would you like to do?")
                .append("\n [ play ] [ rules ] [ exit ]")
                .toString());
    }

    private String rules() {
        return new StringBuilder().toString();
    }


}
