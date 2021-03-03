package game;

import Collisions.Collision;
import Collisions.MobCollision;
import Models.HollowKnight;
import Models.Mob;
import Models.Slash;
import Models.SlashInv;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {

    // declare models
    private HollowKnight hollowKnight;
    private Mob mob;
    private Slash slash;
    private SlashInv slashInv;

    public GameWorld() {
        //super(60);
        // Ground
        Shape shape = new BoxShape(25, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -13f));

        // LeftWall
        Shape leftShape = new BoxShape(0.1f, 30f);
        StaticBody leftWall = new StaticBody(this, leftShape);
        leftWall.setPosition(new Vec2(-22.5f, -12.9f));

        // RightWall
        Shape rightShape = new BoxShape(0.1f, 30f);
        StaticBody rightWall = new StaticBody(this, rightShape);
        rightWall.setPosition(new Vec2(22.5f, -12.9f));

        // Platform 1
        Shape platformShape = new BoxShape(6f, 0.5f);
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(5f, -4f));

        // Platform 2
        Shape platform2Shape = new BoxShape(6f, 0.5f);
        StaticBody platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(-8f, 4f));

        // Model 1
        hollowKnight = new HollowKnight(this);
        hollowKnight.setPosition(new Vec2(-8, -10));
        Collision collision = new Collision(hollowKnight);
        hollowKnight.addCollisionListener(collision);

        // Model 2
        mob = new Mob(this);
        mob.setPosition(new Vec2(8, -10));
        MobCollision mobCollision = new MobCollision(mob);
        mob.addCollisionListener(mobCollision);
    }

    public HollowKnight getHollowKnight() {
        return hollowKnight;
    }
}
