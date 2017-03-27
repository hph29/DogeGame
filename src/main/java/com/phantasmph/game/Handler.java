package com.phantasmph.game;

import com.phantasmph.game.Object.GameObject;
import com.phantasmph.game.Object.Player;
import com.phantasmph.game.Utility.ID;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Hangg on 2017/3/14.
 */
public class Handler {

    private static Handler handler;

    private LinkedList<GameObject> object;

    private Handler() {
        object = new LinkedList<GameObject>();
    }

    public static Handler getInstance() {
        if (handler == null) {
            handler = new Handler();
        }
        return handler;
    }

    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            if (tempObject.id != ID.HUD) tempObject.render(g);
        }
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            if (tempObject.id == ID.HUD) tempObject.render(g);
        }
    }

    public Player getPlayer() {
        for (int i = 0; i < object.size(); i++) {
            if (object.get(i).id == ID.Player) {
                return (Player) object.get(i);
            }
        }
        return null;
    }

    public LinkedList<GameObject> getObjects() {
        return this.object;
    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

}
