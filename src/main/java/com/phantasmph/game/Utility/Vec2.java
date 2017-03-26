package com.phantasmph.game.Utility;

/**
 * Created by Hangg on 2017/3/20.
 */
public class Vec2 {
    public float x;
    public float y;

    public Vec2() {
        x = 0;
        y = 0;
    }

    public Vec2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vec2(int x, int y) {
        this.x = (float) x;
        this.y = (float) y;
    }

}
