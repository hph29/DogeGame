package com.phantasmph.game.Object;

import com.phantasmph.game.Game;
import com.phantasmph.game.Handler;
import com.phantasmph.game.Utility.C;
import com.phantasmph.game.Utility.ID;
import com.phantasmph.game.Utility.Utility;
import com.phantasmph.game.Utility.Vec2;

import java.awt.*;

/**
 * Created by Hangg on 2017/3/15.
 */
public class Player extends GameObject {

    public Player() {

        super(C.MIDDLE_POS, C.ZERO_VELOCITY, C.MIDDLE_SIZE, ID.Player, Color.WHITE);

    }

    public void tick() {
        float tempX = pos.x + vel.x;
        float tempY = pos.y + vel.y;

        pos.x = Utility.cap(tempX, 0, Game.WIDTH - (int) size.x);
        pos.y = Utility.cap(tempY, 0, Game.HEIGHT - (int) size.y);

        collision();

        Handler.getInstance().addObject(new Trail(new Vec2(pos.x, pos.y), new Vec2(32, 32), 0.1f, color));
    }

    public void collision() {
        this.bounds = new Rectangle((int) pos.x, (int) pos.y, (int) size.x, (int) size.y);

        for (int i = 0; i < Handler.getInstance().getObjects().size(); i++) {
            GameObject tempObject = Handler.getInstance().getObjects().get(i);
            if (tempObject.id == ID.BasicEnemy) {
                if (bounds.intersects(tempObject.bounds)) {
                    HUD.HEALTH -= 2;
                    //Handler.getInstance().removeObject(tempObject);
                }
            } else if (tempObject.id == ID.SmartEnemy) {
                if (bounds.intersects(tempObject.bounds)) {
                    HUD.HEALTH -= 1;
                    //Handler.getInstance().removeObject(tempObject);
                }
            }
        }
    }

    public void render(Graphics g) {

        g.setColor(color);
        g.fillRect((int) pos.x, (int) pos.y, (int) size.x, (int) size.y);
    }

}
