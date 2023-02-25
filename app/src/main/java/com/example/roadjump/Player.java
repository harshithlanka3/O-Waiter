package com.example.roadjump;

import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.roadjump.R;

public class Player {
    private float xCoord;
    private float yCoord;
    private ImageView characterImage;
    private float score;

    public Player(float startX, float startY) {
        xCoord = startX;
        yCoord = startY;
        score = 0;
    }

    //new code methods
    public void moveUp() {
        if (yCoord >= 44) {
            yCoord -= 88;
        }
    }
    public void moveDown() {
        if (yCoord <= 1760) {
            yCoord += 88;
        }
    }

    public void moveLeft() {
        if (xCoord + 88 <= 992) {
            xCoord += 88;
        }
    }
    public void moveRight() {
        if (xCoord - 88 >= 88) {
            xCoord -= 88;
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