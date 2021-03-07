package game;

import Collisions.SlashCollision;
import Collisions.SlashInvCollision;
import Models.HollowKnight;
import Models.Slash;
import Models.SlashInv;
import city.cs.engine.BodyImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import org.jbox2d.common.Vec2;

public class HollowKnightController implements KeyListener {

    private static final float WALKING_SPEED = 4;

    private HollowKnight hollowKnight;
    private GameView view;
    private static int health = 10;

    public HollowKnightController(HollowKnight h, GameView v){
        hollowKnight = h;
        this.view = v;
    }
    public static int getHealth(){ return health;}
    public static void setHealth(){
        health--;
        System.out.println("HP: " + health);
        if(health == 0){
            System.out.println("Your dead");
            System.exit(0);
        }
    }
    //These are all the new images that the model takes when moving.
    private static final BodyImage stillRight = new BodyImage("data/stillRight.png", 5f);
    private static final BodyImage stillLeft = new BodyImage("data/stillLeft.png", 5f);
    private static final BodyImage leftImage = new BodyImage("data/left.gif", 5f);
    private static final BodyImage rightImage = new BodyImage("data/right.gif", 5f);
    private static final BodyImage jumpImage = new BodyImage("data/jump.gif", 5f);
    private static final BodyImage jumpInvImage = new BodyImage("data/jumpInverse.gif", 5f);
    private static final BodyImage attackImage = new BodyImage("data/attack.gif", 5f);
    private static final BodyImage attackInvImage = new BodyImage("data/attackInv.gif", 5f);
    private int pCode = 1;


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        view.requestFocus();
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_A) {
            //Tells the model to walk left
            hollowKnight.startWalking(-WALKING_SPEED*2);
            hollowKnight.removeAllImages();
            hollowKnight.addImage(leftImage);
            pCode=0;
        } else if (code == KeyEvent.VK_D) {
            //Tells the model to walk right
            hollowKnight.startWalking(WALKING_SPEED*2);
            hollowKnight.removeAllImages();
            hollowKnight.addImage(rightImage);
            pCode=1;
        } else if (code == KeyEvent.VK_SPACE){
            //Tells the model to walk jump
            if(pCode==0){
                //Does a different animation for each direction that is being jumped
                hollowKnight.setGravityScale(0.5f);
                hollowKnight.jump(12);
                hollowKnight.removeAllImages();
                hollowKnight.addImage(jumpInvImage);
            }else if(pCode==1) {
                hollowKnight.setGravityScale(0.5f);
                hollowKnight.jump(12);
                hollowKnight.removeAllImages();
                hollowKnight.addImage(jumpImage);
            }
        } else if (code == KeyEvent.VK_J){
            if(pCode==0){
                //Tells the model to attack and changes the direction of the attack depending on what they are saying
                hollowKnight.removeAllImages();
                hollowKnight.addImage(attackInvImage);
                Vec2 selfPoint = hollowKnight.getPosition().add(new Vec2(-1, 0));
                SlashInv slashInv = new SlashInv(hollowKnight.getWorld());
                SlashInvCollision slashInvCollision = new SlashInvCollision(slashInv);
                slashInv.addCollisionListener(slashInvCollision);
                slashInv.setPosition(selfPoint);
                slashInv.setLinearVelocity(new Vec2(-50,0));
            }else if(pCode==1) {
                hollowKnight.removeAllImages();
                hollowKnight.addImage(attackImage);
                Vec2 selfPointInv = hollowKnight.getPosition().add(new Vec2(1, 0));
                Slash slash = new Slash(hollowKnight.getWorld());
                SlashCollision slashCollision = new SlashCollision(slash);
                slash.addCollisionListener(slashCollision);
                slash.setPosition(selfPointInv);
                slash.setLinearVelocity(new Vec2(50,0));
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //All the code here is used to reset the model back to normal depending on which direction its facing.
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            hollowKnight.stopWalking();
            hollowKnight.removeAllImages();
            hollowKnight.addImage(stillLeft);
        } else if (code == KeyEvent.VK_D) {
            hollowKnight.stopWalking();
            hollowKnight.removeAllImages();
            hollowKnight.addImage(stillRight);
        } else if (code == KeyEvent.VK_SPACE){
            if(pCode==0){
                hollowKnight.setGravityScale(10);
                hollowKnight.removeAllImages();
                hollowKnight.addImage(stillLeft);
            }else if(pCode==1) {
                hollowKnight.setGravityScale(10);
                hollowKnight.removeAllImages();
                hollowKnight.addImage(stillRight);
            }
        } else if (code == KeyEvent.VK_J) {
            if (pCode == 0) {
                hollowKnight.removeAllImages();
                hollowKnight.addImage(stillLeft);
            } else if (pCode == 1) {
                hollowKnight.removeAllImages();
                hollowKnight.addImage(stillRight);
            }
        }
    }

    public void updateHollowKnight(HollowKnight hollowKnight) { this.hollowKnight = hollowKnight;}
}
