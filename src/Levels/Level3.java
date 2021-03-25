package Levels;

import Collisions.Mob2Collision;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import Collisions.Collision;
import game.Game;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Level3  extends GameLevel {
    private Game game;

    public Level3(Game game){
        //the base class will create the student, professor
        //and the ProfessorEncounter
        super(game);

        try {
            gameMusic = new SoundClip("data/Hollow Knight OST - Dirtmouth.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continuous playback (looping)
            gameMusic.setVolume(0.1);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)  {
            System.out.println(e);
        }

        //game.updateFrame();

        //we still need to set the positions of the student
        //and professor
        getHollowKnight().setPosition(new Vec2(8, -10));
        getMob2().setPosition(new Vec2(-8,-10));

        //we're setting up BooksPickup here though we could
        //also add it to the GameLevel class
        //getHollowKnight().addCollisionListener(new Collision(getHollowKnight()));
        getMob2().addCollisionListener(new Mob2Collision(getMob2()));

        // Ground
        Shape shape = new BoxShape(50, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -13f));

        // make some platforms
        Shape platformShape = new BoxShape(6f, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(10f, -5));

        StaticBody platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(-10f, -5));

        StaticBody platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(10f, 5));

        StaticBody platform4 = new StaticBody(this, platformShape);
        platform4.setPosition(new Vec2(-10f, 5));

        StaticBody platform5 = new StaticBody(this, platformShape);
        platform5.setPosition(new Vec2(10f, 15));

        StaticBody platform6 = new StaticBody(this, platformShape);
        platform6.setPosition(new Vec2(-10f, 15));

    }

    @Override
    public String getLevelName(){
        return "Level3";
    }

    @Override
    public boolean isComplete() {
        if (getHollowKnight().getKills() >= 10)
            return true;
        else
            return false;
    }
}

