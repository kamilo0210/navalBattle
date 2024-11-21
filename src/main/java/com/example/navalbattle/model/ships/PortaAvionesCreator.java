package com.example.navalbattle.model.ships;

import com.example.navalbattle.model.Exceptions.InvalidCoordinatesException;
import javafx.scene.paint.Color;

public class PortaAvionesCreator extends ShapeCreator {
    /**
     * Crea una nueva instancia de PortaAvionesCreator con coordenadas definidas y un color específico para este tipo de barcos.
     * Invoca el constructor de la superclase {@code ShapeCreator} con puntos definidos y colores específicos.
     * También establece el límite horizontal para esta figura.
     *
     * @throws InvalidCoordinatesException si las coordenadas proporcionadas no son válidas.
     */
    public PortaAvionesCreator() throws InvalidCoordinatesException {
        super(validatePoints(new double[]{
                16, 0,
                32, 16,
                32, 112,
                16, 128,
                0, 112,
                0, 16
        }), Color.LIGHTGRAY, Color.DARKBLUE);

        setHorizontalXBound(128);
    }


    public static double[] validatePoints(double[] points) throws InvalidCoordinatesException {
        if (points.length % 2 != 0) {
            throw new InvalidCoordinatesException("El número de coordenadas debe ser par.");
        }
        return points;
    }
}

