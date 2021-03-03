package game;

import Models.HollowKnight;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

//This class will be used when the game will follow the character around the world.

public class Tracker implements StepListener {
    private GameView view;
    private HollowKnight hollowKnight;
    public Tracker(GameView view, HollowKnight hollowKnight){
        this.view = view;
        this.hollowKnight = hollowKnight;
    }

    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) { view.setCentre(new Vec2(hollowKnight.getPosition())); }
}
