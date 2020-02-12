package RPG.Tile.Tiles;

import RPG.Graphics.Assets;
import RPG.Tile.Tile;

public class GrassSolidTile extends Tile {
    public GrassSolidTile(int id) {
        super(Assets.grassSolid, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
