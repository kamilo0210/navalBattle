package com.example.navalbattle.controller;

import com.example.navalbattle.model.Serialize;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class WelcomeController {

    @FXML
    private TextField nicknameField;

    @FXML
    private Button startGameButton;

    @FXML
    void handleStartGame() {
        String nickname = nicknameField.getText();
        if (nickname.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a nickname!");
            alert.showAndWait();
        } else {
            // Load game progress if exists
            Serialize serialize = new Serialize();
            GameData gameData = serialize.loadGame(nickname);
            if (gameData != null) {
                // Load the game with saved data
                System.out.println("Game loaded for " + nickname);
                // Here, you would navigate to the game stage with the loaded data
            } else {
                // Start a new game
                System.out.println("Starting new game for " + nickname);
                // Here, you would navigate to the game stage without loaded data
            }
        }
    }
}