package com.phantasmph.game.Controller;

import com.phantasmph.game.Object.EnemyFactory;
import com.phantasmph.game.Object.GameObject;

import java.awt.*;

/**
 * Created by Hangg on 2017/3/19.
 */
public class Spawner extends GameObject {

    private static Spawner spawner;
    private int levelCounter = 0;

    private Spawner() {
    }

    public static Spawner getInstance() {
        if (spawner == null) {
            spawner = new Spawner();
        }
        return spawner;
    }

    public void tick() {
        if (levelCounter != GameManger.level) {
            if (GameManger.level < 5) {
                EnemyFactory.getInstance().addBasicEnemy();
            } else if (GameManger.level == 5) {
                EnemyFactory.getInstance().addSmartEnemy();
            }
            levelCounter = GameManger.level;
        }
    }

    public void render(Graphics g) {

    }
}
