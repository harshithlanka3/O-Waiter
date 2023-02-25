package com.example.roadjump;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class PlayerBoundsUnitTest {
    private Player player;

    private final int UPPER = 88;
    private final int LOWER = 1754;
    private final int LEFT = 88;
    private final int RIGHT = 992;

    @Before
    public void setup() {
        player = new Player(540, 880);
    }

    @Test
    public void upperBound() {
        for (int i = 0; i < 50; i++) {
            player.moveUp();
        }
        assertTrue(player.getyCoord() >= UPPER && player.getyCoord() < 880 && player.getxCoord() == 540);
    }

    @Test
    public void lowerBound() {
        for (int i = 0; i < 50; i++) {
            player.moveDown();
        }
        assertTrue(player.getyCoord() - 88 <= LOWER && player.getyCoord() > 880 && player.getxCoord() == 540);
    }

    @Test
    public void leftBound() {
        for (int i = 0; i < 50; i++) {
            player.moveLeft();
        }
        assertTrue(player.getxCoord() >= LEFT && player.getxCoord() < 540 && player.getyCoord() == 880);
    }

    @Test
    public void rightBound() {
        for (int i = 0; i < 50; i++) {
            player.moveRight();
        }
        assertTrue(player.getxCoord() <= RIGHT && player.getxCoord() > 540 && player.getyCoord() == 880);
    }
}
