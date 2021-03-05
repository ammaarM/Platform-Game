package game;

import GUI.VolumeSlider;
import Levels.*;
import city.cs.engine.SoundClip;
import city.cs.engine.UserView;

import javax.swing.*;
import java.awt.*;

public class Game {
    private SoundClip gameMusic;
    public static GameLevel level;
    private GameView view;
    private HollowKnightController controller;
    private JFrame frame;
    private UserView wideView;
    private VolumeSlider slider;

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


        frame.add(VolumeSlider.createSlider(), BorderLayout.WEST);

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
        if (this.wideView != null)
            frame.remove(this.wideView);
        this.wideView = new UserView(level, 900, 100);
        this.wideView.setZoom(3);
        frame.add(this.wideView, BorderLayout.SOUTH);
        frame.pack();
    }

    public void goToNextLevel(){

        if (level instanceof Level1){
            //stop the current level
            frame.remove(wideView);
            frame.remove(view);
            level.stop();
            level.gameMusic.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level2(this);
            //change the view to look into new level
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
            frame.add(view);
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

    public static GameLevel getLevel(){
        return level;
    }
    public static void main(String[] args) {
        new Game();
    }
}
