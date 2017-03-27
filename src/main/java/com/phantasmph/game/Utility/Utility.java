package com.phantasmph.game.Utility;

import com.phantasmph.game.Game;

import java.util.Random;

/**
 * Created by Hangg on 2017/3/18.
 */
public class Utility {

    private static Random random = new Random();

    public static float cap(float x, float min, float max) {
        return (x >= max) ? max : ((x <= min) ? min : x);
    }

    public static int cap(int x, int min, int max) {
        return (x >= max) ? max : ((x <= min) ? min : x);
    }


    public static Vec2 midPos(Vec2 size) {
        return new Vec2(Game.WIDTH / 2 - size.x, Game.HEIGHT / 2 - size.y);
    }

    public static Vec2 getRandomPos(Vec2 size) {
        return new Vec2(random.nextInt(Game.WIDTH - (int) size.x), random.nextInt(Game.HEIGHT - (int) size.y));
    }
}
