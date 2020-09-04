package RPG.States;

import RPG.Entities.Enemy;
import RPG.Entities.Player;
import RPG.Game;
import RPG.Graphics.Assets;
import RPG.Handler;
import RPG.Maps.Map;
import RPG.Tile.Tile;

import java.awt.*;

public class GameState extends State{
    private Player player;
    private Enemy bat;
    private Map map;

    public GameState(Handler handler) {
        super(handler);
        map = new Map(handler,"res/Worlds/World.txt");
        handler.setMap(map);
        player = new Player(handler, 200, 200);
        bat = new Enemy(handler, 100, 100);
    }

    @Override
    public void update() {
        map.update();
        player.update();
        bat.update();
    }

    @Override
    public void render(Graphics g) {
        map.render(g);
        player.render(g);
        bat.render(g);
    }
}
