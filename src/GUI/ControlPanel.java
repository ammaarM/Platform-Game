package GUI;


import game.Game;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControlPanel extends JPanel implements ChangeListener {

    private JPanel mainPanel;
    private JButton pausePlayButton;
    private JButton restartButton;
    private JSlider volume;
    private Game game;

    public ControlPanel(){
        super();
        volume.setOrientation(SwingConstants.VERTICAL);
        volume.addChangeListener(e -> getVolume());

    }

    private double getVolume() {
        double soundLevel = (double) this.volume.getValue() / 100;
        return soundLevel;
    }

    public JPanel getMainPanel(){return  mainPanel;}

    @Override
    public void stateChanged(ChangeEvent e) {
        repaint();
    }
}
