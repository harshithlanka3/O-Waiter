package com.example.roadjump;

import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.roadjump.R;

public class Player {
    private float xCoord;
    private float yCoord;
    private ImageView characterImage;
    private float score;

    public final int SPRITE_SIZE = 88;

    public final int LOWER_BOUND = 1754;

    public final int LEFT_BOUND = 992;

    public Player(float startX, float startY) {
        xCoord = startX;
        yCoord = startY;
        score = 0;
    }

    //new code methods
    public void moveUp() {
        if (yCoord > SPRITE_SIZE) {
            yCoord -= SPRITE_SIZE;
        }
    }
    public void moveDown() {
        if (yCoord <= LOWER_BOUND) {
            yCoord += SPRITE_SIZE;
        }
    }

    public void moveLeft() {
        if (xCoord + SPRITE_SIZE <= LEFT_BOUND) {
            xCoord += SPRITE_SIZE;
        }
    }
    public void moveRight() {
        if (xCoord - SPRITE_SIZE >= SPRITE_SIZE) {
            xCoord -= SPRITE_SIZE;
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