package Levels;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import Collisions.Collision;
import game.Game;
import Collisions.MobCollision;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Level2  extends GameLevel {
    private Game game;

    public Level2(Game game){
        super(game);
        try {
            gameMusic = new SoundClip("data/Hollow Knight OST - Enter Hallownest.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continuous playback (looping)
            gameMusic.setVolume(0.1);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)  {
            System.out.println(e);
        }




        // Ground
        Shape shape = new BoxShape(50, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -13f));

        // make some platforms
        Shape platformShape = new BoxShape(6f, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(20f, -5));

        StaticBody platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(-20f, -5));

        StaticBody platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(0, 5));

        StaticBody platform4 = new StaticBody(this, platformShape);
        platform4.setPosition(new Vec2(20f, 10));

        StaticBody platform5 = new StaticBody(this, platformShape);
        platform5.setPosition(new Vec2(-20f, 10));

    }

    @Override
    public void populate(Game game) {
        super.populate(game);
        getHollowKnight().setPosition(new Vec2(8, -10));
        getMob().setPosition(new Vec2(-8,-10));

        //also add it to the GameLevel class
        getMob().addCollisionListener(new MobCollision(getMob()));
    }

    @Override
    public String getLevelName() {
        return "Level2";
    }

    @Override
    public boolean isComplete() {
        if (getHollowKnight().getKills() >= 3)
            return true;
        else
            return false;
    }
}
