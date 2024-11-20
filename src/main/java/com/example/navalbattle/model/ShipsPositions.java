package com.example.navalbattle.model;

import java.util.ArrayList;
import java.util.List;

public class ShipsPositions {
    private List<String> shipsPositions;

    public ShipsPositions(){
        shipsPositions = new ArrayList<String>();
        List<String> firstBoard=new ArrayList<>();
        firstBoard.add("A1");
        firstBoard.add("A2");
        firstBoard.add("A3");
        firstBoard.add("A4");
        firstBoard.add("A7");
        firstBoard.add("A8");
        firstBoard.add("C2");
        firstBoard.add("C3");
        firstBoard.add("C4");
        firstBoard.add("C7");
        firstBoard.add("D7");
        firstBoard.add("C9");
        firstBoard.add("E4");
        firstBoard.add("F4");
        firstBoard.add("G4");
        firstBoard.add("F9");
        firstBoard.add("G9");
        firstBoard.add("H7");
        firstBoard.add("G1");
        firstBoard.add("I4");

        List<String> secondBoard=new ArrayList<>();
        secondBoard.add("B3");
        secondBoard.add("B4");
        secondBoard.add("B5");
        secondBoard.add("B7");
        secondBoard.add("B8");
        secondBoard.add("C2");
        secondBoard.add("E3");
        secondBoard.add("E4");
        secondBoard.add("E5");
        secondBoard.add("G2");
        secondBoard.add("G3");
        secondBoard.add("H6");
        secondBoard.add("I6");
        secondBoard.add("I7");
        secondBoard.add("J1");
        secondBoard.add("D8");
        secondBoard.add("F8");
        secondBoard.add("E8");
        secondBoard.add("G8");
        secondBoard.add("D10");

        List<String> thirdBoard=new ArrayList<>();
        thirdBoard.add("A10");
        thirdBoard.add("B1");
        thirdBoard.add("B2");
        thirdBoard.add("B3");
        thirdBoard.add("B4");
        thirdBoard.add("B7");
        thirdBoard.add("B8");
        thirdBoard.add("D2");
        thirdBoard.add("D10");
        thirdBoard.add("E3");
        thirdBoard.add("E4");
        thirdBoard.add("E5");
        thirdBoard.add("F3");
        thirdBoard.add("G3");
        thirdBoard.add("H3");
        thirdBoard.add("F7");
        thirdBoard.add("G7");
        thirdBoard.add("I4");
        thirdBoard.add("J6");
        thirdBoard.add("J7");

        int enemyBoard=(int)(Math.random()*3);//0,1,2
        if(enemyBoard == 0){
            shipsPositions=firstBoard;
        }
        if(enemyBoard == 1){
            shipsPositions=secondBoard;
        }
        if(enemyBoard==2){
            shipsPositions=thirdBoard;
        }

    }
    public List<String> getShipsPositions() {
        return shipsPositions;
    }

    public void setShipsPositions(List<String> shipsPositions) {
        this.shipsPositions = shipsPositions;
    }


}
