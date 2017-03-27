package com.phantasmph.game.Object;


import com.phantasmph.game.Utility.ID;
import com.phantasmph.game.Utility.Vec2;

import java.awt.*;

/**
 * Created by Hangg on 2017/3/14.
 */
public abstract class GameObject {

    public Vec2 pos;
    public Vec2 vel;
    public Vec2 size;
    public ID id;
    public Color color;
    public Rectangle bounds;

    public GameObject() {

    }

    public GameObject(Vec2 pos, Vec2 vel, Vec2 size) {
        this.pos = pos;
        this.vel = vel;
        this.size = size;
    }

    public GameObject(Vec2 pos, Vec2 vel, Vec2 size, ID id) {
        this.pos = pos;
        this.vel = vel;
        this.size = size;
        this.id = id;
    }

    public GameObject(Vec2 pos, Vec2 vel, Vec2 size, ID id, Color color) {
        this.pos = pos;
        this.vel = vel;
        this.size = size;
        this.id = id;
        this.color = color;
    }

    public GameObject(Vec2 pos, Vec2 vel, Vec2 size, ID id, Color color, Rectangle bounds) {
        this.pos = pos;
        this.vel = vel;
        this.size = size;
        this.id = id;
        this.color = color;
        this.bounds = bounds;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

}
