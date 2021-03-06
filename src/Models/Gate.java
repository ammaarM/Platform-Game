package Models;

import city.cs.engine.*;

public class Gate extends StaticBody {
    private static final Shape gateShape = new PolygonShape(-1.19f,2.39f, -1.18f,-2.49f, 1.16f,-2.46f, 1.18f,2.41f);
    private static final BodyImage image = new BodyImage("data/Shade_Gate.png", 5f);


    public Gate(World world) {
        super(world, gateShape);
        addImage(image);
    }
}
