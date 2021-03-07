package Models;

import city.cs.engine.*;

public class Mob2 extends Walker {
    //Sets the hit box and the image for the model
    private static final Shape mobShape = new PolygonShape(-2.15f,2.59f, -2.58f,-2.05f, -0.51f,-2.74f, 1.65f,-2.66f, 2.32f,-0.44f, 2.22f,2.63f);
    private static final BodyImage image = new BodyImage("data/mob2.png", 6f);


    public Mob2(World world) {
        super(world, mobShape);
        addImage(image);
    }
}
