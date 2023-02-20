package com.example.roadjump.game_classes;

public class GameBoard {
    private Tile[][] board;

    public GameBoard() {
        board = new Tile[9][9];
    }

    public void addTile(Tile tile , int row, int column) {
        board[row][column] = tile;
    }

    public Tile getTile(int row, int column) {
        return board[row][column];
    }
}
