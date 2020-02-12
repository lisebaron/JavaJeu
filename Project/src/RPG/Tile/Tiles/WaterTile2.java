package RPG.Tile.Tiles;

import RPG.Graphics.Assets;
import RPG.Tile.Tile;

public class WaterTile2 extends Tile {
    public WaterTile2(int id) {
        super(Assets.water2, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
