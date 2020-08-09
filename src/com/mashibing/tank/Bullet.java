package com.mashibing.tank;

import java.awt.*;

import static java.lang.System.out;


public class Bullet {
    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;
    private static final int SPEED = 1;
    private int x;
    private int y;
    private Direction direction;
    private boolean live = true;

    private TankFrame tankFrame;

    public Bullet(int x, int y, Direction direction, TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        if (!live) {
            tankFrame.bullets.remove(this);
        }
        Color color = g.getColor();
//        g.setColor(Color.red);
//        g.fillOval(x, y, WIDTH, HEIGHT);
//        g.setColor(color);
        switch (direction) {
            case LEFT:
                g.drawImage(ResouceManager.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResouceManager.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(ResouceManager.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResouceManager.bulletD, x, y, null);
                break;
            default:
                break;

        }

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
        delBulletOutOfFrame();
    }

    private void delBulletOutOfFrame() {
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) live = false;
    }
}
