package com.example.roadjump;

public class Vehicle {
    private int xCoord;
    private int widthSprite;
    private int heightSprite;
    private int row;

    public Vehicle(int width, int height, int xCoord, int row) {
        this.widthSprite = width;
        this.heightSprite = height;
        this.xCoord = xCoord;
        this.row = row;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void moveRight(int step, Player player) {
        if (xCoord > 1080) {
            xCoord = -250;
        }
        xCoord += step;
        if (player.getRow() == row) {
            player.checkVehicleCollision(this);
        }
    }

    public void moveLeft(int step, Player player) {
        if (xCoord <= -250) {
            xCoord = 1200;
        }
        xCoord -= step;
        if (player.getRow() == row) {
            player.checkVehicleCollision(this);
        }
    }

    public int getWidthSprite() {
        return widthSprite;
    }

    public int getHeightSprite() {
        return heightSprite;
    }

    public int getRow() {
        return row;
    }
}