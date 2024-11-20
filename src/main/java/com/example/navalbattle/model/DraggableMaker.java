package com.example.navalbattle.model;

import com.example.navalbattle.model.Exceptions.InvalidPositionException;
import com.example.navalbattle.model.ships.ShapeCreator;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * The {@code DraggableMaker} class allows to make draggable nodes and adjust their positions to the
 * nearest grid on the game board.
 *     This class handles mouse events to allow nodes to be dragged and positioned correctly on a game board.
 *     It also keeps track of the final position of the nodes.
 */
public class DraggableMaker {


    private double posMouseX = 0, posMouseY = 0;
    private Pane gamePane;
    private int parentWidth = 737;  // Ancho del AnchorPane
    private int parentHeight = 410; // Alto del AnchorPane
    private final double POSITION_X1 = 69;
    private final double POSITION_X2 = 101;
    private final double POSITION_X3 = 133;
    private final double POSITION_X4 = 165;
    private final double POSITION_X5 = 197;
    private final double POSITION_X6 = 229;
    private final double POSITION_X7 = 261;
    private final double POSITION_X8 = 293;
    private final double POSITION_X9 = 325;
    private final double POSITION_X10 = 357;
    private final double POSITION_Y1 = 85;
    private final double POSITION_Y2 = 117;
    private final double POSITION_Y3 = 149;
    private final double POSITION_Y4 = 181;
    private final double POSITION_Y5 = 213;
    private final double POSITION_Y6 = 245;
    private final double POSITION_Y7 = 277;
    private final double POSITION_Y8 = 309;
    private final double POSITION_Y9 = 341;
    private final double POSITION_Y10 = 373;
    private double closestX;
    private double closestY;
    private boolean gameOn = true;  // Asegúrate de que gameOn esté configurado en true
    private int turns = 1;

    private List<Integer> validPos = new ArrayList<>();
    //se utilizo map porque facilita guardar la ultima posicion del barco puesta por el usuario
    private Map<Integer, Double> ultimasPosicionesX = new HashMap<>();
    private Map<Integer, Double> ultimasPosicionesY = new HashMap<>();

    /**
     * Allows a node to be dragged and adjust its position to the nearest grid.
     *
     * @param node The node to be made draggable.
     * @param shapeCreator The instance of the figure, it provides the limits and an id to the node.
     */
    public void makeDraggable(Node node, ShapeCreator shapeCreator) {
        if (gameOn) {
            node.setOnMousePressed(mouseEvent -> {
                posMouseX = mouseEvent.getSceneX() - node.getLayoutX();
                posMouseY = mouseEvent.getSceneY() - node.getLayoutY();
            });

            node.setOnMouseDragged(mouseEvent -> {
                double newX = mouseEvent.getSceneX() - posMouseX;
                double newY = mouseEvent.getSceneY() - posMouseY;

                if (shapeCreator.isWithinBounds(newX, newY)){
                    node.setLayoutX(newX);
                    node.setLayoutY(newY);
                }
            });

            node.setOnMouseReleased(mouseEvent -> {
                posMouseX = 0;
                posMouseY = 0;

                try {
                    adjustToClosestPosition(node, shapeCreator);
                    shapeCreator.setLayoutX(node.getLayoutX()); // Actualizar layoutX en ShapeCreator
                    shapeCreator.setLayoutY(node.getLayoutY()); // Actualizar layoutY en ShapeCreator
                } catch (InvalidPositionException e){
                    System.err.println("Error: " + e.getMessage());
                }
            });
        } else {
            System.out.printf("Game On");
        }
    }

