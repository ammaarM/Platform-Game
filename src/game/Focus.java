package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Focus implements MouseListener {

    private GameView view;

    //Gives focus on the gameView so that it can be controlled.
    public Focus(GameView v) {
        this.view = v;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    //Requests focus onto the program once the mouse has been clicked So that it may be control.
    @Override
    public void mouseEntered(MouseEvent e) {
        view.requestFocus();
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
