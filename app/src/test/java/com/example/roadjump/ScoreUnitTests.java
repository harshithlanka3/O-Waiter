package com.example.roadjump;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreUnitTests {
    private Player player;

    private Vehicle vehicle;

    @Before
    public void setup() {
        player = new Player();
    }

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

    @Test
    public void scoreLossDoubleChef() {
        vehicle = new Vehicle(176, 88, 344, 1);
        player = new Player(540, 1672);
        player.setRow(1);
        player.setScore(2);
        int counter = 0;
        while (player.getScore() != 1) {
            vehicle.moveRight(2, player);
            counter++;
        }
        System.out.println(counter);
        assertEquals(1, player.getScore());
    }

    @Test
    public void scoreLossRumya() {
        vehicle = new Vehicle(264, 88, 256, 1);
        player = new Player(540, 1672);
        player.setRow(1);
        player.setScore(2);
        int counter = 0;
        while (player.getScore() != 1) {
            vehicle.moveRight(2, player);
            counter++;
        }
        System.out.println(counter);
        assertEquals(1, player.getScore());
    }

    @Test
    public void scoreLossSeen() {
        vehicle = new Vehicle(88, 88, 344, 1);
        player = new Player(540, 1672);
        player.setRow(1);
        player.setScore(2);
        int counter = 0;
        while (player.getScore() != 1) {
            vehicle.moveRight(2, player);
            counter++;
        }
        System.out.println(counter);
        assertEquals(1, player.getScore());
    }

    @Test
    public void scoreLossPosReset() {
        vehicle = new Vehicle(176, 88, 344, 1);
        player = new Player(540, 1672);
        player.setRow(1);
        player.setScore(2);
        int counter = 0;
        while (player.getScore() != 1) {
            vehicle.moveRight(2, player);
            counter++;
        }
        assertEquals(1760, player.getyCoord());
        assertEquals(540, player.getxCoord());
    }
}
