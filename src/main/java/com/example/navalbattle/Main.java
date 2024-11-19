package com.example.navalbattle;

import javafx.application.Application;
import javafx.stage.Stage;
import com.example.navalbattle.view.WelcomeStage;
import java.io.IOException;

/**
 * Main class of the application that launches the game.
 * Extends the JavaFX Application class to initialize the game's first stage.
 */
public class Main extends Application {

    /**
     * Main method that launches the JavaFX application.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the JavaFX application and displays the WelcomeStage.
     *
     * @param primaryStage The primary stage for this application, which is unused in this case.
     * @throws IOException If there is an issue loading the WelcomeStage.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        WelcomeStage.getInstance(); // Loads the welcome screen of the game
    }
}
