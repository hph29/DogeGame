package com.phantasmph.game.Object;

import com.phantasmph.game.Handler;
import com.phantasmph.game.Utility.C;
import com.phantasmph.game.Utility.ID;
import com.phantasmph.game.Utility.Utility;

import java.awt.*;

/**
 * Created by Hangg on 2017/3/21.
 */
public class EnemyFactory {

    private static EnemyFactory instance = new EnemyFactory();

    public static EnemyFactory getInstance() {
        return instance;
    }

    public void addBasicEnemy() {
        Handler.getInstance().addObject(new BasicEnemy(Utility.getRandomPos(C.SMALL_SIZE), C.SLOW_VELOCITY, C.SMALL_SIZE, Color.RED, ID.BasicEnemy));
    }

    public void addSmartEnemy() {
        Handler.getInstance().addObject(new SmartEnemy(Utility.getRandomPos(C.SMALL_SIZE), C.VERY_SLOW_VELOCITY, C.SMALL_SIZE, Color.CYAN, ID.SmartEnemy));
    }

    public void addBossEnemy() {
        Handler.getInstance().addObject(new BossEnemy(C.MIDDLE_UP_POS, C.SLOW_VERTICAL_VELOCITY, C.BOSS_SIZE, ID.Boss1, Color.MAGENTA));
    }

}
