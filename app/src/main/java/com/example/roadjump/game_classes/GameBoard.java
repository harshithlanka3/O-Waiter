package com.example.roadjump.game_classes;

public class GameBoard {
    private Tile[][] board;

    public GameBoard() {
        board = new Tile[9][9];
    }

    public void addTile(Tile tile , int row, int col) {
        board[row][col] = tile;
    }

    public Tile getTile(int row, int col) {
        return board[row][col];
    }

    public boolean isSafe(int row, int col) {
        return board[row][col].getIsSafe();
    }
}
