package com.example.roadjump;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LivesUnitTests {
    private Player player;

    private Vehicle vehicle;

    @Before
    public void setup() {
        player = new Player();
    }

    @Test
    public void lowestDiff() {
        vehicle = new Vehicle(264, 88, 256, 1672, 1);
        player = new Player(540, 1672);
        player.setDifficulty(0);
        player.setRow(1);
        player.setScore(2);
        int counter = 0;
        while (player.getScore() != 1) {
            vehicle.moveRight(2, player);
            counter++;
        }
        System.out.println(counter);
        assertEquals(1, player.getDifficulty());
    }

    @Test
    public void midDiff() {
        vehicle = new Vehicle(264, 88, 256, 1672, 1);
        player = new Player(540, 1672);
        player.setRow(1);
        player.setDifficulty(1);
        player.setScore(2);
        int counter = 0;
        while (player.getScore() != 1) {
            vehicle.moveRight(2, player);
            counter++;
        }
        System.out.println(counter);
        assertEquals(2, player.getDifficulty());
    }

    @Test
    public void highDiff() {
        vehicle = new Vehicle(264, 88, 256, 1672, 1);
        player = new Player(540, 1672);
        player.setRow(1);
        player.setDifficulty(2);
        player.setScore(2);
        int counter = 0;
        while (player.getScore() != 1) {
            vehicle.moveRight(2, player);
            counter++;
        }
        System.out.println(counter);
        assertEquals(2, player.getDifficulty());
    }
}
