package RPG.Graphics;

import java.awt.image.BufferedImage;

public class AnimationManager {
    private int speed, index;
    private long lastTime, timer;
    private BufferedImage[] frames;

    public AnimationManager(int speed, BufferedImage[] frames) {
        this.speed = speed;
        this.frames = frames;
        index = 0;
        lastTime = System.currentTimeMillis();
    }

    public void update() {
        timer += System.currentTimeMillis() - lastTime; //time passed since the last execution of update().
        lastTime = System.currentTimeMillis();

        if(timer > speed) {
            index++;
            timer = 0;
            if(index >= frames.length) {
                index = 0;
            }
        }

    }

    public BufferedImage getCurrentFrame() {
        return frames[index];
    }
}
