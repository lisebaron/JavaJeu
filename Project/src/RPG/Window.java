package RPG;

import javax.swing.*;
import java.awt.*;

public class Window {
    //region variables
    private JFrame window;
    private Canvas canvas;
    private JPanel test;

    public String title;
    public int width, height;
    //endregion

    //Constructor
    public Window(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.test = test;
        CreateWindow();
    }

    //region Getters & Setters

    public JPanel getTest() {
        return test;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getWindow() {
        return window;
    }
    //endregion


    public void CreateWindow() {
        window = new JFrame(title);
        window.setSize(width, height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        window.add(canvas);
        window.pack();
    }
}
