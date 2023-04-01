package com.example.roadjump;

public class Player {
    private int xCoord;
    private int col;

    private int row;
    private int yCoord;
    private int score;
    private String username;
    private int difficulty;
    private int imgClicked;
    private final int spriteSize = 88;
    private final int lowerBound = 1754;
    private final int leftBound = 90;
    private final int rightBound = 980;
    private final int screenWidth = 1080;
    private final int screenHeight = 1760;
    private int progress;

    public Player() {
        xCoord = screenWidth / 2;
        yCoord = screenHeight;
        col = 0;
        row = 0;
        resetScore();
        imgClicked = 0;
        progress = screenHeight;
        score = 0;
    }

    public void moveUp() {
        if (yCoord > spriteSize) {
            yCoord -= spriteSize;
            row++;
            checkCollisionPlate();
        }
        if (yCoord < progress) {
            progress = yCoord;
            updateScore();
        }
        if (score == 45 && xCoord == screenWidth / 2) {
            score += 5;
        }
    }
    public void moveDown() {
        if (yCoord <= lowerBound) {
            yCoord += spriteSize;
            row--;
            checkCollisionPlate();
        }

    }

    public void moveLeft() {
        if (xCoord - spriteSize >= leftBound) {
            xCoord -= spriteSize;
            --col;
            checkCollisionPlate();
        }
        if (score == 45 && xCoord == screenWidth / 2) {
            score += 5;
        }
    }
    public void moveRight() {
        if (xCoord + spriteSize <= rightBound) {
            xCoord += spriteSize;
            col++;
            checkCollisionPlate();
        }
        if (score == 45 && xCoord == screenWidth / 2) {
            score += 5;
        }
    }

    public void checkCollisionPlate() {
        if (col != 2 && row >=6 && row <= 8) {
            score -= score / 2;
            xCoord = screenWidth / 2;
            row = 0;
            yCoord = screenHeight;
            col = 0;
        } else if (col != 0 && row >=10 && row <= 12) {
            score -= score / 2;
            xCoord = screenWidth / 2;
            row = 0;
            yCoord = screenHeight;
            col = 0;
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

    public void setxCoord(int x) { this.xCoord = x; }
    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int y) { this.yCoord = y; }
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

    public void setScore(int newScore) {
        score = newScore;
    }

    public void setRow (int row) {
        this.row = row;
    }

    public void setColumn (int column) {
        col = column;
    }

    public int getRow() {
        return row;
    }

}