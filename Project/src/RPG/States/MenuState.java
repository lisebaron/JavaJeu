package RPG.States;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import RPG.Graphics.ImageLoader;
import RPG.Handler;
import RPG.Window;

public class MenuState extends State {
    private Window window;
    private JPanel panel;
    private BufferedImage bg;
    //starting menu buttons
    private JButton solo, multiplayer, exit;

    public MenuState(Handler handler, Window window) {
        super(handler);
        this.window = window;
        bg = ImageLoader.loadImage("res/textures/MenuBG.png");

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(bg, 0, 0, null);
        solo = new JButton("solo");
        multiplayer = new JButton("Multiplayer");
        exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
