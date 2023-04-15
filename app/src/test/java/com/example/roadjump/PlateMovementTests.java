package com.example.roadjump;
import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

public class PlateMovementTests {
    Plate plate;

    Player player;

    @Before
    public void setup() {
        plate = new Plate(264, 88, 0, 1);
        player = new Player(0, 0);
        player.setRow(1);
    }

    @Test
    public void movesRight() {
        plate.moveRight(50, player);
        assertEquals(50, plate.getxCoord());
    }

    @Test
    public void movesLeft() {
        plate.moveLeft(50, player);
        assertEquals(-50, plate.getxCoord());
    }

    @Test
    public void playerMovesWithRight() {
        player.moveRight();
        plate.moveRight(50, player);
        assertEquals(138, player.getxCoord());
    }

    @Test
    public void playerMovesWithLeft() {
        player.moveRight();
        plate.moveLeft(50, player);
        assertEquals(38, player.getxCoord());
    }

    @Test
    public void playerFallsOffRight() {
        player.setDifficulty(2);
        player.moveRight();
        for (int i = 0; i < 30; i++) {
            plate.moveRight(50, player);
        }

        assertEquals(3, player.getDifficulty());
    }

    @Test
    public void playerFallsOffLeft() {
        player.setDifficulty(2);
        player.moveRight();
        for (int i = 0; i < 30; i++) {
            plate.moveLeft(50, player);
        }

        assertEquals(3, player.getDifficulty());
    }
}