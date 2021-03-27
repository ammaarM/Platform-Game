package game;

import Collisions.*;
import GUI.GUIButton;
import GUI.VolumeSlider;
import Levels.*;
import Models.HollowKnight;
import Models.Mob;
import Models.Mob2;
import Models.Mob3;
import city.cs.engine.SoundClip;
import city.cs.engine.UserView;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Game {
    private static SoundClip gameMusic;
    public static GameLevel level;
    private static GameView view;
    private static HollowKnightController controller;
    private static JFrame frame;
    private static UserView wideView;


    public Game() {


        // Initialise level
        level = new Level1(this);
        level.populate(this);

        initLevel();

        // Frame
        frame = new JFrame("Hollow Knight Start");
        frame.add(view);

        //Gives overview at the bottom of the screen.
        updateFrame();


        frame.add(VolumeSlider.createSlider(), BorderLayout.WEST);
        frame.add(GUIButton.createButton(),BorderLayout.NORTH);

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
        this.wideView = new UserView(level, 900, 200);
        this.wideView.setZoom(3);
        frame.add(this.wideView, BorderLayout.SOUTH);
        frame.pack();
    }

    public void initLevel(){
        //view
        view = new GameView(level, 1366, 768);
        view.setZoom(20);

        //The program will now detect mouse Clicks
        view.addMouseListener(new MouseHandler(level, view));
        //Listener allows the hollow knight model to be controlled.
        controller = new HollowKnightController(level.getHollowKnight(), view);
        view.addKeyListener(controller);

        MouseHandler mh = new MouseHandler(level, view);
        view.addMouseListener(mh);
        view.addMouseListener(new Focus(view));
        view.requestFocus();

        level.addStepListener(new Tracker(view, level.getHollowKnight()));
    }


    public static void setLevel(int i){
        //stop the current level
        frame.remove(wideView);
        frame.remove(view);
        level.stop();
        level.gameMusic.stop();
        //create the new (appropriate) level
        //level now refers to new level
        if (i == 1) {
            level = new Level1(level.getGame());
            Mob m = new Mob(level);
            level.setMob(m);
            m.addCollisionListener(new MobCollision(m));
        } else if (i == 2){
            level = new Level2(level.getGame());
            Mob m = new Mob(level);
            level.setMob(m);
            m.addCollisionListener(new MobCollision(m));
        } else if (i == 3){
            level = new Level3(level.getGame());
            Mob2 m2 = new Mob2(level);
            level.setMob2(m2);
            m2.addCollisionListener(new Mob2Collision(m2));
        } else if (i == 4){
            level = new Level4(level.getGame());
            Mob3 m3 = new Mob3(level);
            level.setMob3(m3);
            m3.addCollisionListener(new Mob3Collision(m3));
        }

        HollowKnight h = new HollowKnight(level);
        level.setHollowKnight(h);
        Encounter encounter = new Encounter(level, level.getGame());
        h.addCollisionListener(encounter);
        h.addCollisionListener(new Collision(h));

        //change the view to look into new level
        //view
        view = new GameView(level, 1366, 768);
        view.setZoom(20);

        //The program will now detect mouse Clicks
        view.addMouseListener(new MouseHandler(level, view));
        //Listener allows the hollow knight model to be controlled.
        controller = new HollowKnightController(level.getHollowKnight(), view);
        view.addKeyListener(controller);

        MouseHandler mh = new MouseHandler(level, view);
        view.addMouseListener(mh);
        view.addMouseListener(new Focus(view));
        view.requestFocus();

        level.addStepListener(new Tracker(view, level.getHollowKnight()));

        frame.add(view);
        view.setWorld(level);
        //change the controller to control the
        controller.updateHollowKnight(level.getHollowKnight());
        level.addStepListener(new Tracker(view, level.getHollowKnight()));

        if (wideView != null)
            frame.remove(wideView);
        wideView = new UserView(level, 900, 200);
        wideView.setZoom(3);
        frame.add(wideView, BorderLayout.SOUTH);
        frame.pack();

        //start the simulation in the new level
        level.start();
    }
    public static void locateHollowKnight(float x ,float y){
        level.getHollowKnight().setPosition(new Vec2(x, y));
    }
    public static void locateMob(float x ,float y){
        level.getMob().setPosition(new Vec2(x, y));
    }
    public static void locateMob2(float x ,float y){
        level.getMob2().setPosition(new Vec2(x, y));
    }
    public static void locateMob3(float x ,float y){
        level.getMob3().setPosition(new Vec2(x, y));
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
            level = new Level2(level.getGame());
            level.populate(this);
            //change the view to look into new level
            initLevel();

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
            frame.remove(wideView);
            frame.remove(view);
            level.stop();
            level.gameMusic.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level3(level.getGame());
            level.populate(this);
            //change the view to look into new level
            initLevel();

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
        else if (level instanceof Level3){
            //stop the current level
            frame.remove(wideView);
            frame.remove(view);
            level.stop();
            level.gameMusic.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level4(level.getGame());
            level.populate(this);
            //change the view to look into new level
            initLevel();

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
