package com.example.roadjump.game_classes;

import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class Player {
    private float xCoord;
    private float yCoord;
    private ImageView characterImage;
    private float score;

    public Player(int startX, int startY) {
        this.characterImage = characterImage;
        xCoord = startX;
        yCoord = startY;
        score = 0;
    }

    public Player(ImageView characterImage) {
        this.characterImage = characterImage;
        xCoord = 0;
        yCoord = 0;
        score = 0;
    }

    //new code methods
    private ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)
            characterImage.getLayoutParams();

    public void moveUp() {
        if (layoutParams.topMargin - 352 > -4200) {
            //need to update y coord
            layoutParams.topMargin = layoutParams.topMargin - 352;
            layoutParams.bottomMargin = layoutParams.bottomMargin + 88;
            characterImage.setLayoutParams(layoutParams);
        }
    }
    public void moveDown() {
        if (layoutParams.bottomMargin - 88 > -100) {
            //need to update y coord
            layoutParams.bottomMargin = layoutParams.bottomMargin - 88;
            layoutParams.topMargin = layoutParams.topMargin + 352;
            characterImage.setLayoutParams(layoutParams);
        }
    }
    public void moveLeft() {
        if (layoutParams.leftMargin - 88 > -350) {
            //need to update x coord
            layoutParams.leftMargin = layoutParams.leftMargin - 88;
            layoutParams.rightMargin = layoutParams.rightMargin + 88;
            characterImage.setLayoutParams(layoutParams);
        }
    }
    public void moveRight() {
        if (layoutParams.rightMargin - 88 > -350) {
            //need to update x coord
            layoutParams.rightMargin = layoutParams.rightMargin - 88;
            layoutParams.leftMargin = layoutParams.leftMargin + 88;
            characterImage.setLayoutParams(layoutParams);
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
    /*
    public void setCharacterImage(ImageView imageChar) {
        characterImage = imageChar;
    }
    */
}
