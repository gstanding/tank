package com.mashibing.tank;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.awt.*;
import java.util.Random;

import static java.lang.System.out;

/**
 * tank's action
 */
public class Tank {
    public Rectangle rectangle = new Rectangle();
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
    private static final int SPEED = PropertyManager.getInt("tankSpeed");
    private boolean moving = true;

    // 持有对象的引用
    private TankFrame tankFrame = null;

    public static int WIDTH;
    public static int HEIGHT;
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
        if (this.group == Group.GOOD) {
            WIDTH = ResouceManager.goodTankU.getWidth();
            HEIGHT = ResouceManager.goodTankU.getHeight();
        }

        rectangle.x = this.x;
        rectangle.y  = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
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
                g.drawImage(group == Group.BAD ? ResouceManager.badTankL : ResouceManager.goodTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(group == Group.BAD ? ResouceManager.badTankR : ResouceManager.goodTankR, x, y, null);
                break;
            case UP:
                g.drawImage(group == Group.BAD ? ResouceManager.badTankU : ResouceManager.goodTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(group == Group.BAD ? ResouceManager.badTankD : ResouceManager.goodTankD, x, y, null);
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
        rectangle.x = x;
        rectangle.y = y;
        // 检测边界
        detectBorder();
        if (group == Group.BAD && random.nextInt(10) > 8) this.fire();
        if (group == Group.BAD && random.nextInt(100) > 95) randomDirectiuon();
    }

    private void detectBorder() {
        if (x < 0) x = 0;
        else if (y < 30) y = 30;
        else if (x > TankFrame.GAME_WIDTH - Tank.WIDTH) x = TankFrame.GAME_WIDTH - Tank.WIDTH;
        else if (y > TankFrame.GAME_HEIGHT - Tank.HEIGHT) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT;
    }

    private void randomDirectiuon() {
        direction = Direction.values()[random.nextInt(4)];
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
