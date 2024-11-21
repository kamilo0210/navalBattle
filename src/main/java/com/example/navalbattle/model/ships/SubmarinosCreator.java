/**
 * The class SubmarinosCreator extends the superclass ShapeCreator
 * Provides a specific implementation to the creation of the submarinos shapes
 *
 */

package com.example.navalbattle.model.ships;


import com.example.navalbattle.model.Exceptions.InvalidCoordinatesException;
import javafx.scene.paint.Color;

public class SubmarinosCreator extends ShapeCreator {
    /**
     * Creates a new instance of {@code SubmarinosCreator} with defined coordinates and a specific color for this type of ships.
     *     This constructor invokes the one from the {@code ShapeCreator} superclass with defined points and specific colors.
     *     It also establishes the horizontal bound for this figure.
     * @throws InvalidCoordinatesException if the provided coordinates are not valid.
     */
    public SubmarinosCreator() throws InvalidCoordinatesException {
        super(validatePoints(createRoundedRectangle(32, 96, 8)), // Ancho: 32 px, Alto: 96 px, Radio: 8 px
                Color.YELLOW, // Color de relleno amarillo
                Color.rgb(136, 35, 70)); // Color del borde
        setHorizontalXBound(96); // Ajustado para 3 celdas horizontales (32 px por celda)
    }

    /**
     * Crea un rectángulo con esquinas redondeadas.
     *
     * @param width  Ancho del rectángulo (32 px).
     * @param height Alto del rectángulo (96 px).
     * @param radius Radio de las esquinas redondeadas.
     * @return Coordenadas del polígono con esquinas redondeadas.
     */
    private static double[] createRoundedRectangle(double width, double height, double radius) {
        return new double[]{
                // Coordenadas para un rectángulo con esquinas redondeadas
                radius, 0,                    // Esquina superior izquierda (curva)
                width - radius, 0,            // Parte superior recta
                width, radius,                // Esquina superior derecha (curva)
                width, height - radius,       // Lado derecho recto
                width - radius, height,       // Esquina inferior derecha (curva)
                radius, height,               // Parte inferior recta
                0, height - radius,           // Esquina inferior izquierda (curva)
                0, radius                     // Lado izquierdo recto
        };
    }


    /**
     * Checks an array of points to make sure it contains an even number of coordinates.
     * @param points the array of points to validate.
     * @return the same array if the validation is successful.
     * @throws InvalidCoordinatesException if the number of coordinates is uneven.
     */
    public static double[] validatePoints(double[] points) throws InvalidCoordinatesException {
        if (points.length % 2 != 0) {
            throw new InvalidCoordinatesException("El número de coordenadas debe ser par.");
        }
        return points;
    }
}
