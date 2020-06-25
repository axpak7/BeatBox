package com.company.serialization;

import java.io.*;

public class GameSaverTest {
    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50, "Elf", new String[]{"bow", "sword", "knuckle"});
        GameCharacter two = new GameCharacter(200, "Troll", new String[]{"bare hands", "axe"});
        GameCharacter three = new GameCharacter(120, "Witcher", new String[]{"spells", "invisibility"});

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        one = null;
        two = null;
        three = null;

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();

            oneRestore.printAtribute();
            twoRestore.printAtribute();
            threeRestore.printAtribute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
