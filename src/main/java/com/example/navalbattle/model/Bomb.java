package com.example.navalbattle.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bomb {
    private ImageView imageBomb;
    private double posImgX, posImgY;

    public Bomb(){
        imageBomb = new ImageView(new Image(String.valueOf(getClass().getResource("/com/example/navalbattle/images/Tocado.png"))));
        imageBomb.setFitHeight(32);
        imageBomb.setFitWidth(32);
        imageBomb.setViewOrder(3);
        // No configurar LayoutX y LayoutY aquí, ya que se configurarán después.
    }

    public ImageView getImageView(){
        return imageBomb;
    }

    public double getPosImgX(){
        return posImgX;
    }

    public double getPosImgY(){
        return posImgY;
    }

    public void setPosImgX(double posImgX){
        this.posImgX = posImgX;
        imageBomb.setLayoutX(posImgX);
    }

    public void setPosImgY(double posImgY){
        this.posImgY = posImgY;
        imageBomb.setLayoutY(posImgY);
    }
}