package Models;

import city.cs.engine.*;

public class HollowKnight extends Walker {
    //Sets the hit box and the image for the model
    private static final Shape hollowShape = new PolygonShape(-0.81f,2.24f, -0.99f,-0.29f, -1.0f,-1.69f, -0.79f,-2.21f, 0.67f,-2.24f, 1.15f,-0.28f, 1.17f,2.2f);
    private static final BodyImage image = new BodyImage("data/stillRight.png", 5f);
    private static int kills = 0;
    private static int health = 0;

    public HollowKnight(World world) {
        super(world, hollowShape);
        setGravityScale(10);
        addImage(image);
        kills = 0;
        health = 10;
    }
    //Calls the value of kills
    public static int getKills() {
        return kills;
    }
    //Increments the kills by one then prints it.
    public static void setKills() {
        kills++;
        System.out.println("Kills: " + kills);
    }

    public static int getHealth(){ return health;}

    public static void setHealth(){
        health--;
        System.out.println("HP: " + health);
        if(health == 0){
            System.out.println("Your dead");
            System.exit(0);
        }
    }


    public static void changeKills(int k){
        kills = k;
    }
}
