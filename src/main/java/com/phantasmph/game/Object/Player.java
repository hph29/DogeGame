package com.phantasmph.game.Object;

import com.phantasmph.game.Game;
import com.phantasmph.game.Handler;
import com.phantasmph.game.Utility.ID;
import com.phantasmph.game.Utility.Utility;
import com.phantasmph.game.Utility.Vec2;

import java.awt.*;

/**
 * Created by Hangg on 2017/3/15.
 */
public class Player extends GameObject {

    private Vec2 pos;
    private Vec2 vel;
    private Vec2 size;
    private ID id;
    private Color color;
    private Handler handler;

    public Player() {
        this.size = new Vec2(32, 32);
        this.pos = Utility.midPos(size);
        this.vel = new Vec2(0, 0);
        this.id = ID.Player;
        this.color = Color.white;
        this.handler = Handler.getInstance();
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
        for (int i = 0; i < handler.getObjects().size(); i++) {
            GameObject tempObject = handler.getObjects().get(i);
            if (tempObject.getId() == ID.BasicEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.HEALTH -= 2;
                }
            } else if (tempObject.getId() == ID.SmartEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.HEALTH -= 1;
                }
            }
        }
    }

    public void render(Graphics g) {

        g.setColor(color);
        g.fillRect((int) pos.x, (int) pos.y, (int) size.x, (int) size.y);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) pos.x, (int) pos.y, (int) size.x, (int) size.y);
    }

    public Vec2 getPos() {
        return pos;
    }

    public void setPos(Vec2 pos) {
        this.pos = pos;
    }

    public Vec2 getVel() {
        return vel;
    }

    public void setVel(Vec2 vel) {
        this.vel = vel;
    }

    public Vec2 getSize() {
        return size;
    }

    public void setSize(Vec2 size) {
        this.size = size;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
