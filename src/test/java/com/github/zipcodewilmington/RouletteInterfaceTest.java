package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.Roulette.RouletteGame;
import com.github.zipcodewilmington.casino.games.Roulette.RouletteInterface;
import org.junit.Assert;
import org.junit.Test;


public class RouletteInterfaceTest {

    @Test
    public void checkIfTrioTest(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 3;
        int number1 = 1;
        int number2 = 2;
        int number3 = 3;
        //when
        Boolean actual = test.checkIfTrio(winningnumber,number1,number2,number3);
        Boolean expected = true;
        //then
        Assert.assertEquals(actual,expected);
    }
}
