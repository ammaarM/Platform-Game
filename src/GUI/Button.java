package GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Button extends JPanel {
    private static JButton pauseButton;

    public static Button createButton(){
        Button but = new Button();

        pauseButton = new JButton("Pause");
        //pauseButton.addChangeListener(but);
        // set Font for the slider
        pauseButton.setFont(new Font("Arial", Font.ITALIC, 10));

        but.add(pauseButton);

        return but;
    }
}
