package com.mashibing.tank;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.awt.*;
import java.util.Random;

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
    private static final int SPEED = 1;
    private boolean moving = true;

    // 持有对象的引用
    private TankFrame tankFrame = null;

    public static final int WIDTH = ResouceManager.tankD.getWidth();
    public static final int HEIGHT = ResouceManager.tankD.getHeight();
    private boolean living = true;

    private Random random = new Random();

    private Group group = Group.BAD;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Direction direction, Group group, TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.group = group;
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
        if (!living) tankFrame.badTanks.remove(this);
        Color color = g.getColor();
        switch (direction) {
            case LEFT:
                g.drawImage(ResouceManager.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResouceManager.tankR, x, y, null);
                break;
            case UP:
                g.drawImage(ResouceManager.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResouceManager.tankD, x, y, null);
                break;
            default:
                break;

        }
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
        if (group == Group.BAD && random.nextInt(10) > 8) this.fire();
    }

    public void fire() {
        int bx = x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int by = y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tankFrame.bullets.add(new Bullet(bx, by, direction, group, tankFrame));
    }

    public void boom() {
        living = false;
    }
}
