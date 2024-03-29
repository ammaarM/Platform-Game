package Levels;

import city.cs.engine.*;
import Collisions.Collision;
import game.Game;
import Collisions.MobCollision;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Level1 extends GameLevel {
    private Game game;

    public Level1(Game game) {
        super(game);

        try {
            // Open an audio input stream
            gameMusic = new SoundClip("data/Hollow Knight OST - Resting Grounds.wav");
            // Set it to continuous playback (looping)
            gameMusic.loop();
            gameMusic.setVolume(0.1);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)  {
            System.out.println(e);
        }

        // Ground
        Shape shape = new BoxShape(50, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -13f));

        // Platform 1
        Shape platformShape = new BoxShape(6f, 0.5f);
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(5f, -4f));

        // Platform 2
        Shape platform2Shape = new BoxShape(6f, 0.5f);
        StaticBody platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(-8f, 4f));



    }

    @Override
    public void populate(Game game) {
        super.populate(game);
        // Models
        getHollowKnight().setPosition(new Vec2(-8, -10));
        getMob().setPosition(new Vec2(8, -10));
        getMob().addCollisionListener(new MobCollision(getMob()));
    }

    @Override
    public String getLevelName(){
        return "Level1";
    }


    @Override
    public boolean isComplete() {
        if (getHollowKnight().getKills() >= 3)
            return true;
        else
            return false;
    }
}
