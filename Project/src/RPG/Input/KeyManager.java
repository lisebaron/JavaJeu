package RPG.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    private boolean[] keys;
    public boolean down, top, right, left;

    //Constructor
    public KeyManager() {
        keys = new boolean[256];
    }

    public void update() {
        top = keys[KeyEvent.VK_Z];
        down = keys[KeyEvent.VK_S];
        right = keys[KeyEvent.VK_D];
        left = keys[KeyEvent.VK_Q];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
//        System.out.println("A key is pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
