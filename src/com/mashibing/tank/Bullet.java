package com.mashibing.tank;

import java.awt.*;

import static java.lang.System.out;


public class Bullet {
    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;
    private static int SPEED = 10;
    private int x, y;
    private Direction direction;

    public Bullet(int x, int y, Direction direction) {
        super();
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(color);

        move();
    }

    private void move() {
        switch (direction) {
            case LEFT:
                x -= SPEED;
                out.println("LEFT: " + SPEED);
                break;
            case RIGHT:
                out.println("RIGHT: " + SPEED);
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                out.println("UP: " + SPEED);
                break;
            case DOWN:
                y += SPEED;
                out.println("DOWN: " + SPEED);
                break;
            default:
                break;
        }
    }
}
