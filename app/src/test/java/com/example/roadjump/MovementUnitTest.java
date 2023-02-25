package com.example.roadjump;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MovementUnitTest {

    private Player bruh;

    @Before
    public void setup() {bruh = new Player(600, 600);}

    //test1: moving forward
    @Test
    public void movingForwardTest() {
        bruh.moveUp();
        bruh.moveUp();
        bruh.moveUp();

        assertEquals(bruh.getxCoord(),  600);
        assertEquals(bruh.getyCoord(), 336);
    }

    //test2: moving backwards
    @Test
    public void movingBackwardsTest() {

    }

    //test3: moving right
    @Test
    public void movingRightTest() {

    }
    //test4: moving left
    @Test
    public void movingLeftTest() {

    }



}