package com.phantasmph.game.IO;

import com.phantasmph.game.Handler;
import com.phantasmph.game.Object.GameObject;
import com.phantasmph.game.Object.Player;
import com.phantasmph.game.Utility.ID;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Hangg on 2017/3/15.
 */
public class KeyInput extends KeyAdapter {

    private Handler handler = Handler.getInstance();
    private boolean[] keyDown;

    public KeyInput() {
        this.keyDown = new boolean[]{false, false, false, false};
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.getObjects().size(); i++) {
            GameObject tempObject = handler.getObjects().get(i);
            if (tempObject.id == ID.Player) {
                Player player = (Player) tempObject;
                if (key == KeyEvent.VK_W) {
                    player.vel.y = -5;
                    keyDown[0] = true;
                }
                if (key == KeyEvent.VK_S) {
                    player.vel.y = 5;
                    keyDown[1] = true;
                }
                if (key == KeyEvent.VK_A) {
                    player.vel.x = -5;
                    keyDown[2] = true;
                }
                if (key == KeyEvent.VK_D) {
                    player.vel.x = 5;
                    keyDown[3] = true;
                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.getObjects().size(); i++) {
            GameObject tempObject = handler.getObjects().get(i);
            if (tempObject.id == ID.Player) {
                Player player = (Player) tempObject;
                if (key == KeyEvent.VK_W) keyDown[0] = false;
                if (key == KeyEvent.VK_S) keyDown[1] = false;
                if (key == KeyEvent.VK_A) keyDown[2] = false;
                if (key == KeyEvent.VK_D) keyDown[3] = false;
                if (!keyDown[0] && !keyDown[1]) {
                    player.vel.y = 0;
                }
                if (!keyDown[2] && !keyDown[3]) {
                    player.vel.x = 0;
                }

            }
        }
    }
}
