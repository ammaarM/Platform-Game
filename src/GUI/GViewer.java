package GUI;


import game.Game;

import javax.swing.*;
import java.awt.*;

public class GViewer {

    private Game game;

    public GViewer(){
        JFrame window = new JFrame("Main Menu");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // default layout manager is BorderLayout


        //ViewPanel panel = new ViewPanel(game);
        //window.add(panel, BorderLayout.CENTER);

        JLabel versionLabel = new JLabel();
        versionLabel.setText("Version 5.0");
        window.add(versionLabel, BorderLayout.SOUTH);

        ControlPanel buttons = new ControlPanel();
        window.add(buttons.getMainPanel(), BorderLayout.WEST);

        window.pack();
        window.setVisible(true);
    }
    public static void main(String args[]) {
        new GViewer();
    }
}
