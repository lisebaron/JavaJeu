package RPG.Entities;

import RPG.Graphics.AnimationManager;
import RPG.Graphics.Assets;
import RPG.Handler;

import java.awt.*;

public class Enemy extends Creature {
    //Animations
    private AnimationManager animFly, animAttack, animHit;

    public Enemy(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //Animations
        animFly = new AnimationManager(150, Assets.fly);
        animAttack = new AnimationManager(150, Assets.attack);
        animHit = new AnimationManager(150, Assets.hit);
    }

    @Override
    public void update() {
        animFly.update();
        animAttack.update();
        animHit.update();

    }

    @Override
    public void render(Graphics g) {
//        g.clearRect(0, 0, width, height);
            g.drawImage(animFly.getCurrentFrame(), (int) x, (int) y, null);
    }
}
