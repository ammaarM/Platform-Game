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

public class Level4  extends GameLevel {

    public Level4(Game game){
        //the base class will create the student, professor
        //and the ProfessorEncounter
        super(game);

        try {
            gameMusic = new SoundClip("data/Hollow Knight OST - False Knight.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continuous playback (looping)
            gameMusic.setVolume(0.1);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)  {
            System.out.println(e);
        }

        game.updateFrame();

        //we still need to set the positions of the student
        //and professor
        getHollowKnight().setPosition(new Vec2(8, -10));
        getMob().setPosition(new Vec2(-8,-10));

        //we're setting up BooksPickup here though we could
        //also add it to the GameLevel class
        getHollowKnight().addCollisionListener(new Collision(getHollowKnight()));
        getMob().addCollisionListener(new MobCollision(getMob()));

        // Ground
        Shape shape = new BoxShape(50, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -13f));

        // make some walls
        Shape wallShape = new BoxShape(0.5f, 6f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-11.5f, -6));

        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(11.5f, -6));



    }
    @Override
    public boolean isComplete() {
        if (getHollowKnight().getKills() >= 10)
            return true;
        else
            return false;
    }
}

