package com.example.navalbattle.model.ships;

import javafx.scene.shape.Polygon;
/**
 * The IShapeCreator} interface serves as a template for the creation of the different types of ships.
 * It declares a handful of standard methods such as setters and getters
 *
 **/
public interface IShapeCreator {

    Polygon getShape();
    void setShape(Polygon shape);
    int getId();
    void setId(int id);
    double getLayoutX();
    void setLayoutX(double layoutX);
    double getLayoutY();
    void setLayoutY(double layoutY);
    int getTurns();
    void setTurns();
    void setHorizontalXBound(double horizontalXBound);
    boolean isWithinBounds(double newX, double newY);
}
