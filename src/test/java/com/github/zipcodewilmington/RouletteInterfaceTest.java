package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.Roulette.RouletteGame;
import com.github.zipcodewilmington.casino.games.Roulette.RouletteInterface;
import org.junit.Assert;
import org.junit.Test;


public class RouletteInterfaceTest {

    @Test
    public void checkIfTrioTestTrue(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 3;
        int number1 = 1;
        int number2 = 2;
        int number3 = 3;
        //when
        boolean actual = test.checkIfTrio(winningnumber,number1,number2,number3);
        boolean expected = true;
        //then
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void checkIfTrioTestFalse(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 17;
        int number1 = 1;
        int number2 = 2;
        int number3 = 3;
        //when
        boolean actual = test.checkIfTrio(winningnumber,number1,number2,number3);
        boolean expected = false;
        //then
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void checkIfLineTestTrue(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 3;
        int number1 = 1;
        int number2 = 6;
        //when
        boolean actual = test.checkIfLine(winningnumber,number1,number2);
        boolean expected = true;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfLineTestFalse(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 17;
        int number1 = 1;
        int number2 = 6;
        //when
        boolean actual = test.checkIfLine(winningnumber,number1,number2);
        boolean expected = false;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfCornerTestTrue(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 2;
        int number1 = 1;
        int number2 = 2;
        int number3 = 5;
        int number4 = 6;
        //when
        boolean actual = test.checkIfCorner(winningnumber,number1,number2,number3,number4);
        boolean expected = true;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfCornerTestFalse(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 18;
        int number1 = 1;
        int number2 = 2;
        int number3 = 5;
        int number4 = 6;
        //when
        boolean actual = test.checkIfCorner(winningnumber,number1,number2,number3,number4);
        boolean expected = false;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfSplitTestTrue(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 1;
        int number1 = 1;
        int number2 = 2;
        //when
        boolean actual = test.checkIfSplit(winningnumber,number1,number2);
        boolean expected = true;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfSplitTestFalse(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 7;
        int number1 = 1;
        int number2 = 2;
        //when
        boolean actual = test.checkIfSplit(winningnumber,number1,number2);
        boolean expected = false;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkOneNumberTestTrue(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 26;
        int number1 = 26;
        //when
        boolean actual = test.checkOneNumber(winningnumber,number1);
        boolean expected = true;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkOneNumberTestFalse(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 35;
        int number1 = 26;
        //when
        boolean actual = test.checkOneNumber(winningnumber,number1);
        boolean expected = false;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfDozen3TestTrue(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 26;
        //when
        boolean actual = test.checkIfDozen3(winningnumber);
        boolean expected = true;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfDozen3TestFalse(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 7;
        //when
        boolean actual = test.checkIfDozen3(winningnumber);
        boolean expected = false;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfDozen2TestTrue(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 19;
        //when
        boolean actual = test.checkIfDozen2(winningnumber);
        boolean expected = true;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfDozen2TestFalse(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 32;
        //when
        boolean actual = test.checkIfDozen2(winningnumber);
        boolean expected = false;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfDozen1TestTrue(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 6;
        //when
        boolean actual = test.checkIfDozen1(winningnumber);
        boolean expected = true;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfDozen1TestFalse(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 18;
        //when
        boolean actual = test.checkIfDozen1(winningnumber);
        boolean expected = false;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfColumn3TestTrue(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 27;
        //when
        boolean actual = test.checkIfColumn3(winningnumber);
        boolean expected = true;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfColumn3TestFalse(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 2;
        //when
        boolean actual = test.checkIfColumn3(winningnumber);
        boolean expected = false;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfColumn2TestTrue(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 8;
        //when
        boolean actual = test.checkIfColumn2(winningnumber);
        boolean expected = true;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfColumn2TestFalse(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 1;
        //when
        boolean actual = test.checkIfColumn2(winningnumber);
        boolean expected = false;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfColumn1TestTrue(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 13;
        //when
        boolean actual = test.checkIfColumn1(winningnumber);
        boolean expected = true;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfColumn1TestFalse(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 36;
        //when
        boolean actual = test.checkIfColumn1(winningnumber);
        boolean expected = false;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfLowTestTrue(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 15;
        //when
        boolean actual = test.checkIfLow(winningnumber);
        boolean expected = true;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfLowTestFalse(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 21;
        //when
        boolean actual = test.checkIfLow(winningnumber);
        boolean expected = false;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfHighTestTrue(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 27;
        //when
        boolean actual = test.checkIfHigh(winningnumber);
        boolean expected = true;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfHighTestFalse(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 3;
        //when
        boolean actual = test.checkIfHigh(winningnumber);
        boolean expected = false;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfOddTestTrue(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 27;
        //when
        boolean actual = test.checkIfOdd(winningnumber);
        boolean expected = true;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfOddTestFalse(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 26;
        //when
        boolean actual = test.checkIfOdd(winningnumber);
        boolean expected = false;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkiFEvenTestTrue(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 12;
        //when
        boolean actual = test.checkIfEven(winningnumber);
        boolean expected = true;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkiFEvenTestFalse(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 13;
        //when
        boolean actual = test.checkIfEven(winningnumber);
        boolean expected = false;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfBlackTestTrue(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 13;
        //when
        boolean actual = test.checkIfBlack(winningnumber);
        boolean expected = true;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfBlackTestFalse(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 27;
        //when
        boolean actual = test.checkIfBlack(winningnumber);
        boolean expected = false;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfRedTestTrue(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 1;
        //when
        boolean actual = test.checkIfRed(winningnumber);
        boolean expected = true;
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkIfRedTestFalse(){
        //given
        RouletteInterface test = new RouletteInterface();
        int winningnumber = 13;
        //when
        boolean actual = test.checkIfRed(winningnumber);
        boolean expected = false;
        //then
        Assert.assertEquals(actual,expected);

    }
}
