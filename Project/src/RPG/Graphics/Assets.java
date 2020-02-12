package RPG.Graphics;

import javax.imageio.ImageIO;
import javax.imageio.plugins.tiff.BaselineTIFFTagSet;
import java.awt.image.BandCombineOp;
import java.awt.image.BufferedImage;
import java.sql.BatchUpdateException;

public class Assets {
    private static final int width = 16, height = 16;
    private static final int batwidth = 121, batheight = 89;
    private static final int Playerwidth = 128, Playerheight = 128;
    public static BufferedImage grass, grassSolid , grassBorder1, grassBorder2, grassBorder3, grassBorder4, grassBorder6, grassBorder7, grassBorder8, grassBorder9;
    public static BufferedImage water1, water2, seed1, seed2, flower;
    public static BufferedImage idle, batidle;
    public static BufferedImage[] walk_down, walk_left, walk_right, walk_up;
    public static BufferedImage[] fly, attack, hit;


    public static void init() {
        Sheet Tileset = new Sheet(ImageLoader.loadImage("res/textures/Tileset.png"));
        Sheet Playersheet = new Sheet(ImageLoader.loadImage("res/textures/player.png"));
        Sheet Batsheet = new Sheet(ImageLoader.loadImage("res/textures/BatSheet.png"));


        //region bat
        fly = new BufferedImage[5];
        fly[0] = Batsheet.reframe(0, 0, batwidth, batheight);
        fly[1] = Batsheet.reframe(batwidth, 0, batwidth, batheight);
        fly[2] = Batsheet.reframe(batwidth * 2, 0, batwidth, batheight);
        fly[3] = Batsheet.reframe(batwidth * 3, 0, batwidth, batheight);
        fly[4] = Batsheet.reframe(batwidth * 4, 0, batwidth, batheight);

        attack = new BufferedImage[7];
        attack[0] = Batsheet.reframe(batwidth * 2, 0, batwidth, batheight);
        attack[1] = Batsheet.reframe(batwidth * 2, batheight, batwidth, batheight);
        attack[2] = Batsheet.reframe(batwidth * 2, batheight * 2, batwidth, batheight);
        attack[3] = Batsheet.reframe(batwidth * 2, batheight * 3, batwidth, batheight);
        attack[4] = Batsheet.reframe(batwidth * 2, batheight * 3, batwidth, batheight);
        attack[5] = Batsheet.reframe(batwidth * 3, 0, batwidth, batheight);
        attack[6] = Batsheet.reframe(batwidth * 3, batheight, batwidth, batheight);

        hit = new BufferedImage[6];
        hit[0] = Batsheet.reframe(0, batheight, batwidth, batheight);
        hit[1] = Batsheet.reframe(batwidth * 2, batheight * 3, batwidth, batheight);
        hit[2] = Batsheet.reframe(batwidth * 3, batheight * 3, batwidth, batheight);
        hit[3] = Batsheet.reframe(batwidth, batheight, batwidth, batheight);
        hit[4] = fly[3];
        hit[5] = fly[4];
        //endregion


        //region Player
        idle = Playersheet.reframe(Playerwidth, 0, Playerwidth, Playerheight);

        walk_down = new BufferedImage[4];
        walk_down[0] = Playersheet.reframe(0, 0, Playerwidth, Playerheight);
        walk_down[1] = Playersheet.reframe(Playerwidth, 0, Playerwidth, Playerheight);
        walk_down[2] = Playersheet.reframe(Playerwidth * 2, 0, Playerwidth, Playerheight);
        walk_down[3] = walk_down[1];

        walk_left = new BufferedImage[4];
        walk_left[0] = Playersheet.reframe(0, Playerheight, Playerwidth, Playerheight);
        walk_left[1] = Playersheet.reframe(Playerwidth, Playerheight, Playerwidth, Playerheight);
        walk_left[2] = Playersheet.reframe(Playerwidth * 2, Playerheight, Playerwidth, Playerheight);
        walk_left[3] = walk_left[1];

        walk_right = new BufferedImage[4];
        walk_right[0] = Playersheet.reframe(0, Playerheight * 2, Playerwidth, Playerheight);
        walk_right[1] = Playersheet.reframe(Playerwidth, Playerheight * 2, Playerwidth, Playerheight);
        walk_right[2] = Playersheet.reframe(Playerwidth * 2, Playerheight * 2, Playerwidth, Playerheight);
        walk_right[3] = walk_right[1];

        walk_up = new BufferedImage[4];
        walk_up[0] = Playersheet.reframe(0, Playerheight * 3, Playerwidth, Playerheight);
        walk_up[1] = Playersheet.reframe(Playerwidth, Playerheight * 3, Playerwidth, Playerheight);
        walk_up[2] = Playersheet.reframe(Playerwidth * 2, Playerheight * 3, Playerwidth, Playerheight);
        walk_up[3] = walk_up[1];
        //endregion


        //region Tileset
        grassSolid = Tileset.reframe(0, 0, width, height);
        grassBorder1 = Tileset.reframe(0, height, width, height);
        grassBorder2 = Tileset.reframe(width, height, width, height);
        grassBorder3 = Tileset.reframe(width * 2, height, width, height);
        grassBorder4 = Tileset.reframe(0, height * 2, width, height);
        grass = Tileset.reframe(width, height * 2, width, height);
        grassBorder6 = Tileset.reframe(width * 2, height * 2, width, height);
        grassBorder7 = Tileset.reframe(0, height * 3, width, height);
        grassBorder8 = Tileset.reframe(width, height * 3, width, height);
        grassBorder9 = Tileset.reframe(width * 2, height * 3, width, height);

        seed1 = Tileset.reframe(width * 3, 0, width, height);
        seed2 = Tileset.reframe(width * 4, 0, width, height);
        flower = Tileset.reframe(width * 4, height * 4, width, height);

        water1 = Tileset.reframe(width, 0, width, height);
        water2 = Tileset.reframe(width * 2, 0, width, height);
        //endregion

    }
}