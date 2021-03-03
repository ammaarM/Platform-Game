package Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import Models.HollowKnight;
import Models.Mob;
import Models.Slash;
import Models.SlashInv;
import org.jbox2d.common.Vec2;

public class MobCollision  implements CollisionListener {
    private HollowKnight hollowKnight;
    private Mob mob;
    public MobCollision(Mob m){ this.mob = m;}

    //Destroys the mob if it gets hit by the slash and increments the kill counter by one. After it kills the mob a new mob is spawned to be killed.
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Slash){
            HollowKnight.setKills();
            e.getOtherBody().destroy();
            mob.destroy();
            mob = new Mob(mob.getWorld());
            mob.setPosition(new Vec2(8,0));
            MobCollision mobCollision = new MobCollision(mob);
            mob.addCollisionListener(mobCollision);
        }
        else if (e.getOtherBody() instanceof SlashInv){
            HollowKnight.setKills();
            e.getOtherBody().destroy();
            mob.destroy();
            mob = new Mob(mob.getWorld());
            mob.setPosition(new Vec2(8,0));
            MobCollision mobCollision = new MobCollision(mob);
            mob.addCollisionListener(mobCollision);
        }
    }
}
