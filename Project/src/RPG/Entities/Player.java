package RPG.Entities;

import RPG.Game;
import RPG.Graphics.AnimationManager;
import RPG.Graphics.Assets;
import RPG.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {
    //Animations
    private AnimationManager animDown, animLeft, animRight, animUp;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);

        //Collisions
        bounds.x = 8;
        bounds.y = 32;
        bounds.width = 32;
        bounds.height = 32;


        //Animations
        animDown = new AnimationManager(200, Assets.walk_down);
        animLeft = new AnimationManager(200, Assets.walk_left);
        animRight = new AnimationManager(200, Assets.walk_right);
        animUp = new AnimationManager(200, Assets.walk_up);
    }

    @Override
    public void update() {
        //Animations
        animDown.update();
        animLeft.update();
        animRight.update();
        animUp.update();

        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        g.setColor(Color.red);
        /*g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);*/
    }

    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {
            return animLeft.getCurrentFrame();
        }
        if (xMove > 0) {
            return animRight.getCurrentFrame();
        }
        if (yMove < 0) {
            return animUp.getCurrentFrame();
        }
        if (yMove > 0){
            return animDown.getCurrentFrame();
        }
        return Assets.idle;
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().top) {
            yMove = -speed;
        }

        if(handler.getKeyManager().down) {
            yMove = speed;
        }

        if(handler.getKeyManager().left) {
            xMove = -speed;
        }

        if(handler.getKeyManager().right) {
            xMove = speed;
        }
    }
}
