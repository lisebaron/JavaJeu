package RPG;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.security.Key;

import RPG.Graphics.GameCamera;
import RPG.Input.KeyManager;
import RPG.States.GameState;
import RPG.States.MenuState;
import RPG.States.State;
import RPG.Graphics.Assets;

import javax.swing.*;


public class Game implements Runnable{

    //region variables
    private Window window;
    private JPanel test;
    public String title;
    private int width, height;

    private Thread thread;
    private boolean isRunning = false;

    private BufferStrategy bs;
    private Graphics g;

    //States
    public State gameState;
    public State menuState;

    private KeyManager keyManager;

    private GameCamera gameCamera;

    private Handler handler;
    //endregion

    //Constructor
    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();
    }

    //region Getters & Setters
    public KeyManager getKeyManager() {
        return keyManager;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }
    //endregion

    //Initialisation
    private void init() {
        window = new Window(title, width, height);
        handler = new Handler(this);

        window.getWindow().addKeyListener(keyManager);
        Assets.init();

        gameState = new GameState(handler);
        menuState = new MenuState(handler, window);
        State.setState(gameState);


        gameCamera = new GameCamera(this,0 , 0);
    }


    //Updates the game
    private void update() {
        keyManager.update();

        if (State.getState() != null) {
            State.getState().update();
        }
    }
    //Display/draw the game
    private void render() {
        bs = window.getCanvas().getBufferStrategy();
        if(bs == null) {
            window.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);

        //If State already exist
        if (State.getState() != null); {
            State.getState().render(g);
        }

        bs.show(); //end drawing, can be displayed
        g.dispose();
    }


    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime(); //current time in nanosec.
        long timer = 0;
        int ticks = 0;

        while(isRunning) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick; //Tell when to call the two methods update and render.
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                update();
                render();
                ticks++;
                delta--;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }


    public synchronized void start() {
        if (isRunning) {return;}
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!isRunning) {return;}
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
