/**
 * The classextends the superclass ShapeCreator}
 * Provides a specific implementation to the creation of the destructors shapes
 *
 */



package com.example.navalbattle.model.ships;

import com.example.navalbattle.model.Exceptions.InvalidCoordinatesException;

import javafx.scene.paint.Color;

public class DestructoresCreator extends ShapeCreator {

    /**
     * Creates a new instance of {@code DestructoresCreator} with defined coordinates and a specific color for this type of ships.
     * <p>
     *     This constructor invokes the one from the {@code ShapeCreator} superclass with defined points and specific colors.
     *     It also establishes the horizontal bound for this figure.
     * </p>
     * @throws InvalidCoordinatesException if the provided coordinates are not valid.
     */
    public DestructoresCreator() throws InvalidCoordinatesException {
        super(validatePoints(new double[]{
                0, 32, // A
                16, 0, // B
                32, 32, // C
                16, 32, // D
                32, 64, // E
                0, 64, // F
                16, 32, // D
                0, 32  // G
        }), Color.rgb(228, 140, 255), Color.BLACK);
        setHorizontalXBound(389);
    }

    /**
     * Checks an array of points to make sure it contains an even number of coordinates.
     * @param points the array of points to validate.
     * @return the same array if the validation is successful.
     * @throws InvalidCoordinatesException if the number of coordinates is uneven.
     */
    // Método de validación público
    public static double[] validatePoints(double[] points) throws InvalidCoordinatesException {
        if (points.length % 2 != 0) {
            throw new InvalidCoordinatesException("El número de coordenadas debe ser par.");
        }
        return points;
    }
}
