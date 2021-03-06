package Levels;

import Collisions.Collision;
import Collisions.Encounter;
import Models.HollowKnight;
import Models.*;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import game.Game;
import org.jbox2d.common.Vec2;

public abstract class GameLevel  extends World {
    public static SoundClip gameMusic;
    // declare models
    private GameLevel level;
    private HollowKnight hollowKnight;
    private Mob mob;
    private Mob2 mob2;
    private Mob3 mob3;
    private Gate gate;

    public GameLevel(Game game) {

        hollowKnight = new HollowKnight(this);
        mob = new Mob(this);
        mob2 = new Mob2(this);
        mob3 = new Mob3(this);
        gate = new Gate(this);

        mob.setPosition(new Vec2(100, -100));
        mob2.setPosition(new Vec2(100, -100));
        mob3.setPosition(new Vec2(100, -100));
        gate.setPosition(new Vec2(50, -10));

        Encounter encounter = new Encounter(this, game);
        hollowKnight.addCollisionListener(encounter);
        hollowKnight.addCollisionListener(new Collision(hollowKnight));

    }

    public HollowKnight getHollowKnight(){ return hollowKnight;}
    public Mob getMob(){ return mob;}
    public Mob2 getMob2() { return mob2;}
    public Mob3 getMob3() { return mob3;}

    public abstract boolean isComplete();
}
