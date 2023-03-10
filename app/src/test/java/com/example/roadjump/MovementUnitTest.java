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
    public void setup() {bruh = new Player();}

    //test1: moving forward
    @Test
    public void movingForwardTest() {
        bruh.moveUp();

        assertEquals(bruh.getScreenWidth() / 2, bruh.getxCoord(), 0);
        assertEquals(bruh.getScreenHeight() - bruh.getSpriteSize(), bruh.getyCoord(), 0);

        bruh.moveUp();
        bruh.moveUp();

        assertEquals(bruh.getScreenWidth() / 2,  bruh.getxCoord(), 0);
        assertEquals(bruh.getScreenHeight() - 3 * bruh.getSpriteSize(), bruh.getyCoord(), 0);
    }

    //test2: moving backwards
    @Test
    public void movingBackwardsTest() {
        bruh.moveUp();
        bruh.moveUp();
        bruh.moveDown();

        assertEquals(bruh.getScreenWidth() / 2, bruh.getxCoord(), 0);
        assertEquals(bruh.getScreenHeight() - bruh.getSpriteSize(), bruh.getyCoord(), 0);

        bruh.moveUp();
        bruh.moveUp();
        bruh.moveUp();
        bruh.moveUp();
        bruh.moveDown();
        bruh.moveDown();

        assertEquals(bruh.getScreenWidth() / 2, bruh.getxCoord(), 0);
        assertEquals(bruh.getScreenHeight() - 3 * bruh.getSpriteSize(), bruh.getyCoord(), 0);
    }

    //test3: moving right
    @Test
    public void movingRightTest() {
        bruh.moveRight();

        assertEquals(bruh.getScreenWidth() / 2 + bruh.getSpriteSize(), bruh.getxCoord(), 0);
        assertEquals(bruh.getScreenHeight(), bruh.getyCoord(), 0);

        bruh.moveRight();
        bruh.moveRight();

        assertEquals(bruh.getScreenWidth() / 2 + 3 * bruh.getSpriteSize(), bruh.getxCoord(), 0);
        assertEquals(bruh.getScreenHeight(), bruh.getyCoord(), 0);

    }

    //test4: moving left
    @Test
    public void movingLeftTest() {
        bruh.moveLeft();

        assertEquals(bruh.getScreenWidth() / 2 - bruh.getSpriteSize(), bruh.getxCoord(), 0);
        assertEquals(bruh.getScreenHeight(), bruh.getyCoord(), 0);

        bruh.moveLeft();
        bruh.moveLeft();

        assertEquals(bruh.getScreenWidth() / 2 - 3 * bruh.getSpriteSize(), bruh.getxCoord(), 0);
        assertEquals(bruh.getScreenHeight(), bruh.getyCoord(), 0);
    }



}