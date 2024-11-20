/**
 * The class extends the superclass ShapeCreator
 * Provides a specific implementation to the creation of the frigates shapes
 *
 */

package com.example.navalbattle.model.ships;

import com.example.navalbattle.model.Exceptions.InvalidCoordinatesException;
import javafx.scene.paint.Color;

public class FragatasCreator extends ShapeCreator {
    /**
     * Creates a new instance of FragatasCreator with defined coordinates and a specific color for this type of ships.
     *     This constructor invokes the one from the {@code ShapeCreator} superclass with defined points and specific colors.
     *     It also establishes the horizontal bound for this figure.
     *
     * @throws InvalidCoordinatesException if the provided coordinates are not valid.
     */
    public FragatasCreator() throws InvalidCoordinatesException {
        super(validatePoints(new double[]{
                0, 32,//A
                16, 0,//B
                32, 32
        }),Color.rgb(0, 128, 128),Color.rgb(0, 79, 79));
        setHorizontalXBound(737);
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