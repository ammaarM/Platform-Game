package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ViewPanel extends JPanel implements ChangeListener{
    public ViewPanel() {
        super();
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(240, 320));
    }

    /**
     * Notify the view of a change in the model, so that the view should
     * be repainted.
     * @param e description of the change
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        repaint();
    }
}
