package Models;

import city.cs.engine.*;

public class Mob extends Walker {
    //Sets the hit box and the image for the model
    private static final Shape mobShape = new PolygonShape(-0.72f,2.56f, -3.37f,-1.69f, -3.01f,-2.59f, 3.15f,-2.65f, 3.36f,2.2f);
    private static final BodyImage image = new BodyImage("data/mob1.png", 6f);

    public Mob(World world) {
        super(world, mobShape);
        addImage(image);
    }
}
