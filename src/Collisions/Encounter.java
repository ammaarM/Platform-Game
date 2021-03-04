package Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Game;
import Levels.GameLevel;
import Models.Mob;

public class Encounter implements CollisionListener {
    private GameLevel level;
    private Game game;

    public Encounter(GameLevel level, Game game){
        this.level = level;
        this.game = game;
    }
    @Override
    public void collide(CollisionEvent e) {
        //if student collided with professor and the
        //conditions for completing the level are fulfilled
        //goToNextLevel
        if (e.getOtherBody() instanceof Mob
                && level.isComplete()){
            game.goToNextLevel();
        }
    }
}
