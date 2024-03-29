package Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import Models.HollowKnight;
import Models.Mob;
import Models.Slash;
import Models.SlashInv;
import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Random;

public class MobCollision  implements CollisionListener {
    private HollowKnight hollowKnight;
    private Mob mob;
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
    public MobCollision(Mob m){ this.mob = m;}

    //Destroys the mob if it gets hit by the slash and increments the kill counter by one. After it kills the mob a new mob is spawned to be killed.
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Slash){
            HollowKnight.setKills();
            mobDeath.play();
            e.getOtherBody().destroy();
            mob.destroy();
            mob = new Mob(mob.getWorld());
            mob.setPosition(new Vec2((float) (Math.random() * (max - min + 1) + min),0));
            MobCollision mobCollision = new MobCollision(mob);
            mob.addCollisionListener(mobCollision);
        }
        else if (e.getOtherBody() instanceof SlashInv){
            HollowKnight.setKills();
            mobDeath.play();
            e.getOtherBody().destroy();
            mob.destroy();
            mob = new Mob(mob.getWorld());
            mob.setPosition(new Vec2((float) (Math.random()*30),0));
            MobCollision mobCollision = new MobCollision(mob);
            mob.addCollisionListener(mobCollision);
        }
    }
}
