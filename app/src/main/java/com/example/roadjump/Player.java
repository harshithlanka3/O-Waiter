package com.example.roadjump;

import android.widget.ImageView;

public class Player {
    private float xCoord;
    private float yCoord;
    private float score;
    private String username;
    private int difficulty;
    private int imgClicked;

    private final int spriteSize = 88;

    private final int lowerBound = 1754;

    private final int leftBound = 12;
    private final int rightBound = 1068;

    private final int screenWidth = 1080;

    private final int screenHeight = 1760;

    public Player() {
        xCoord = screenWidth/2;
        yCoord = screenHeight;
        score = 0;
        imgClicked = 0;
    }

    public void moveUp() {
        if (yCoord > spriteSize) {
            yCoord -= spriteSize;
        }
    }
    public void moveDown() {
        if (yCoord <= lowerBound) {
            yCoord += spriteSize;
        }
    }

    public void moveLeft() {
        if (xCoord - spriteSize >= leftBound) {
            xCoord -= spriteSize;
        }
    }
    public void moveRight() {
        if (xCoord + spriteSize <= rightBound) {
            xCoord += spriteSize;
        }
    }

    public float getxCoord() {
        return xCoord;
    }
    public float getyCoord() {
        return yCoord;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setImg(int image) {
        this.imgClicked = image;
    }

    public int getImgClicked() {
        return imgClicked;
    }

    public int getSpriteSize() {
        return spriteSize;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getRightBound() {
        return rightBound;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getLeftBound() {
        return leftBound;
    }
    public boolean checkValidity(String username) {
        if (username == null || username.length() == 0) {
            return false;
        } else {
            return username.length() != 0;
        }
    }
}