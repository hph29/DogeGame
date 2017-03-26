package com.phantasmph.game;

import com.phantasmph.game.Controller.GameManger;
import com.phantasmph.game.Controller.Spawner;
import com.phantasmph.game.IO.KeyInput;
import com.phantasmph.game.Object.HUD;
import com.phantasmph.game.Object.Player;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Hangg on 2017/3/14.
 */
public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 12 * 9;

    private Thread thread;
    private boolean running = false;

    private Handler handler;

    public Game() {

        handler = Handler.getInstance();
        new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);
        this.addKeyListener(new KeyInput());
        handler.addObject(new Player());
        handler.addObject(Spawner.getInstance());
        handler.addObject(HUD.getInstance());
        handler.addObject(GameManger.getInstance());
    }

    public static void main(String[] args) {
        new Game();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }
}
