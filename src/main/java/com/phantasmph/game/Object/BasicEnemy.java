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
    private Vec2 pos;
    private Vec2 vel;
    private Vec2 size;
    private Color color;
    private ID id;

    public BasicEnemy(Vec2 pos, Vec2 vel, Vec2 size, Color color, ID id) {
        this.pos = pos;
        this.vel = vel;
        this.size = size;
        this.color = color;
        this.id = id;
    }

    public void tick() {
        pos.x += vel.x;
        pos.y += vel.y;

        if (pos.x <= 0 || pos.x >= Game.WIDTH - size.x) vel.x *= -1;
        if (pos.y <= 0 || pos.y >= Game.HEIGHT - size.y) vel.y *= -1;

        vel = new Vec2(vel.x, vel.y);

        Handler.getInstance().addObject(new Trail(new Vec2(pos.x, pos.y), size, 0.02f, color));
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
        if (pos.x < 0 || pos.x > (Game.WIDTH - size.x)) {
            vel.x *= -1;
        }
        if (pos.y < 0 || pos.y > (Game.HEIGHT - size.y)) {
            vel.y *= -1;
        }
    }

    public Vec2 getSize() {
        return size;
    }

    public void setSize(Vec2 size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
