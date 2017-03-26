package com.phantasmph.game.Controller;

import com.phantasmph.game.Object.EnemyFactory;
import com.phantasmph.game.Object.GameObject;
import com.phantasmph.game.Utility.ID;

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

    public ID getId() {
        return null;
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

    public Rectangle getBounds() {
        return null;
    }
}
