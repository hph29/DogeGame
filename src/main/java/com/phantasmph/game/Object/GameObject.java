package com.phantasmph.game.Object;


import com.phantasmph.game.Utility.ID;

import java.awt.*;

/**
 * Created by Hangg on 2017/3/14.
 */
public abstract class GameObject {

    public abstract ID getId();

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();
}
