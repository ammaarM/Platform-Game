package Collisions;

import Models.Gate;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Game;
import Levels.GameLevel;


public class Encounter implements CollisionListener {
    private GameLevel level;
    private Game game;

    public Encounter(GameLevel level, Game game){
        this.level = level;
        this.game = game;
    }
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Gate
                && level.isComplete()){
            level.getGame().goToNextLevel();
        }
    }
}
