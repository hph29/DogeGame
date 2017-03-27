package com.phantasmph.game.Object;

import com.phantasmph.game.Game;
import com.phantasmph.game.Handler;
import com.phantasmph.game.Utility.ID;
import com.phantasmph.game.Utility.Vec2;

import java.awt.*;

/**
 * Created by hph on 2017-03-26.
 */
public class BossEnemy extends GameObject {

    int timer = 600;

    int timer2 = 18000;

    boolean isSet, isSet2 = false;

    public BossEnemy(Vec2 pos, Vec2 vel, Vec2 size, ID id, Color color) {
        super(pos, vel, size, id, color);
    }

    public void tick() {
        pos.x += vel.x;
        pos.y += vel.y;

        vel.x = (pos.x <= 0) ? Math.abs(vel.x) : (pos.x >= Game.WIDTH - size.x) ? Math.abs(vel.x) * -1 : vel.x;
        vel.y = (pos.y <= 0) ? Math.abs(vel.y) : (pos.y >= Game.WIDTH - size.y) ? Math.abs(vel.y) * -1 : vel.y;

        vel = new Vec2(vel.x, vel.y);
        pos = new Vec2(pos.x, pos.y);

    }

    public void render(Graphics g) {
        if (timer > 0 && !isSet) {
            timer--;
        } else if (timer <= 0 && !isSet) {
            vel = new Vec2(3, 0);
            isSet = true;
        }
        if (timer2 > 0 && !isSet2) {
            timer2--;

        } else if (timer2 <= 0 && !isSet2) {
            Handler.getInstance().removeObject(this);
            isSet2 = true;
        }

        g.setColor(color);
        g.fillRect((int) pos.x, (int) pos.y, (int) size.x, (int) size.y);
    }


}
