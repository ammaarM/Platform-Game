package game;

import Levels.GameLevel;
import Levels.Level1;
import Levels.Level2;
import Models.HollowKnight;
import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {
    private Image background;
    private GameLevel level = Game.getLevel();

    public GameView(World w, int width, int height) {
        super(w, width, height);
        //sets the background image
        if (Game.level instanceof Level1){
            background = new ImageIcon("data/background.png").getImage();
        } else if (Game.level instanceof Level2){
            background = new ImageIcon("data/backgroundold.jpg").getImage();
        }

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

