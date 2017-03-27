package com.phantasmph.game.Object;

import com.phantasmph.game.Game;
import com.phantasmph.game.Handler;
import com.phantasmph.game.Utility.ID;
import com.phantasmph.game.Utility.Vec2;

import java.awt.*;

/**
 * Created by Hangg on 2017/3/15.
 */
public class SmartEnemy extends GameObject {

    public SmartEnemy(Vec2 pos, Vec2 vel, Vec2 size, Color color, ID id) {
        super(pos, vel, size, id, color);

        bounds = new Rectangle((int) pos.x, (int) pos.y, (int) size.x, (int) size.y);
    }

    public void tick() {
        float p_x = Handler.getInstance().getPlayer().pos.x;
        float p_y = Handler.getInstance().getPlayer().pos.y;

        float diff_x = p_x - pos.x;
        float diff_y = p_y - pos.y;


        double ratio = diff_x / diff_y;
        double unit_y = Math.sqrt(1 / (1 + ratio * ratio));
        double unit_x = Math.abs(ratio * unit_y);

        unit_x = (diff_x > 0) ? unit_x : unit_x * -1;
        unit_y = (diff_y > 0) ? unit_y : unit_y * -1;

        pos.x += vel.x * unit_x;
        pos.y += vel.y * unit_y;

        vel.x = (pos.x <= 0) ? Math.abs(vel.x) : (pos.x >= Game.WIDTH - size.x) ? Math.abs(vel.x) * -1 : vel.x;
        vel.y = (pos.y <= 0) ? Math.abs(vel.y) : (pos.y >= Game.WIDTH - size.y) ? Math.abs(vel.y) * -1 : vel.y;

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
