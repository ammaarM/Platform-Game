package saveLoad;


import Collisions.Collision;
import Collisions.Encounter;
import Levels.*;
import Models.HollowKnight;
import Models.Mob;
import Models.Mob2;
import Models.Mob3;
import city.cs.engine.DynamicBody;
import game.Game;
import game.HollowKnightController;
import org.jbox2d.common.Vec2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameSaverLoader {

    public static void save(GameLevel level, String fileName)throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, false);
            writer.write(Game.getLevel().getLevelName() + "\n");

            for(DynamicBody body : level.getDynamicBodies()) {
                if (body instanceof HollowKnight) {
                    writer.write("HollowKnight" + "," + body.getPosition().x + "," + body.getPosition().y + "," + HollowKnightController.getHealth() + "," + HollowKnight.getKills() + "\n");
                } else if (body instanceof Mob) {
                    try {
                        writer.write("Mob" + "," + body.getPosition().x + "," + body.getPosition().y + "\n");
                    }catch (Exception e) {
                    }
                } else if (body instanceof Mob2){
                    try {
                        writer.write("Mob2" + "," + body.getPosition().x + "," + body.getPosition().y + "\n");
                    }catch (Exception e) {
                    }
                } else if (body instanceof Mob3){
                    try {
                        writer.write("Mob3" + "," + body.getPosition().x + "," + body.getPosition().y + "\n");
                    }catch (Exception e) {
                    }
                }
            }
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

            level.setHollowKnight(level.getHollowKnight());
            if (line.equals("Level1")){
                level.getGame().setLevel(1);
            }else if(line.equals("Level2")){
                level.getGame().setLevel(2);
            }else if(line.equals("Level3")){
                level.getGame().setLevel(3);
            }else if(line.equals("Level4")){
                level.getGame().setLevel(4);
            }

            line = reader.readLine();

            while(line != null){
                String[] tokens = line.split(",");
                if (tokens[0].equals("HollowKnight")){
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    level.getGame().locateHollowKnight(x, y);

                    int health = Integer.parseInt(tokens[3]);
                    int kills = Integer.parseInt(tokens[4]);
                    HollowKnightController.changeHealth(health);
                    HollowKnight.changeKills(kills);



                } else if (tokens[0].equals("Mob")){
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    try {
                        level.getGame().locateMob(x, y);
                    } catch (Exception e) {
                        return null;
                    }
                } else if (tokens[0].equals("Mob2")){
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    try {
                        level.getGame().locateMob2(x, y);
                    } catch (Exception e) {
                        return null;
                    }
                } else if (tokens[0].equals("Mob3")){
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    try {
                        level.getGame().locateMob3(x, y);
                    } catch (Exception e) {
                        return null;
                    }
                }

                line = reader.readLine();
            }

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