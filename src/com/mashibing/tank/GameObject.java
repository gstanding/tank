package com.mashibing.tank;

import java.awt.*;
import java.io.Serializable;

public abstract class GameObject implements Serializable {
    public int x;
    public int y;

    public abstract void paint(Graphics graphics);
    public abstract int getWidth();
    public abstract int getHeight();
}
