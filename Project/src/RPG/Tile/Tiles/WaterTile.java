package RPG.Tile.Tiles;

import RPG.Graphics.Assets;
import RPG.Tile.Tile;

public class WaterTile extends Tile {
    public WaterTile(int id) {
        super(Assets.water1, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
