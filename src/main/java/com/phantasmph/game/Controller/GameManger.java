package com.phantasmph.game.Controller;

import com.phantasmph.game.Object.GameObject;

import java.awt.*;

/**
 * Created by Hangg on 2017/3/19.
 */
public class GameManger extends GameObject {
    static public int score = 0;
    static public int level = 1;
    static public int health = 100;

    private static GameManger instance;

    private GameManger() {
        super();
    }

    public static GameManger getInstance() {
        if (instance == null) {
            instance = new GameManger();
        }
        return instance;
    }

    public void tick() {
        score++;
        level = (score / 100) + 1;
    }

    public void render(Graphics g) {

    }

}
