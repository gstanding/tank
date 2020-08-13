package com.mashibing.tank;

import com.mashibing.tank.abstractfactory.AbstractBullet;
import com.mashibing.tank.abstractfactory.AbstractTank;
import com.sun.org.apache.regexp.internal.RECompiler;

import java.awt.*;

import static java.lang.System.out;


public class Bullet extends AbstractBullet {
    public static final int WIDTH = ResouceManager.bulletD.getWidth();
    public static final int HEIGHT = ResouceManager.bulletD.getHeight();
    private static final int SPEED = PropertyManager.getInt("bulletSpeed");
    private int x;
    private int y;
    private Direction direction;
    private boolean living = true;

    private TankFrame tankFrame;
    private Group group = Group.BAD;


    private Rectangle rectangle = new Rectangle();

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Bullet(int x, int y, Direction direction, Group group, TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.group = group;
        this.tankFrame = tankFrame;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;

        tankFrame.bullets.add(this);
    }

    @Override
    public void paint(Graphics g) {
        if (!living) {
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
        rectangle.x = x;
        rectangle.y = y;
        delBulletOutOfFrame();

    }

    private void delBulletOutOfFrame() {
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }

    @Override
    public void colliedWith(AbstractTank tank) {
        if (group == tank.getGroup()) return;
        // 每次生成浪费内存
        // Rectangle bulletRec = new Rectangle(x, y, WIDTH, HEIGHT);
        // Rectangle tankRec = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
        if (rectangle.intersects(tank.getRectangle())) {
            tank.boom();
            this.boom();
            tankFrame.explodes.add(tankFrame.gameFactory.createExplode(x, y, tankFrame));
        }


    }

    private void boom() {
        living = false;
    }
}
