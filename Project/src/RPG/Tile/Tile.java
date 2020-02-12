package RPG.Tile;

import RPG.Tile.Tiles.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    //region variables
    public static Tile[] tiles = new Tile[256];
    public static Tile grassSolidTile = new GrassSolidTile(0),
            waterTile = new WaterTile(2),
            waterTile2 = new WaterTile(3),
            seedTile = new SeedTile(4),
            seedTile2 = new Seed2Tile(5),
            grassTile0 = new GrassTopLeftCornerTile(21),
            grassTile1 = new GrassBorderTopTile(22),
            grassTile2 = new GrassTopRightCornerTile(23),
            grassTile3 = new GrassBorderLeftTile(41),
            grassTile = new GrassTile(42),
            grassTile4 = new GrassBorderRightTile(43),
            grassTile5 = new GrassCornerDownLeftTile(61),
            grassTile6 = new GrassBorderDownTile(62),
            grassTile8 = new GrassCornerDownRightTile(63),
            flower = new FlowerTile(85);

    public static final int TILEWIDTH = 48, TILEHEIGHT = 48;
    protected BufferedImage texture;

    //Id is unique for each tile
    protected final int id;
    //endregion

    //Constructor
    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void update() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    public boolean isSolid() {
        return false;
    }

    public int getId() {
        return id;
    }
}
