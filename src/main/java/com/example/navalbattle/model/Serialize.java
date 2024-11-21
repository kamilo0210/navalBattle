package com.example.navalbattle.model;

import java.io.*;

public class Serialize {

    private static final String FILE_PATH = "game_data.ser";
    private static final String FILE_NAME = "nickname.ser";


    public void saveGame(String nickname, GameData gameData) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            System.out.println("Guardando juego para: " + nickname);
            oos.writeObject(nickname); // Escribe el nickname primero
            oos.writeObject(gameData); // Luego escribe los datos del juego
            System.out.println("Juego guardado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public GameData loadGame(String nickname) {
        File file = new File(FILE_PATH);

        // Verificar si el archivo de datos existe
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("Archivo de datos del juego creado.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        // Verificar si el archivo está vacío antes de intentar leer
        if (file.length() == 0) {
            System.out.println("El archivo de datos está vacío.");
            return null;
        }

        // Intentar cargar los datos del archivo
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            String savedNickname = (String) ois.readObject(); // Lee el nickname guardado
            System.out.println("Nickname guardado: " + savedNickname);
            if (savedNickname.equals(nickname)) {
                GameData gameData = (GameData) ois.readObject(); // Lee los datos del juego
                System.out.println("Datos del juego cargados correctamente.");
                return gameData;
            } else {
                System.out.println("No se encontró un juego guardado con el nickname: " + nickname);
            }
        } catch (EOFException e) {
            System.out.println("Error de archivo vacío o no válido: EOFException.");
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null; // No se encontró un juego guardado con ese nickname
    }


    public void saveNickname(String nickname) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(nickname);
            System.out.println("Nickname guardado correctamente!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String loadNickname() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (String) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}



