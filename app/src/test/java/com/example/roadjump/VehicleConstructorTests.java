package com.example.roadjump;
import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

public class VehicleConstructorTests {
    //Unit Tests for generating vehicles

    Vehicle testVehicle;

    @Before
    public void setup() {
        testVehicle = new Vehicle(88, 88, 0, 0);
    }

    @Test
    public void widthTest() {
        assertEquals(88, testVehicle.getWidthSprite());
    }

    @Test
    public void heightTest() {
        assertEquals(88, testVehicle.getHeightSprite());
    }

    @Test
    public void xCoordTest() {
        assertEquals(0, testVehicle.getxCoord());
    }

    @Test
    public void yCoordTest() {
        assertEquals(0, testVehicle.getyCoord());
    }
}
