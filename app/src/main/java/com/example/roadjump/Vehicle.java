package com.example.roadjump;

public class Vehicle {
    private int xCoord;
    private int yCoord;
    private int widthSprite;
    private int heightSprite;
    private int row;

    //1 constructor

    public Vehicle(int width, int height, int xCoord, int yCoord, int row) {
        this.widthSprite = width;
        this.heightSprite = height;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.row = row;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void moveRight(int step, Player player) {
        if (player.getRow() == row) {
            checkCollision(player);
        }
        if (xCoord > 1080) {
            xCoord = -250;
        }
        xCoord += step;
    }

    public void moveLeft(int step, Player player) {
        if (player.getRow() == row) {
            checkCollision(player);
        }
        if (xCoord <= -250) {
            xCoord = 1200;
        }
        xCoord -= step;
    }

    public int getWidthSprite() {
        return widthSprite;
    }

    public int getHeightSprite() {
        return heightSprite;
    }

    public void checkCollision(Player player) {
        if (((xCoord < player.getxCoord() + player.getSpriteSize())
            && (player.getxCoord() + player.getSpriteSize() < xCoord + widthSprite))
            || ((xCoord < player.getxCoord())
            && (player.getxCoord() < xCoord + widthSprite))) {
            player.setScore(player.getScore() - player.getScore() / 2);
            player.setxCoord(player.getScreenWidth() / 2);
            player.setRow(0);
            player.setyCoord(player.getScreenHeight());
            player.setColumn(0);
            player.setDifficulty(player.getDifficulty() + 1);
        }

    }
}
