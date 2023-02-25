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

        assertEquals(600, bruh.getxCoord(), 0);
        assertEquals(512, bruh.getyCoord(), 0);

        bruh.moveUp();
        bruh.moveUp();

        assertEquals(600,  bruh.getxCoord(), 0);
        assertEquals(336, bruh.getyCoord(), 0);
    }

    //test2: moving backwards
    @Test
    public void movingBackwardsTest() {
        bruh.moveDown();

        assertEquals(600, bruh.getxCoord(), 0);
        assertEquals(688, bruh.getyCoord(), 0);

        bruh.moveDown();
        bruh.moveDown();

        assertEquals(600, bruh.getxCoord(), 0);
        assertEquals(864, bruh.getyCoord(), 0);
    }

    //test3: moving right
    @Test
    public void movingRightTest() {
        bruh.moveRight();

        assertEquals(688, bruh.getxCoord(), 0);
        assertEquals(600, bruh.getyCoord(), 0);

        bruh.moveRight();
        bruh.moveRight();

        assertEquals(864, bruh.getxCoord(), 0);
        assertEquals(600, bruh.getyCoord(), 0);

    }

    //test4: moving left
    @Test
    public void movingLeftTest() {
        bruh.moveLeft();

        assertEquals(512, bruh.getxCoord(), 0);
        assertEquals(600, bruh.getyCoord(), 0);

        bruh.moveLeft();
        bruh.moveLeft();

        assertEquals(336, bruh.getxCoord(), 0);
        assertEquals(600, bruh.getyCoord(), 0);
    }



}