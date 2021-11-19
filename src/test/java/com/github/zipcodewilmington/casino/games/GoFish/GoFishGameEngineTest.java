package com.github.zipcodewilmington.casino.games.GoFish;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.Authenticator;

public class GoFishGameEngineTest {

    private GoFishGameEngine goFishGameEngine;

    @Before
    public void setup() {
        goFishGameEngine = new GoFishGameEngine();
    }

    @Test
    public void isOver_flagSetToFalseByDefault_isFalse() {
         // given
        boolean expected = false;
        // when
        boolean returned = goFishGameEngine.isOver();
        // then
        Assert.assertEquals(false, returned);
    }

    @Test
    public void isOver_flagSetToFalseByDefault_isTrue() {
        // given
        goFishGameEngine.setIsOver(true);
        // when
        boolean returned = goFishGameEngine.isOver();
        // then
        Assert.assertTrue(returned);
    }


    @Test
    public void run() {


    }


    @Test
    public void isConstructorNull() {

    }

    @Test
    public void dealCardsTest() {

    }

    @Test
    public void chooseCardChoiceTest() {

    }


    @Test
    public void removeRanksTest() {
        /*
        if equals input, expect that the hand will not have those cards anymore
        need: opponent hand
        opponent?
        assign them a hand
        string input that matches in their hand

        expected: expect that the hand wont have that
    
         */
        // given

        // when

        // then

    }

    @Test
    public void addTest() {

    }

    @Test
    public void remove() {
    }

    @Test
    public void fish() {
    }


}