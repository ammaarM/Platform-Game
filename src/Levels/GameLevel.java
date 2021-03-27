package Levels;

import Collisions.Collision;
import Collisions.Encounter;
import Collisions.MobCollision;
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
    private Game game;

    public GameLevel(Game game) {
        gate = new Gate(this);
        gate.setPosition(new Vec2(50, -10));

        this.game = game;
    }

    public void populate(Game game){
        //declares all the models so that they can be called in any level
        this.game = game;
        hollowKnight = new HollowKnight(this);
        mob = new Mob(this);
        mob2 = new Mob2(this);
        mob3 = new Mob3(this);


        //sets the position for the models
        mob.setPosition(new Vec2(100, -100));
        mob2.setPosition(new Vec2(100, -100));
        mob3.setPosition(new Vec2(100, -100));


        //sets the encounter for the hollow knight to go to the next level
        Encounter encounter = new Encounter(this, game);
        hollowKnight.addCollisionListener(encounter);
        hollowKnight.addCollisionListener(new Collision(hollowKnight));
    }

    //getters for the levels to call the models.
    public HollowKnight getHollowKnight(){ return hollowKnight;}
    public void setHollowKnight(HollowKnight h){ hollowKnight = h;}
    public Mob getMob(){ return mob;}
    public void setMob(Mob m){ mob = m;}
    public Mob2 getMob2() { return mob2;}
    public void setMob2(Mob2 m2){ mob2 = m2;}
    public Mob3 getMob3() { return mob3;}
    public void setMob3(Mob3 m3){ mob3 = m3;}

    public Game getGame() {return game;}

    public abstract String getLevelName();
    public abstract boolean isComplete();
}
