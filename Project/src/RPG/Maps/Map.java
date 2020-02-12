package RPG.Maps;

import RPG.Game;
import RPG.Handler;
import RPG.Tile.Tile;
import RPG.Utils.Utils;

import java.awt.*;

public class Map {

    private Handler handler;
    private int Xspawn, Yspawn;
    private int width, height;
    private int[][] tiles;

    public Map(Handler handler, String path) {
        this.handler = handler;
        loadWorld(path);
    }

    public void update() {

    }

    public void render(Graphics g) {

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
                        (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
            }
        }
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.grassTile;
        }

        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) {
            return Tile.waterTile;
        }
        return t;
    }

    private  void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        Xspawn = Utils.parseInt(tokens[2]);
        Yspawn = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for (int y = 0; y < height ; y++) {
            for (int x = 0; x < width ; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }

    }
}
