package com.github.zipcodewilmington.casino.games.deck;

public enum Rank {
    ACE(1, 11, "A"),
    TWO(2, 2, "2"),
    THREE(3, 3, "3"),
    FOUR(4, 4, "4"),
    FIVE(5, 5, "5"),
    SIX(6, 6, "6"),
    SEVEN(7, 7, "7"),
    EIGHT(8, 8, "8"),
    NINE(9, 9, "9"),
    TEN(10, 10, "10"),
    JACK(11, 10, "J"),
    QUEEN(12, 10, "Q"),
    KING(13, 10, "K");

    private final Integer primaryValue;
    private final Integer secondaryValue;
    private final String rankSymbol;

    Rank(Integer value, String rankSymbol) {
        this.primaryValue = value;
        this.secondaryValue = value;
        this.rankSymbol = rankSymbol;
    }

    Rank(Integer primaryValue, Integer secondaryValue, String rankSymbol) {
        this.primaryValue = primaryValue;
        this.secondaryValue = secondaryValue;
        this.rankSymbol = rankSymbol;
    }

    public Integer getPrimaryValue() {
        return primaryValue;
    }

    public Integer getSecondaryValue() {
        return secondaryValue;
    }

    public String toString() {
        return this.rankSymbol;
    }

}
