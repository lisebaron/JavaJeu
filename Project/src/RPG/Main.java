package RPG;

import javax.swing.*;

public class Main extends JFrame{

    public static void main(String[] args) {
        Game game = new Game("RPG", 800, 650);
        game.start();
    }
}
