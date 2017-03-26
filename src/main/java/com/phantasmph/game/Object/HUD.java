package com.phantasmph.game.Object;

import com.phantasmph.game.Controller.GameManger;
import com.phantasmph.game.Utility.ID;
import com.phantasmph.game.Utility.Utility;

import java.awt.*;

/**
 * Created by Hangg on 2017/3/15.
 */
public class HUD extends GameObject {


    static int HEALTH = 100;

    private static HUD hud;
    private int color_green = 255;
    private int color_red = 128;
    private int color_blue = 0;

    public static HUD getInstance() {
        if (hud == null) {
            hud = new HUD();
        }
        return hud;
    }

    public ID getId() {
        return ID.HUD;
    }

    public void tick() {
        color_green = HEALTH * 255 / 100;
        color_green = Utility.cap(color_green, 0, 255);
    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(20, 20, 200, 32);
        g.setColor(new Color(color_red, color_green, color_blue));
        g.fillRect(20, 20, Utility.cap(HEALTH, 0, 100) * 2, 32);
        g.setColor(Color.white);
        g.drawRect(20, 20, 200, 32);

        g.drawString("Score: " + GameManger.score, 20, 70);
        g.drawString("Level: " + GameManger.level, 20, 85);
    }

    public Rectangle getBounds() {
        return null;
    }

}
