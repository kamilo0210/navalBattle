package com.example.navalbattle.model;

import java.io.Serializable;

public class GameData implements Serializable {
    private static final long serialVersionUID = 1L;
    // Define fields that represent the game state
    private String[][] board; // Example for board state
    // Add other fields necessary for saving the game state

    public GameData(String[][] board) {
        this.board = board;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    // Add other getters and setters as needed
}
