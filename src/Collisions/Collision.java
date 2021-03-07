package Collisions;

import Models.Mob2;
import Models.Mob3;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import Models.HollowKnight;
import Models.Mob;
import game.HollowKnightController;

public class Collision implements CollisionListener {

    private HollowKnight hollowKnight;

    public Collision(HollowKnight h) {
        this.hollowKnight = h;
    }

    // If the hollow knight touches the Mob it will die and it will be game over.
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Mob) {
            HollowKnightController.setHealth();
        }else if(e.getOtherBody() instanceof Mob2){
            HollowKnightController.setHealth();
        }else if(e.getOtherBody() instanceof Mob3){
            HollowKnightController.setHealth();
        }
    }
}
