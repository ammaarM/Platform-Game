package Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import Models.HollowKnight;
import Models.Mob;

public class Collision implements CollisionListener {

    private HollowKnight hollowKnight;

    public Collision(HollowKnight h) {
        this.hollowKnight = h;
    }

    // If the hollow knight touches the Mob it will die and it will be game over.
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Mob) {
            //hollowKnight.destroy();
            HollowKnight.setHealth();
            //System.out.println("GAME OVER!!!");
        }
    }
}
