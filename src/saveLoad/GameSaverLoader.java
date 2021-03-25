package saveLoad;


import Levels.*;
import Models.HollowKnight;
import game.Game;
import game.HollowKnightController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameSaverLoader {

    public static void save(GameLevel level, String fileName)throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, false);
            writer.write(Game.level.getLevelName() + "," + HollowKnightController.getHealth() + "," + HollowKnight.getKills() + "\n");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }
    public static GameLevel load(GameLevel level, String fileName) throws IOException{
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();

            // file is assumed to contain one name, score pair per line
            String[] tokens = line.split(",");
            String currentLevel = tokens[0];
            int health = Integer.parseInt(tokens[1]);
            int kills = Integer.parseInt(tokens[2]);
            System.out.println("Level: " + currentLevel + ", health: " + health + ", kills: " + kills);

            if (currentLevel.equals("Level1")){
                level.getGame().setLevel(1);
            }else if(currentLevel.equals("Level2")){
                level.getGame().setLevel(2);
            }else if(currentLevel.equals("Level3")){
                level.getGame().setLevel(3);
            }else if(currentLevel.equals("Level4")){
                level.getGame().setLevel(4);
            }

            HollowKnightController.changeHealth(health);
            HollowKnight.changeKills(kills);


            line = reader.readLine();


            System.out.println("...done.");
            return level;
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }
}