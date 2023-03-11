package com.example.roadjump;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreUnitTests {
    private Player player;

    @Before
    public void setup() {player = new Player();}

    @Test
    public void scoreMoveUp() {
        player.moveUp();

        assertEquals(player.getScore(), 2);
    }

    @Test
    public void scoreMoveUpUntilGoal() {
        for (int i = 0; i < 18; i++) {
            player.moveUp();
        }

        assertEquals(player.getScore(), 38);
    }

    @Test
    public void scoreMoveUpAndGoal() {
        for (int i = 0; i < 30; i++) {
            player.moveUp();
        }

        assertEquals(player.getScore(), 50);
    }

    @Test
    public void scoreMoveLeftAndUpUntilGoal() {
        player.moveLeft();
        for (int i = 0; i < 30; i++) {
            player.moveUp();
        }

        assertEquals(player.getScore(), 45);
    }

    @Test
    public void scoreMoveRightAndUpUntilGoal() {
        player.moveRight();
        for (int i = 0; i < 30; i++) {
            player.moveUp();
        }

        assertEquals(player.getScore(), 45);
    }

    @Test
    public void scoreMoveRight() {
        for (int i = 0; i < 10; i++) {
            player.moveRight();
        }

        assertEquals(player.getScore(), 0);
    }

    @Test
    public void scoreMoveLeft() {
        for (int i = 0; i < 10; i++) {
            player.moveLeft();
        }

        assertEquals(player.getScore(), 0);
    }
}
