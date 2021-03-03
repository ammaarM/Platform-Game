package game;

import GUI.ControlPanel;
import Levels.Level1;
import Levels.Level2;
import Levels.Level3;
import Levels.Level4;
import city.cs.engine.SoundClip;
import city.cs.engine.UserView;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Game {
    private SoundClip gameMusic;
    private GameLevel level;
    private GameView view;
    private HollowKnightController controller;
    private JFrame frame;
    private UserView wideView;
    private ControlPanel panel;

    public Game() {

        // Initialise level
        level = new Level1(this);

        //view
        view = new GameView(level, 1366, 768);
        view.setZoom(20);

        //The program will now detect mouse Clicks
        view.addMouseListener(new MouseHandler(level, view));
        //Listener allows the hollow knight model to be controlled.
        controller = new HollowKnightController(level.getHollowKnight());
        view.addKeyListener(controller);

        MouseHandler mh = new MouseHandler(level, view);
        view.addMouseListener(mh);
        view.addMouseListener(new Focus(view));

        level.addStepListener(new Tracker(view, level.getHollowKnight()));



        // Frame
        frame = new JFrame("Hollow Knight Start");
        frame.add(view);

        //Gives overview at the bottom of the screen.
        updateFrame();

        panel = new ControlPanel();
        frame.add(panel, BorderLayout.WEST);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);


        // debugger
        //JFrame debugView = new DebugViewer(world, 900, 506);
        // draw a 1-metre grid over the view
        //view.setGridResolution(1);

        System.out.println("||  Controls:                             ||");
        System.out.println("||  Use A and D to move left and right    ||");
        System.out.println("||  Use SpaceBar to jump                  ||");
        System.out.println("||  Use J to attack                       ||");
        System.out.println("||  ----------------------------------    ||");
        System.out.println("||  Attack the Mob to kill it             ||");
        System.out.println("||  If you touch the Mob you will die     ||");
        level.start();
    }

    public void updateFrame(){
        wideView = new UserView(level, 900, 100);
        wideView.setZoom(3);
        frame.remove(wideView);
        frame.add(wideView, BorderLayout.SOUTH);
        frame.pack();
    }

    public void goToNextLevel(){

        if (level instanceof Level1){
            //stop the current level
            level.stop();
            frame.remove(wideView);
            level.gameMusic.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level2(this);
            //change the view to look into new level
            view.setWorld(level);
            //change the controller to control the
            //student in the new world
            controller.updateHollowKnight(level.getHollowKnight());
            level.addStepListener(new Tracker(view, level.getHollowKnight()));

            updateFrame();

            //start the simulation in the new level
            level.start();
        }
        else if (level instanceof Level2){
            //stop the current level
            level.stop();
            frame.remove(wideView);
            level.gameMusic.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level3(this);
            //change the view to look into new level
            view.setWorld(level);
            //change the controller to control the
            //student in the new world
            controller.updateHollowKnight(level.getHollowKnight());
            level.addStepListener(new Tracker(view, level.getHollowKnight()));

            updateFrame();

            //start the simulation in the new level
            level.start();
        }
        else if (level instanceof Level3){
            //stop the current level
            level.stop();
            frame.remove(wideView);
            level.gameMusic.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level4(this);
            //change the view to look into new level
            view.setWorld(level);
            //change the controller to control the
            //student in the new world
            controller.updateHollowKnight(level.getHollowKnight());
            level.addStepListener(new Tracker(view, level.getHollowKnight()));

            updateFrame();

            //start the simulation in the new level
            level.start();
        }
        else if (level instanceof Level4){
            System.out.println("Well done! Game complete.");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}
