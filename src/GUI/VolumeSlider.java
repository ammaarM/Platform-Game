package GUI;

import Levels.GameLevel;
import city.cs.engine.SoundClip;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class VolumeSlider extends JPanel implements ChangeListener {

    // slider
    public static JSlider b;
    // label
    static JLabel l;
    public static double volume;
    private static JPanel mainPanel;

    //private GameLevel level = Game.;
    private static SoundClip gameMusic;

    // main class
    public static VolumeSlider createSlider() {
        // create a object
        VolumeSlider s = new VolumeSlider();
        // create label
        l = new JLabel();
        // create a panel
        //JPanel p = new JPanel();

        // create a slider
        b = new JSlider(0, 100, 50);
        // paint the ticks and tracks
        b.setPaintTrack(true);
        b.setPaintTicks(true);
        b.setPaintLabels(true);
        // set spacing
        b.setMajorTickSpacing(50);
        b.setMinorTickSpacing(5);
        // setChangeListener
        b.addChangeListener(s);
        // set orientation of slider
        b.setOrientation(SwingConstants.VERTICAL);
        // set Font for the slider
        b.setFont(new Font("Serif", Font.ITALIC, 20));
        // add slider to panel
        s.add(b);
        s.add(l);

        // set the size of frame
        s.setSize(300, 300);
        //f.show();
        return s;
    }
    // if JSlider value is changed
    public void stateChanged(ChangeEvent e) {
        //l.setText("BGM Volume = " + b.getValue());
        System.out.println(getVolume());
        GameLevel.gameMusic.setVolume(volume);
    }

    public static Double getVolume() {
        double temp = b.getValue();
        if (temp>0) {
            volume = temp / 100;
        }
        else volume = 0.0001;

        return volume;
    }
    public static JPanel getMainPanel(){return mainPanel;}
}