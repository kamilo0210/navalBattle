package com.example.navalbattle.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;

/**
 * Represents the welcome window for the game
 * This class sets up the initial gui of the game and implements the Singleton pattern
 * to ensure that only one instance of this window exists at any given time.
 */
public class WelcomeStage extends Stage {

    /**
     * Constructor for WelcomeStage.
     * Loads the user interface from an FXML file, sets the background image, and configures the stage parameters.
     *
     * @throws IOException if the FXML file cannot be loaded.
     */
    public WelcomeStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/navalbattle/welcome-view.fxml"));
        VBox root = loader.load();

        Image backgroundImage = new Image(getClass().getResource("/com/example/navalbattle/images/naval-battle-background.jpg").toExternalForm());
        BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        root.setBackground(new Background(background));

        Scene scene = new Scene(root);
        setTitle("Batalla Naval");
        getIcons().add(new Image(String.valueOf(getClass().getResource("/com/example/navalbattle/images/favicon.png"))));
        setResizable(false);
        setScene(scene);
        show();
    }

    /**
     * Static nested class implementing the Singleton pattern to ensure only one instance of WelcomeStage is created.
     */
    private static class WelcomeStageHolder {
        private static WelcomeStage INSTANCE;
    }

    /**
     * Retrieves the single instance of WelcomeStage.
     *
     * @return the single instance of WelcomeStage.
     * @throws IOException if an error occurs while creating the instance.
     */
    public static WelcomeStage getInstance() throws IOException {
        return WelcomeStageHolder.INSTANCE = new WelcomeStage();
    }

    /**
     * Deletes the current instance of WelcomeStage by closing the window and setting the instance reference to null.
     */
    public static void deleteInstance() {
        WelcomeStageHolder.INSTANCE.close();
        WelcomeStageHolder.INSTANCE = null;
    }
}