/**
 * Implements the IShapeCreator interface.
 *
 *     This class provides an implementation of the declared methods in {@code IShapeCreator}.
 *     Again, it is used as a template in order to simplify the creation and manipulation of the different types of boats in the game.
 *
 **/
package com.example.navalbattle.model.ships;

import com.example.navalbattle.model.DraggableMaker;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class ShapeCreator implements IShapeCreator {
    protected int id;
    protected Polygon shape;
    protected double layoutX, layoutY;
    protected int turns = 1;
    protected double horizontalXBound;

    /**
     *  Creates a new instance of {@code ShapeCreator}.
     *
     *  <p>This constructor sets the basic properties required for the representation of a ship.</p>
     * @param points is an array of doubles containing the points used to draw the Polygon that represents the ship's shape.
     * @param fillColor specifies the inner color of the shape
     * @param strokeColor specifies the color of the shape border
     */
    public ShapeCreator(double[] points, Color fillColor, Color strokeColor) {
        shape = new Polygon(points);
        shape.setFill(fillColor);
        shape.setStroke(strokeColor);
        shape.setStrokeWidth(1);
        shape.setOnMouseClicked(this::handleRotateClick);
    }

    /**
     *  Sets the {@code id} value as the {@code id} property of the instance.
     * @param id an integer number used to identify the object itself.
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method returns the {@code id} property value of the instance.
     * <p>The first digit refers to the type of ship, while the second one is inherent to the figure</p>
     * @return {@code int} id
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * This method returns the {@code Polygon} associated to the {@code ShapeCreator} instance.
     * @return {@code Polygon} shape
     */
    @Override
    public Polygon getShape() {
        return shape;
    }

    /**
     * Sets a new {@code Polygon} to be associated with the ShapeCreator instance.
     * @param shape The Polygon that is going to replace the one defined on the constructor.
     * @deprecated This method does not really have a use in the functionality of the code itself. May be used to do some internal tests.
     */
    @Override
    public void setShape(Polygon shape) {
        this.shape = shape;
    }

    /**
     * Gets the current X-value of the figure's position
     * @return a {@code double} representing the X-value of the current position of the figure.
     */
    @Override
    public double getLayoutX() {
        return layoutX;
    }

    /**
     * Sets a new X-value to the coordinate representing the position of the figure.
     * @param layoutX The new X-value of the coordinate where the figure is to be placed.
     */
    @Override
    public void setLayoutX(double layoutX) {
        this.layoutX = layoutX;
        shape.setLayoutX(layoutX);
    }

    /**
     * Gets the current Y-value of the figure's position
     * @return a {@code double} representing the Y-value of the current position of the figure.
     */
    @Override
    public double getLayoutY() {
        return layoutY;
    }

    /**
     * Sets a new Y-value to the coordinate representing the current position of the figure.
     * @param layoutY The new Y-value of the coordinate where the figure is to be placed.
     */
    @Override
    public void setLayoutY(double layoutY) {
        this.layoutY = layoutY;
        shape.setLayoutY(layoutY);
    }

    /**
     * Gets the value of the {@code turns} attribute.
     * @return {@code turns} attribute, an integer referring to the orientation of the figure.
     */
    @Override
    public int getTurns() {
        return turns;
    }

    /**
     * Sets the {@code turns} attribute to 1 (meaning vertical).
     */
    @Override
    public void setTurns() {
        turns=1;
    }

    /**
     * Sets the bound's X-value to be considered when the figure has a horizontal orientation.
     * @param horizontalXBound adds this number as the limit of the X-axis of the board.
     */
    @Override
    public void setHorizontalXBound(double horizontalXBound){
        this.horizontalXBound = horizontalXBound;
    }

    /**
     * Decides whether a translation of the figure is possible. The position to be evaluated is specified by the {@code newX} and {@code newY} parameters.
     * <p>This function behaves slightly different depending on the orientation of the figure(vertical/horizontal).
     * This is defined by the {@code turns} attribute.</p>
     * @param newX Specifies the X value of the new coordinate.
     * @param newY Specifies the Y value of the new coordinate.
     * @return {@code True} if the new position is within the limits of the player board.
     * {@code False} if it is outside of these bounds.
     */
    @Override
    public boolean isWithinBounds(double newX, double newY) {
        for (int i = 0; i < shape.getPoints().size(); i += 2){
            double x = shape.getPoints().get(i);
            double y = shape.getPoints().get(i + 1);

            double transformedX = newX + x;
            double transformedY = newY + y;

            if (turns == 1) {
                if (transformedX < 0 || transformedX > 737 || transformedY < 0 || transformedY > 410) {
                    return false;
                }
            }
            else if (turns == 2){
                if (transformedX < 0 || transformedX > horizontalXBound || transformedY < 0 || transformedY > 410) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method controls the rotation event of the figure, it uses an event listener on the secondary button of the mouse.
     * <p>
     *     The rotation event varies depending on the specific type of ship, since it limits its use on bigger ships, preventing them from exiting the borders of the player's board.
     * </p>
     * @param mouseEvent Event key.
     */
    private void handleRotateClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) { // botón derecho
            String idStr = String.valueOf(getId());

            if (idStr.charAt(0) == '4') {
                if (layoutX <= 261 && layoutY <= 277) {
                    if (turns == 1) {
                        shape.getPoints().setAll(0.0, 16.0, 32.0, 0.0, 32.0, 16.0, 64.0, 0.0, 64.0, 16.0, 96.0, 0.0, 96.0, 16.0, 128.0, 0.0, 128.0, 32.0, 96.0, 16.0, 96.0, 32.0, 64.0, 16.0, 64.0, 32.0, 32.0, 16.0, 32.0, 32.0);
                    } else if (turns == 2) {
                        shape.getPoints().setAll(0.0, 32.0, 16.0, 0.0, 32.0, 32.0, 16.0, 32.0, 32.0, 64.0, 16.0, 64.0, 32.0, 96.0, 16.0, 96.0, 32.0, 128.0, 0.0, 128.0, 16.0, 96.0, 0.0, 96.0, 16.0, 64.0, 0.0, 64.0, 16.0, 32.0, 0.0, 32.0);
                    }
                }
            }
            else if(idStr.charAt(0) == '3') {
                if (layoutX <= 293 && layoutY <= 309) {
                    if (turns == 1) {
                        shape.getPoints().setAll(0.0, 16.0, 32.0, 0.0, 32.0, 16.0, 64.0, 0.0, 64.0, 16.0, 96.0, 0.0, 96.0, 32.0, 64.0, 16.0, 64.0, 32.0, 32.0, 16.0, 32.0, 32.0);
                    } else if (turns == 2) {
                        shape.getPoints().setAll(0.0, 32.0, 16.0, 0.0, 32.0, 32.0, 16.0, 32.0, 32.0, 64.0, 16.0, 64.0, 32.0, 96.0, 0.0, 96.0,
                                16.0, 64.0, 0.0, 64.0, 16.0, 32.0, 0.0, 32.0);
                    }
                }
            }
            else if(idStr.charAt(0) == '2') {
                if (layoutX != 357 && layoutY != 373) {
                    if (turns == 1) {
                        shape.getPoints().setAll(0.0, 16.0, 32.0, 0.0, 32.0, 16.0, 64.0, 0.0, 64.0, 32.0, 32.0, 16.0, 32.0, 32.0);
                    } else if (turns == 2) {
                        shape.getPoints().setAll(0.0, 32.0, 16.0, 0.0, 32.0, 32.0, 16.0, 32.0, 32.0, 64.0, 0.0, 64.0, 16.0, 32.0, 0.0, 32.0);
                    }
                }
            }
            else if(idStr.charAt(0) == '1') {
                if (layoutX != 357 && layoutY != 373) {
                    if (turns == 1) {
                        shape.getPoints().setAll(0.0, 16.0, 32.0, 0.0, 32.0, 32.0);
                    } else if (turns == 2) {
                        shape.getPoints().setAll(0.0, 32.0, 16.0, 0.0, 32.0, 32.0);
                    }
                }
            }
            turns++;
            if (turns>2){
                setTurns();
            }
            System.out.println("La cantidad de giros son "+turns);
            setLayoutX(shape.getLayoutX()); // Actualizar layoutXsetLayoutY(shape.getLayoutY()); // Actualizar layoutY

            System.out.println("Shape rotated");
        }
    }
}
