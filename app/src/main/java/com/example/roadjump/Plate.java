package com.example.roadjump;

public class Plate {
    private int xCoord;
    private int yCoord;
    private final int lowerBound = 1754;
    private final int leftBound = 12;
    private final int rightBound = 1068;
    private int widthSprite;
    private int heightSprite;
//    private int delay;

    //1 constructor

    public Plate (int width, int height, int xCoord, int yCoord) {
//        this.delay = delay;
        this.widthSprite = width;
        this.heightSprite = height;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }
    public Plate (int width, int height) {
        this(width, height, 0, 0);
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

//    public void moveRight(int step) {
//        if (xCoord > 1080) {
//            xCoord = -250;
//        }
//        xCoord += step;
//    }

//    public void moveLeft(int step) {
//        if (xCoord <= -250) {
//            xCoord = 1200;
//        }
//        xCoord -= step;
//    }

    public int getWidthSprite() {
        return widthSprite;
    }

    public int getHeightSprite() {
        return heightSprite;
    }
}
