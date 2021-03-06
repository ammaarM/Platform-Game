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

        pauseButton = new JButton("Pause/Play");
        pauseButton.setFont(new Font("Arial", Font.ITALIC, 10));
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (state == 0){
                    Game.level.stop();
                    state = 1;
                }else{
                    Game.level.start();
                    state = 0;
                }
            }
        });
        pauseButton.setLocation(0, -100);
        but.add(pauseButton);


        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Arial", Font.ITALIC, 10));
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.getLevel().stop();
                Game.level.start();
            }
        });

        but.add(quitButton);

        return but;
    }
}
