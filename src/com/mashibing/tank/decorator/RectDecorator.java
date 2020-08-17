package com.mashibing.tank.decorator;

import com.mashibing.tank.GameObject;

import java.awt.*;

public class RectDecorator extends GODecorator {

    public RectDecorator(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public int getWidth() {
        return gameObject.getWidth();
    }

    @Override
    public int getHeight() {
        return gameObject.getHeight();
    }

    @Override
    public void paint(Graphics graphics) {
        this.x = gameObject.x;
        this.y = gameObject.y;
        // 无论如何先把原有对象画出来
        gameObject.paint(graphics);

        Color color = graphics.getColor();
        graphics.setColor(Color.blue);
        graphics.fillRect(gameObject.x, gameObject.y, gameObject.getWidth()*2, gameObject.getHeight()*2);
        graphics.setColor(color);
    }
}
