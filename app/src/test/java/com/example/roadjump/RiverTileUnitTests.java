package com.example.roadjump;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RiverTileUnitTests {
    private Player player;

    @Before
    public void setup() {

    }

    @Test
    public void riverLossPoints() {
        player = new Player();
        player.setRow(5);
        player.setScore(2);
        player.moveUp();
        assertEquals(1, player.getScore());
    }

    @Test
    public void riverResetPos() {
        player = new Player();
        player.setRow(5);
        player.setScore(2);
        player.moveUp();
        assertEquals(1760, player.getyCoord());
        assertEquals(540, player.getxCoord());
    }

    @Test
    public void riverSafety() {
        player = new Player();
        player.setRow(9);
        player.setScore(19);
        player.moveUp();
        assertEquals(22, player.getScore());
    }
}
