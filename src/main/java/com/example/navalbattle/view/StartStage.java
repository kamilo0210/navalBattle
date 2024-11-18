package com.example.navalbattle.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class StartStage extends Stage {

    private StartStage startStage;

    /**
     * Constructor that initializes the game start window.
     * @throws IOException if there is a problem while loading the game start window.
     */
    public StartStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/navalbattle/start-naval-battle-view.fxml"));
        Parent parent =loader.load();
        setTitle("Batalla Naval");
        Scene scene = new Scene(parent);
        setScene(scene);
        getIcons().add(new Image(String.valueOf(getClass().getResource("/com/example/navalbattle/images/favicon.png"))));
        scene.getStylesheets().add(getClass().getResource("/com/example/navalbattle/NavalBattleStyles.css").toExternalForm());
        setResizable(false);
        show();
    }

    /**
     * Internal static class containing a single instance of StartStage.
     */
    private static class StartStageHolder{
        private static StartStage INSTANCE;
    }

    /**
     * Obtains the single instance of StartStage. If it doesn't exist, creates a new one.
     * @return the single instance of StarStage
     * @throws IOException if there is a problem creating the instance.
     */
    public static StartStage getInstance() throws IOException {
        return StartStageHolder.INSTANCE=new StartStage();
    }

    /**
     * Closes and delete the StarStage instance.
     */
    public static void deleteInstance(){
        StartStageHolder.INSTANCE.close();
        StartStageHolder.INSTANCE=null;
    }
}