    /**
     * Adjust the position of a node to the nearest grid.
     *
     * @param node The node to be adjusted
     * @param shapeCreator The instance of the figure, provides the node ID.
     * @throws InvalidPositionException if the calculated position is not valid.
     */
    public void adjustToClosestPosition(Node node, ShapeCreator shapeCreator) throws InvalidPositionException {
        int id = shapeCreator.getId();
        double currentY = node.getLayoutY();
        double[] positionsY = {
                POSITION_Y1, POSITION_Y2, POSITION_Y3, POSITION_Y4, POSITION_Y5,
                POSITION_Y6, POSITION_Y7, POSITION_Y8, POSITION_Y9, POSITION_Y10
        };

        closestY = positionsY[0];
        double minDifferenceY = Math.abs(currentY - positionsY[0]);

        for (int i = 1; i < positionsY.length; i++) {
            double difference = Math.abs(currentY - positionsY[i]);
            if (difference < minDifferenceY) {
                closestY = positionsY[i];
                minDifferenceY = difference;
            }
        }

        // Ajustar posición X
        double currentX = node.getLayoutX();
        double[] positionsX = {
                POSITION_X1, POSITION_X2, POSITION_X3, POSITION_X4, POSITION_X5,
                POSITION_X6, POSITION_X7, POSITION_X8, POSITION_X9, POSITION_X10
        };
        closestX = positionsX[0];
        double minDifferenceX = Math.abs(currentX - positionsX[0]);

        for (int i = 1; i < positionsX.length; i++) {
            double differenceX = Math.abs(currentX - positionsX[i]);
            if (differenceX < minDifferenceX) {
                closestX = positionsX[i];
                minDifferenceX = differenceX;
            }
        }


        node.setLayoutY(closestY);
        node.setLayoutX(closestX);

        // Output for debugging
        System.out.println("-- closestX: " + closestX);
        System.out.println("-- closestY: " + closestY);
        System.out.println("ACA HAY UN BARCO");

        // Print the final position
        double ultimaPosicionX = closestX;
        double ultimaPosicionY = closestY;
        ultimasPosicionesX.put(id, ultimaPosicionX);
        ultimasPosicionesY.put(id, ultimaPosicionY);
        agregarPosiciones(id, closestX, closestY, shapeCreator);
        addValidPos(id);
        System.out.println("Última posición X del Barco: " + ultimaPosicionX);
        System.out.println("Última posición Y del Barco: " + ultimaPosicionY);
        System.out.println("Posición de cuadrícula calculada: " + convertToGridPosition(closestX, closestY));
        turns = shapeCreator.getTurns();
        System.out.println("Los giros son: " + turns);
    }

    /**
     * Converts X and Y coordinates to a grid position.
     *
     * @param x The X coordinate.
     * @param y The Y coordinate.
     * @return The position on the grid in format (row, column)
     */
    private String convertToGridPosition(double x, double y) {
        int column = (int) ((x - POSITION_X1) / 32) + 1;
        int row = (int) ((y - POSITION_Y1) / 32) + 1;
        System.out.println("Columna calculada: " + column + ", Fila calculada: " + row);
        return "(" + row + ", " + column + ")";
    }

    /**
     * Prints the final positions of all boats.
     */
    public void imprimirPosicionesFinales() {
        System.out.println("Posiciones finales de todos los barcos:");
        for (int id : ultimasPosicionesX.keySet()) {
            System.out.println("Barco " + id + " en X: (" + ultimasPosicionesX.get(id) + ")");
            System.out.println("Barco " + id + " en Y: (" + ultimasPosicionesY.get(id) + ")");
        }
    }

    /**
     * Adds additional positions to the ships according to their orientation and size.
     * @param id The ship ID.
     * @param closestX The closest X coordinate.
     * @param closestY The closest Y coordinate.
     * @param shapeCreator The instance of the figure that provides the node ID.
     */
    public void agregarPosiciones(int id, double closestX, double closestY, ShapeCreator shapeCreator) {
        ultimasPosicionesX.put(id, closestX);
        ultimasPosicionesY.put(id, closestY);

        // Obtener el primer dígito del id
        int primerDigito = Integer.parseInt(Integer.toString(id).substring(0, 1));

        // Si el primer dígito es 2, 3 o 4, añadir posiciones adicionales
        if (primerDigito >= 2 && primerDigito <= 4) {
            if (shapeCreator.getTurns() == 1) {
                for (int i = 1; i < primerDigito; i++) {
                    closestY += 32;
                    ultimasPosicionesX.put(id * 10 + (i + 1), closestX);
                    ultimasPosicionesY.put(id * 10 + (i + 1), closestY);
                }
            } else if (shapeCreator.getTurns() == 2) {
                for (int i = 1; i < primerDigito; i++) {
                    closestX += 32; // Añadir un desplazamiento constante para cada barco subsiguiente
                    ultimasPosicionesX.put(id * 10 + (i + 1), closestX);
                    ultimasPosicionesY.put(id * 10 + (i + 1), closestY);
                }
            }
        }
    }

    /**
     * Returns the list of valid positions
     *
     * @return The list of valid positions
     */
    public List<Integer> getValidPos() {
        return validPos;
    }

    /**
     * Adds a valid position to the list.
     *
     * @param id The ID of the valid position.
     */
    public void addValidPos(int id) {
        if (!validPos.contains(id)) {
            validPos.add(id);
        }
    }

    /**
     * Disables mouse events for a node
     * @param node The node for which mouse events will be disabled.
     */
    public void disableMouseEvents(Node node) {
        node.setDisable(true);
        node.setPickOnBounds(false);
    }

    /**
     * Returns the map of the last X coordinates of the ships.
     * @return The map of the last X coordinates of the ships.
     */
    public Map<Integer, Double> getUltimasPosicionesX() {
        return ultimasPosicionesX;
    }

    /**
     * Returns the map of the last Y coordinates of the ships.
     * @return the map of the last Y coordinates of the ships.
     */
    public Map<Integer, Double> getUltimasPosicionesY() {
        return ultimasPosicionesY;
    }


}