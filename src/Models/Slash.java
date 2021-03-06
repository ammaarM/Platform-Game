package Models;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Slash extends DynamicBody {
    //Sets the hit box and the image for the model
    private static final Shape slashShape = new PolygonShape(0.093f,-0.905f, 0.543f,-1.075f, 1.063f,-1.005f, 1.148f,-0.425f, 0.683f,0.39f, -0.037f,0.9f, -0.792f,1.125f, -1.067f,1.09f);
    private static final BodyImage image = new BodyImage("data/slash.png", 2.5f);
    private static SoundClip slashSound;

    static {
        try {
            slashSound = new SoundClip("data/ES_Whoosh Pan - SFX Producer.wav");
            System.out.println("Loading slash sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public Slash(World w) {
        super(w,slashShape);
        setGravityScale(0);
        addImage(image);
        slashSound.play();
        slashSound.setVolume(0.1);
    }
}
