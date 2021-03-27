package Levels;

import Collisions.Mob3Collision;
import Collisions.MobCollision;
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

public class Level4  extends GameLevel {
    private Game game;

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
        platform5.setPosition(new Vec2(30f, -5));

        StaticBody platform6 = new StaticBody(this, platformShape);
        platform6.setPosition(new Vec2(-30f, -5));
        
        StaticBody platform7 = new StaticBody(this, platformShape);
        platform7.setPosition(new Vec2(30f, 5));

        StaticBody platform8 = new StaticBody(this, platformShape);
        platform8.setPosition(new Vec2(-30f, 5));

        StaticBody platform9 = new StaticBody(this, platformShape);
        platform9.setPosition(new Vec2(10f, 15));

        StaticBody platform10 = new StaticBody(this, platformShape);
        platform10.setPosition(new Vec2(-10f, 15));

        StaticBody platform11 = new StaticBody(this, platformShape);
        platform11.setPosition(new Vec2(30f, 15));

        StaticBody platform12 = new StaticBody(this, platformShape);
        platform12.setPosition(new Vec2(-30f, 15));

    }

    @Override
    public void populate(Game game) {
        super.populate(game);
        getHollowKnight().setPosition(new Vec2(8, -10));
        getMob3().setPosition(new Vec2(-8,-10));
        getMob3().addCollisionListener(new Mob3Collision(getMob3()));
    }

    @Override
    public String getLevelName(){
        return "Level4";
    }

    @Override
    public boolean isComplete() {
        if (getHollowKnight().getKills() >= 5)
            return true;
        else
            return false;
    }
}

