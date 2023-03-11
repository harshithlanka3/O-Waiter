package com.example.roadjump;

import android.os.SystemClock;
import android.widget.ImageView;

public class Player {
    private int xCoord;
    private int yCoord;
    private int score;
    private String username;
    private int difficulty;
    private int imgClicked;
    private final int spriteSize = 88;
    private final int lowerBound = 1754;
    private final int leftBound = 12;
    private final int rightBound = 1068;
    private final int screenWidth = 1080;
    private final int screenHeight = 1760;
    private int progress;

    public Player() {
        xCoord = screenWidth / 2;
        yCoord = screenHeight;
        resetScore();
        imgClicked = 0;
        progress = screenHeight;
    }

    public void moveUp() {
        if (yCoord > spriteSize) {
            yCoord -= spriteSize;
        }
        if (yCoord < progress) {
            progress = yCoord;
            updateScore();
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

    public boolean checkValidity(String username) {
        if (username == null || username.length() == 0) {
            return false;
        } else {
            return username.length() != 0;
        }
    }

    public void updateScore() {
        if ((score >= 0 && score < 8) || (score >= 29 && score < 37)) {
            score += 2;
        } else if (score == 8 || score == 18 || score == 28 || score == 37) {
            score += 1;
        } else if (score == 38) {
            score += 7;
        } else {
            score += 3;
        }
    }

    public int getxCoord() {
        return xCoord;
    }
    public int getyCoord() {
        return yCoord;
    }

    public int getScore() {
        return score;
    }

    public void resetScore() {
        score = 0;
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
}