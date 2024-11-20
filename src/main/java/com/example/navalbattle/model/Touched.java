package com.example.navalbattle.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * The class is responsible for managing the functionality related to the "Touched" state in the game.
 * It manages the addition of bombs images to board positions
 * and maintains a counter to limit the maximum number of touches allowed.
 */
public class Touched {

    private static final String TOCADO_IMAGE_URL = "/com/example/navalbattle/images/Tocado.png";

    private static final int MAX_TOCADO = 20;

    private static int counter = 0;

    /**
     * Adds a bomb image to a specific StackPane on the board.
     * If the number of hits reaches the maximum limit,
     * no more images are added and a message is printed on the console.
     * @param stackPane The StackPane to which the bomb image will be added.
     */
    public static void addTocado(StackPane stackPane) {
        if (counter < MAX_TOCADO) {
            Image tocadoImage = new Image(Touched.class.getResource(TOCADO_IMAGE_URL).toExternalForm());
            ImageView imageView = new ImageView(tocadoImage);

            //Se establece manualmente el tamaño
            double imageWidth = 30;
            double imageHeight = 30;
            imageView.setFitWidth(imageWidth);
            imageView.setFitHeight(imageHeight);

            //ImageView al StackPane
            stackPane.getChildren().add(imageView);
            counter++;
        } else {
            System.out.println("El contador ha alcanzado el limite de 20.");
        }

    }

    /**
     * Verifies if the counter of "touches" has reached its maximum allowed.
     * @return {@code True} if the counter is more or equal to MAX_TOCADO, {@code False} otherwise.
     */
    public static boolean maximumCounter() {
        return counter == MAX_TOCADO;
    }
}
