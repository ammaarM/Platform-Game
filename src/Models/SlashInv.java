package Models;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class SlashInv extends DynamicBody {
    //Sets the hit box and the image for the model
    private static final Shape slashShape = new PolygonShape(-0.102f,-0.905f, -0.642f,-1.075f, -1.157f,-0.965f, -1.072f,-0.35f, -0.762f,0.245f, -0.042f,0.855f, 0.633f,1.085f, 1.038f,1.1f);
    private static final BodyImage image = new BodyImage("data/slashInv.png", 2.5f);
    private static SoundClip slashSound;

    static {
        try {
            slashSound = new SoundClip("data/ES_Whoosh Pan - SFX Producer.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public SlashInv(World w) {
        super(w,slashShape);
        setGravityScale(0);
        addImage(image);
        slashSound.play();
        slashSound.setVolume(0.1);
    }
}