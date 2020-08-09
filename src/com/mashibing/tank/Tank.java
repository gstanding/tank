package com.mashibing.tank;

import java.awt.*;

import static java.lang.System.out;

/**
 * tank's action
 */
public class Tank {
    /**
     * position x,y of tank
     */
    private int x, y;
    /**
     * direction of tank
     */
    private Direction direction;
    /**
     * speed of tank
     */
    private static final int SPEED = 5;
    private boolean moving = false;

    // 持有对象的引用
    private TankFrame tankFrame = null;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Direction direction, TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tankFrame = tankFrame;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.yellow);
        g.fillRect(x, y, 50, 50);
        g.setColor(color);
        move();
    }

    private void move() {
        if (!moving) return;
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

    public void fire() {
        tankFrame.bullets.add(new Bullet(x, y, direction, tankFrame));
    }
}
