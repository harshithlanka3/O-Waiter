package com.example.roadjump;

public class Vehicle {
    private int xCoord;
    private int yCoord;
    private final int lowerBound = 1754;
    private final int leftBound = 12;
    private final int rightBound = 1068;
    int widthSprite;
    int heightSprite;
    int delay;

    //1 constructor

    public Vehicle (int delay, int width, int height, int xCoord, int yCoord) {
        this.delay = delay;
        this.widthSprite = width;
        this.heightSprite = height;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }
    public Vehicle (int delay, int width, int height) {
        this(delay, width, height, 0, 0);
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void moveRight(int step) {
        if (xCoord > 1080) {
            xCoord = -180;
        }
        xCoord += step;
    }

    public void moveLeft(int step) {
        if (xCoord <= -180) {
            xCoord = 1080;
        }
        xCoord -= step;
    }
}