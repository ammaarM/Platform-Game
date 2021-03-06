package GUI;

import Levels.GameLevel;
import city.cs.engine.SoundClip;
import game.Game;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VolumeSlider extends JPanel implements ChangeListener {

    // slider
    private static JSlider volumeSlider;
    // label
    static JLabel volumeLabel;
    private static double volume;
    private static JPanel mainPanel;
    private static JButton pauseButton;
    private static JButton quitButton;
    private static int state = 0;

    //private GameLevel level = Game.;
    private static SoundClip gameMusic;

    // main class
    public static VolumeSlider createSlider() {
        // create a object
        VolumeSlider slide = new VolumeSlider();

        // create a slider
        volumeSlider = new JSlider(0, 100, 50);
        // paint the ticks and tracks
        volumeSlider.setPaintTrack(true);
        volumeSlider.setPaintTicks(true);
        // set spacing
        volumeSlider.setMajorTickSpacing(50);
        volumeSlider.setMinorTickSpacing(10);
        // setChangeListener
        volumeSlider.addChangeListener(slide);
        // set orientation of slider
        volumeSlider.setOrientation(SwingConstants.VERTICAL);
        // set Font for the slider
        volumeSlider.setFont(new Font("Arial", Font.ITALIC, 10));
        // add slider to panel
        slide.add(volumeSlider);

        // set the size of frame
        slide.setSize(300, 300);
        return slide;
    }
    // if JSlider value is changed
    public void stateChanged(ChangeEvent e) {
        //l.setText("BGM Volume = " + b.getValue());
        System.out.println(getVolume());
        GameLevel.gameMusic.setVolume(volume);
    }

    public static Double getVolume() {
        double temp = volumeSlider.getValue();
        if (temp>0) {
            volume = temp / 100;
        }
        else volume = 0.0001;

        return volume;
    }
    public static JPanel getMainPanel(){return mainPanel;}
}