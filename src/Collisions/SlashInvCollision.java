package Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;
import Models.HollowKnight;
import Models.SlashInv;

public class SlashInvCollision implements CollisionListener {
    private SlashInv slashInv;
    private HollowKnight hollowKnight;

    public SlashInvCollision(SlashInv s){ this.slashInv = s;}

    //The slash is destroyed if it hits a wall or the floor.
    @Override
    public void collide(CollisionEvent e) {
        if(e.getOtherBody() instanceof StaticBody){
            slashInv.destroy();
        }
    }
}
