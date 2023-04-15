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
            checkCollision(player);
        }
    }

    public void moveLeft(int step, Player player) {
        if (xCoord <= -250) {
            xCoord = 1200;
        }
        xCoord -= step;
        if (player.getRow() == row) {
            checkCollision(player);
        }
    }

    public int getWidthSprite() {
        return widthSprite;
    }

    public int getHeightSprite() {
        return heightSprite;
    }

    public void checkCollision(Player player) {
        if (((xCoord < player.getxCoord() + player.getSpriteSize() / 2)
            && (player.getxCoord() + player.getSpriteSize() / 2 < xCoord + widthSprite))
            || ((xCoord < player.getxCoord() - player.getSpriteSize() / 2)
            && (player.getxCoord() - player.getSpriteSize() / 2 < xCoord + widthSprite))) {
            player.setScore(player.getScore() - player.getScore() / 2);
            player.setxCoord(player.getScreenWidth() / 2);
            player.setRow(0);
            player.setyCoord(player.getScreenHeight());
            player.setColumn(0);
            player.setDifficulty(player.getDifficulty() + 1);
        }
    }

    public int getRow() {
        return row;
    }
}
