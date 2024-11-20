package com.example.navalbattle.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SafeShot {

    private ImageView imgWater;
    private double posImgX, posImgY;

    public SafeShot(){
        imgWater = new ImageView(new Image(String.valueOf(getClass().getResource("/com/example/navalbattle/images/Agua.png"))));
        imgWater.setFitHeight(32);
        imgWater.setFitWidth(32);
        // No configurar LayoutX y LayoutY aquí, ya que se configurarán después.
    }

    public ImageView getImageView(){
        return imgWater;
    }

    public double getPosImgX(){
        return posImgX;
    }

    public double getPosImgY(){
        return posImgY;
    }

    public void setPosImgX(double posImgX){
        this.posImgX = posImgX;
        imgWater.setLayoutX(posImgX);
    }

    public void setPosImgY(double posImgY){
        this.posImgY = posImgY;
        imgWater.setLayoutY(posImgY);
    }
}