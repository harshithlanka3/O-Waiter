package com.example.roadjump;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class PlayerBoundsUnitTest {
    private Player player = new Player();

    private final int UPPER = player.getSpriteSize();
    private final int LOWER = player.getScreenHeight();
    private final int LEFT = player.getLeftBound();
    private final int RIGHT = player.getRightBound();

    @Test
    public void upperBound() {
        for (int i = 0; i < 50; i++) {
            player.moveUp();
        }
        assertTrue(player.getyCoord() == UPPER && player.getxCoord() == player.getScreenWidth() / 2);
    }

    @Test
    public void lowerBound() {
        for (int i = 0; i < 50; i++) {
            player.moveDown();
        }
        assertTrue(player.getyCoord() == LOWER && player.getxCoord() == player.getScreenWidth() / 2);
    }

    @Test
    public void leftBound() {
        for (int i = 0; i < 50; i++) {
            player.moveLeft();
        }
        assertTrue(player.getxCoord() == LEFT && player.getyCoord() == player.getScreenHeight());
    }

    @Test
    public void rightBound() {
        for (int i = 0; i < 50; i++) {
            player.moveRight();
        }
        assertTrue(player.getxCoord() == RIGHT && player.getyCoord() == player.getScreenHeight());
    }
}
