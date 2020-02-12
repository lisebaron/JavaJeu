package RPG.Entities;

import RPG.Game;
import RPG.Handler;
import RPG.Tile.Tile;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    protected int health;

    public static final float DEFAULT_SPEED = 3.0f;
    protected float speed;

    public static final int DEFAULT_WIDTH = 48,
                            DEFAULT_HEIGHT = 48;

    protected float xMove, yMove;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move() {
        moveX();
        moveY();
    }

    public void moveX() {
        if (xMove > 0) { //Moving right
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
            if(!TileCollision(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&        //Check the upper right corner
            !TileCollision(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {       //Check the lower right corner
                x += xMove;
            }

        } else if(xMove < 0) { //Moving left
            int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
            if(!TileCollision(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                    !TileCollision(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                x += xMove;
            }
        }
    }
    public void moveY() {
        if (yMove < 0) { //Moving up
            int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
            if(!TileCollision((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                    !TileCollision((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                y += yMove;
            }

        } else if(yMove > 0) { //Moving down
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
            if(!TileCollision((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                    !TileCollision((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                y += yMove;
            }
        }
    }

    protected boolean TileCollision(int x, int y) {
        return handler.getMap().getTile(x, y).isSolid();
    }


        //region Getters & Setters
    public int getHp() {
        return health;
    }

    public void setHp(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    //endregion
}
