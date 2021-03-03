package Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;
import Models.HollowKnight;
import Models.Slash;

public class SlashCollision implements CollisionListener {
    private Slash slash;
    private HollowKnight hollowKnight;


    public SlashCollision(Slash s){ this.slash = s;}

    //The slash is destroyed if it hits a wall or the floor.
    @Override
    public void collide(CollisionEvent e) {
        if(e.getOtherBody() instanceof StaticBody){
            slash.destroy();
        }
    }
}
