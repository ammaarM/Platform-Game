package GUI;

import game.Game;
import saveLoad.GameSaverLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUIButton extends JPanel {
    private static JButton pauseButton;
    private static int state = 0;
    private static JButton quitButton;
    private static JButton saveButton;
    private static JButton loadButton;

    public static GUIButton createButton(){
        GUIButton but = new GUIButton();
        Color panel = new Color(78, 48, 84);
        but.setBackground(panel);
        //Makes new JButton
        pauseButton = new JButton("Pause/Play");
        //Sets the font for JButton
        pauseButton.setFont(new Font("Arial", Font.ITALIC, 10));
        Color color = new Color(60, 27, 67);
        Color foreColor = new Color(255,255,255);
        pauseButton.setBackground(color);
        pauseButton.setForeground(foreColor);
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (state == 0){
                    //pauses the game
                    System.out.println("Game is paused");
                    Game.level.stop();
                    state = 1;
                }else{
                    System.out.println("Game is unpaused");
                    Game.level.start();
                    state = 0;
                }
            }
        });
        //adds the button tot he JPanel
        but.add(pauseButton);

        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Arial", Font.ITALIC, 10));
        quitButton.setBackground(color);
        quitButton.setForeground(foreColor);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //closes the game when the quit button is triggered.
                System.exit(0);
            }
        });
        //adds the button tot he JPanel


        saveButton = new JButton("Save");
        saveButton.setFont(new Font("Arial", Font.ITALIC, 10));
        saveButton.setBackground(color);
        saveButton.setForeground(foreColor);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Saving Game State");
                try {
                    GameSaverLoader.save(Game.getLevel(), "data/save.txt");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        but.add(saveButton);

        loadButton = new JButton("Load");
        loadButton.setFont(new Font("Arial", Font.ITALIC, 10));
        loadButton.setBackground(color);
        loadButton.setForeground(foreColor);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Loading Game State");
                try {
                    GameSaverLoader.load(Game.getLevel(), "data/save.txt");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        but.add(loadButton);
        but.add(quitButton);

        return but;
    }
}
