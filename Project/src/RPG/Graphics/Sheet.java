package RPG.Graphics;

import java.awt.image.BufferedImage;

public class Sheet {
    private BufferedImage sheet;

    //Constructor
    public Sheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    public BufferedImage reframe(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y, width, height);
    }

}
