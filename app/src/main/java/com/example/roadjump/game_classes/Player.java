package com.example.roadjump.game_classes;

import android.widget.ImageView;

import com.example.roadjump.R;

public class Player {
    private float xCoord;
    private float yCoord;
    private ImageView characterImage;
    private float score;

    public Player(ImageView characterImage) {
        this.characterImage = characterImage;
        xCoord = 0;
        yCoord = 0;
        score = 0;
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
    public ImageView getCharacterImage() {
        return characterImage;
    }

    public void setxCoord(float x) {
        xCoord = x;
    }
    public void setyCoord(float y) {
        xCoord = y;
    }
    public void setScore(float score) {
        this.score = score;
    }
    public void setCharacterImage(ImageView imageChar) {
        characterImage = imageChar;
    }
}
