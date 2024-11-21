package com.example.navalbattle.controller;

import com.example.navalbattle.model.GameData;
import com.example.navalbattle.model.Serialize;
import com.example.navalbattle.view.StartStage;
import com.example.navalbattle.view.WelcomeStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;

public class WelcomeController {

    @FXML
    private TextField nicknameField;

    @FXML
    private Button startGameButton;

      // Dentro de WelcomeController.java

      @FXML
      public void handleStartGame(ActionEvent event) throws IOException {
          String nickname = nicknameField.getText();
          if (nickname.isEmpty()) {
              Alert alert = new Alert(Alert.AlertType.WARNING);
              alert.setTitle("Warning");
              alert.setHeaderText(null);
              alert.setContentText("Please enter a nickname!");
              alert.showAndWait();
          } else {
              // Guardar el nickname al iniciar el juego
              Serialize serialize = new Serialize();
              serialize.saveNickname(nickname);  // Guardamos el nickname

              // Cargar datos del juego si existen
              GameData gameData = serialize.loadGame(nickname);
              if (gameData != null) {
                  System.out.println("Game loaded for " + nickname);
                  StartStage.getInstance().getStartController();
                  WelcomeStage.deleteInstance();
              } else {
                  System.out.println("Starting new game for " + nickname);
                  StartStage.getInstance().getStartController();
                  WelcomeStage.deleteInstance();
              }
          }
      }
}