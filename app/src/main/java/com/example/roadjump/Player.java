package com.example.roadjump;

import android.widget.ImageView;

public class Player {
    private float xCoord;
    private float yCoord;
    private ImageView characterImage;
    private float score;

    private final int spriteSize = 88;

    private final int lowerBound = 1754;

    private final int rightBound = 992;

    public Player(float startX, float startY) {
        xCoord = startX;
        yCoord = startY;
        score = 0;
    }

    //new code methods
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
        if (xCoord - spriteSize >= spriteSize) {
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

    //old code methods ahah
    public float getScore() {
        return score;
    }
    public ImageView getCharacterImage() {
        return characterImage;
    }

    public void setScore(float score) {
        this.score = score;
    }
}