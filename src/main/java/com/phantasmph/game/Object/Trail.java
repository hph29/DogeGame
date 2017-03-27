package com.phantasmph.game.Object;

import com.phantasmph.game.Handler;
import com.phantasmph.game.Utility.C;
import com.phantasmph.game.Utility.ID;
import com.phantasmph.game.Utility.Vec2;

import java.awt.*;

/**
 * Created by Hangg on 2017/3/18.
 */
public class Trail extends GameObject {

    private float life;
    private float alpha = 1;

    public Trail(Vec2 pos, Vec2 size, float life, Color color) {
        super(pos, C.ZERO_VELOCITY, size, ID.Trail, color);
        this.life = life;
    }

    public ID getId() {
        return ID.Trail;
    }

    public void tick() {
        if (alpha > life) {
            alpha -= (life);
        } else {
            Handler.getInstance().removeObject(this);
        }
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(getTransparent(alpha));

        g2d.setColor(color);
        g2d.fillRect((int) this.pos.x, (int) this.pos.y, (int) size.x, (int) size.y);

        g2d.setComposite(getTransparent(1));
    }

    private AlphaComposite getTransparent(float alpha) {
        int rule = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(rule, alpha);
    }

}
