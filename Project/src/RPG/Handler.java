package RPG;

import RPG.Graphics.GameCamera;
import RPG.Input.KeyManager;
import RPG.Maps.Map;

public class Handler {

    private Game game;
    private Map map;

    public Handler(Game game) {
        this.game = game;
    }

    public GameCamera getGameCamera() {
        return game.getGameCamera();
    }

    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }

    public int getWidth() {
        return game.getWidth();
    }
    public int getHeight() {
        return game.getHeight();
    }

    //region Getters & Setters
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    //endregion
}
