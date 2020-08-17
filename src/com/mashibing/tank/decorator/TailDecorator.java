package com.mashibing.tank.decorator;

import com.mashibing.tank.GameObject;

import java.awt.*;

public class TailDecorator extends GODecorator {
    @Override
    public void paint(Graphics graphics) {
        this.x = gameObject.x;
        this.y = gameObject.y;
        gameObject.paint(graphics);
        Color color = graphics.getColor();
        graphics.setColor(Color.red);
        graphics.drawLine(gameObject.x, gameObject.y, gameObject.x + 100, gameObject.y + 100);
        graphics.setColor(color);
    }

    @Override
    public int getWidth() {
        return gameObject.getWidth();
    }

    @Override
    public int getHeight() {
        return gameObject.getHeight();
    }

    public TailDecorator(GameObject gameObject) {
        super(gameObject);
    }
}
