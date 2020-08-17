package com.mashibing.tank;

import java.awt.*;

import static java.lang.System.out;


public class Bullet extends GameObject {
    public static final int WIDTH = ResouceManager.bulletD.getWidth();
    public static final int HEIGHT = ResouceManager.bulletD.getHeight();
    private static final int SPEED = PropertyManager.getInt("bulletSpeed");
    private int x;
    private int y;
    private Direction direction;
    private boolean living = true;

    private Group group = Group.BAD;


    public Rectangle rectangle = new Rectangle();

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Bullet(int x, int y, Direction direction, Group group) {
        super();
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.group = group;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;

        GameModel.getInstance().add(this);
    }

    public void paint(Graphics g) {
        if (!living) {
            GameModel.getInstance().remove(this);
        }
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
        rectangle.x = x;
        rectangle.y = y;
        delBulletOutOfFrame();

    }

    private void delBulletOutOfFrame() {
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }


    public void boom() {
        living = false;
    }
}
