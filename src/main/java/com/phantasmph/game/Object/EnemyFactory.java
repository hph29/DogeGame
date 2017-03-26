package com.phantasmph.game.Object;

import com.phantasmph.game.Game;
import com.phantasmph.game.Handler;
import com.phantasmph.game.Utility.ID;
import com.phantasmph.game.Utility.Vec2;

import java.awt.*;
import java.util.Random;

/**
 * Created by Hangg on 2017/3/21.
 */
public class EnemyFactory {

    static Random random = new Random();
    private static EnemyFactory instance = new EnemyFactory();
    Vec2 smallSize = new Vec2(16, 16);
    Vec2 slowVelocity = new Vec2(3, 3);

    public static EnemyFactory getInstance() {
        return instance;
    }

    public void addBasicEnemy() {
        Handler.getInstance().addObject(new BasicEnemy(getRandomPos(smallSize), slowVelocity, smallSize, Color.red, ID.BasicEnemy));
    }

    public void addSmartEnemy() {
        Handler.getInstance().addObject(new SmartEnemy(getRandomPos(smallSize), slowVelocity, smallSize, Color.cyan, ID.SmartEnemy));
    }

    private Vec2 getRandomPos(Vec2 size) {
        return new Vec2(random.nextInt(Game.WIDTH - (int) size.x), random.nextInt(Game.HEIGHT - (int) size.y));
    }
}
