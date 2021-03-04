package Levels;

import Collisions.Encounter;
import Models.HollowKnight;
import Models.Mob;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import game.Game;

public abstract class GameLevel  extends World {
    public static SoundClip gameMusic;
    // declare models
    private HollowKnight hollowKnight;
    private Mob mob;

    public GameLevel(Game game) {

        hollowKnight = new HollowKnight(this);
        mob = new Mob(this);
        Encounter encounter = new Encounter(this, game);
        hollowKnight.addCollisionListener(encounter);

    }

    public HollowKnight getHollowKnight(){ return hollowKnight;}
    public Mob getMob(){ return mob;}
    public abstract boolean isComplete();
}
