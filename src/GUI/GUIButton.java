package GUI;

import game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIButton extends JPanel {
    private static JButton pauseButton;
    private static int state = 0;
    private static JButton quitButton;

    public static GUIButton createButton(){
        GUIButton but = new GUIButton();
        //Makes new JButton
        pauseButton = new JButton("Pause/Play");
        //Sets the font for JButton
        pauseButton.setFont(new Font("Arial", Font.ITALIC, 10));
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
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //closes the game when the quit button is triggered.
                System.exit(0);
            }
        });

        //adds the button tot he JPanel
        but.add(quitButton);

        return but;
    }
}
