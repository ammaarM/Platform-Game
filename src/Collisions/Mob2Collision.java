package Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import Models.HollowKnight;
import Models.Mob2;
import Models.Slash;
import Models.SlashInv;
import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Mob2Collision  implements CollisionListener {
    private HollowKnight hollowKnight;
    private Mob2 mob2;
    private static SoundClip mobDeath;
    private int max = 50;
    private int min = -50;

    static {
        try {
            mobDeath = new SoundClip("data/ES_Ghostly Breath With Reverb - SFX Producer.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    public Mob2Collision(Mob2 m){ this.mob2 = m;}

    //Destroys the mob if it gets hit by the slash and increments the kill counter by one. After it kills the mob a new mob is spawned to be killed.
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Slash){
            HollowKnight.setKills();
            mobDeath.play();
            e.getOtherBody().destroy();
            mob2.destroy();
            mob2 = new Mob2(mob2.getWorld());
            mob2.setPosition(new Vec2((float) (Math.random() * (max - min + 1) + min),((float) (Math.random()*30))));
            Mob2Collision mob2Collision = new Mob2Collision(mob2);
            mob2.addCollisionListener(mob2Collision);
        }
        else if (e.getOtherBody() instanceof SlashInv){
            HollowKnight.setKills();
            mobDeath.play();
            e.getOtherBody().destroy();
            mob2.destroy();
            mob2 = new Mob2(mob2.getWorld());
            mob2.setPosition(new Vec2((float) (Math.random()*30),0));
            Mob2Collision mob2Collision = new Mob2Collision(mob2);
            mob2.addCollisionListener(mob2Collision);
        }
    }
}