package com.example.roadjump;
import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

public class PlateTests {
    Plate plate;

    @Before
    public void setup() {
        plate = new Plate(264, 88, 0, 0);
    }

    @Test
    public void widthTest() {
        assertEquals(264, plate.getWidthSprite());
    }

    @Test
    public void heightTest() {
        assertEquals(88, plate.getHeightSprite());
    }

    @Test
    public void xCoordTest() {
        assertEquals(0, plate.getxCoord());
    }

    @Test
    public void rowTest() {
        assertEquals(0, plate.getRow());
    }
}
