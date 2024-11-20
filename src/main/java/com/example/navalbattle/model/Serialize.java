package com.example.navalbattle.model;

import java.io.*;

public class Serialize {

    private static final String FILE_PATH = "game_data.ser";

    public void saveGame(String nickname, GameData gameData) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(nickname);
            oos.writeObject(gameData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GameData loadGame(String nickname) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            String savedNickname = (String) ois.readObject();
            if (savedNickname.equals(nickname)) {
                return (GameData) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null; // No saved game found
    }
}
