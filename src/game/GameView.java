package game;

import Models.HollowKnight;
import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {
    private Image background;

    public GameView(World w, int width, int height) {
        super(w, width, height);
        //sets the background image
        background = new ImageIcon("data/background.png").getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.drawString("Kills: " + HollowKnight.getKills(), 10, 20);
        g.drawString("HP: " + HollowKnight.getHealth(), 100, 20 );
    }
}

