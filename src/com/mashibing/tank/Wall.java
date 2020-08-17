package com.mashibing.tank;

import java.awt.*;

public class Wall extends GameObject{
    private int x, y;
    private int width, height;
    public Rectangle rectangle;

    public Wall(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rectangle = new Rectangle(x, y, width, height);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void paint(Graphics graphics) {
        Color color = graphics.getColor();
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(x, y, width, height);
        graphics.setColor(color);
    }
}
