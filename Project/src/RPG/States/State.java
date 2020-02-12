package RPG.States;

import RPG.Game;
import RPG.Handler;

import java.awt.*;

public abstract class State {
    protected Game game;

    protected Handler handler;
    //Constructor
    public State(Handler handler) {
        this.handler = handler;
    }

    public abstract void update();
    public abstract void render(Graphics g);

    //region State Manager
    private static State currentState = null;

    public static State getState() {
        return currentState;
    }

    public static void setState(State currentState) {
        State.currentState = currentState;
    }
    //endregion
}
