package com.phantasmph.game.Object;

import com.phantasmph.game.Game;
import com.phantasmph.game.Handler;
import com.phantasmph.game.Utility.ID;
import com.phantasmph.game.Utility.Vec2;

import java.awt.*;

/**
 * Created by Hangg on 2017/3/15.
 */
public class BasicEnemy extends GameObject {

    BasicEnemy(Vec2 pos, Vec2 vel, Vec2 size, Color color, ID id) {
        super(pos, vel, size, id, color);
        this.bounds = new Rectangle((int) pos.x, (int) pos.y, (int) size.x, (int) size.y);
    }

    public void tick() {
        pos.x += vel.x;
        pos.y += vel.y;

        if (pos.x <= 0 || pos.x >= Game.WIDTH - size.x) vel.x *= -1;
        if (pos.y <= 0 || pos.y >= Game.HEIGHT - size.y) vel.y *= -1;

        vel = new Vec2(vel.x, vel.y);
        pos = new Vec2(pos.x, pos.y);

        this.bounds = new Rectangle((int) pos.x, (int) pos.y, (int) size.x, (int) size.y);

        Handler.getInstance().addObject(new Trail(new Vec2(pos.x, pos.y), size, 0.02f, color));
    }

    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect((int) pos.x, (int) pos.y, (int) size.x, (int) size.y);
    }
}
