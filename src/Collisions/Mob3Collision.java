package Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import Models.HollowKnight;
import Models.Mob3;
import Models.Slash;
import Models.SlashInv;
import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Mob3Collision  implements CollisionListener {
    private HollowKnight hollowKnight;
    private Mob3 mob3;
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
    public Mob3Collision(Mob3 m){ this.mob3 = m;}

    //Destroys the mob if it gets hit by the slash and increments the kill counter by one. After it kills the mob a new mob is spawned to be killed.
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Slash){
            HollowKnight.setKills();
            mobDeath.play();
            e.getOtherBody().destroy();
            mob3.destroy();
            mob3 = new Mob3(mob3.getWorld());
            mob3.setPosition(new Vec2((float) (Math.random() * (max - min + 1) + min),((float) (Math.random()*40))));
            Mob3Collision mob3Collision = new Mob3Collision(mob3);
            mob3.addCollisionListener(mob3Collision);
        }
        else if (e.getOtherBody() instanceof SlashInv){
            HollowKnight.setKills();
            mobDeath.play();
            e.getOtherBody().destroy();
            mob3.destroy();
            mob3 = new Mob3(mob3.getWorld());
            mob3.setPosition(new Vec2((float) (Math.random()*30),0));
            Mob3Collision mob3Collision = new Mob3Collision(mob3);
            mob3.addCollisionListener(mob3Collision);
        }
    }
}
