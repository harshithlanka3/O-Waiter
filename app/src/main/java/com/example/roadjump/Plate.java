package com.example.roadjump;

public class Plate {
    private int xCoord;
    private int row;
    private int widthSprite;
    private int heightSprite;

    public Plate(int width, int height, int xCoord, int row) {
        this.widthSprite = width;
        this.heightSprite = height;
        this.xCoord = xCoord;
        this.row = row;
    }
    public Plate(int width, int height) {
        this(width, height, 0, 0);
    }

    public int getxCoord() {
        return xCoord;
    }
    public int getWidthSprite() {
        return widthSprite;
    }

    public int getHeightSprite() {
        return heightSprite;
    }

    public void moveRight(int step, Player player) {
        if (xCoord > 1080) {
            xCoord = -250;
        }
        xCoord += step;
        if (player.getRow() == row) {
            checkCollision(player, step);
        }
    }

    public void moveLeft(int step, Player player) {
        if (xCoord <= -250) {
            xCoord = 1200;
        }
        xCoord -= step;
        if (player.getRow() == row) {
            checkCollision(player, -step);
        }
    }

    public boolean checkCollision(Player player, int step) {
        int playerRight = player.getxCoord() + player.getSpriteSize() / 2;
        int playerLeft = player.getxCoord() - player.getSpriteSize() / 2;
        int plateLeft = xCoord;
        int plateRight = xCoord + widthSprite;

        if (((plateLeft < playerRight)
                && (playerRight < plateRight))
                || ((plateLeft < playerLeft)
                && (playerLeft < plateRight))) {
            player.setxCoord(player.getxCoord() + step);
            return true;
        }

        player.setScore(player.getScore() - player.getScore() / 2);
        player.setxCoord(player.getScreenWidth() / 2);
        player.setRow(0);
        player.setyCoord(player.getScreenHeight());
        player.setColumn(0);
        player.setDifficulty(player.getDifficulty() + 1);

        return false;
    }

    public int getRow() {
        return row;
    }
}