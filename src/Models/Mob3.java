package Models;

import city.cs.engine.*;

public class Mob3 extends Walker {
    //Sets the hit box and the image for the model
    private static final Shape mobShape = new PolygonShape(-1.76f,4.52f, -3.58f,-0.56f, -1.42f,-4.74f, 1.94f,-4.64f, 3.44f,-2.6f, 2.64f,4.6f);
    private static final BodyImage image = new BodyImage("data/mob3.png", 10f);

    public Mob3(World world) {
        super(world, mobShape);
        addImage(image);
    }
}
