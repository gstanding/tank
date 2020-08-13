package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.*;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

import static java.lang.System.out;

/**
 * tank's action
 */
public class RectTank extends AbstractTank {
    @Override
    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    private Rectangle rectangle;
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

    public TankFrame getTankFrame() {
        return tankFrame;
    }

    public void setTankFrame(TankFrame tankFrame) {
        this.tankFrame = tankFrame;
    }

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

    @Override
    public void setMoving(boolean moving) {
        this.moving = moving;
    }


    public RectTank(int x, int y, Direction direction, Group group, TankFrame tankFrame) {
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

        this.setRectangle(new Rectangle(x, y, WIDTH, HEIGHT));
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

    @Override
    public void paint(Graphics g) {
        if (!living) tankFrame.badTanks.remove(this);
        Color color = g.getColor();
//        switch (direction) {
//            case LEFT:
//                g.drawImage(group == Group.BAD ? ResouceManager.badTankL : ResouceManager.goodTankL, x, y, null);
//                break;
//            case RIGHT:
//                g.drawImage(group == Group.BAD ? ResouceManager.badTankR : ResouceManager.goodTankR, x, y, null);
//                break;
//            case UP:
//                g.drawImage(group == Group.BAD ? ResouceManager.badTankU : ResouceManager.goodTankU, x, y, null);
//                break;
//            case DOWN:
//                g.drawImage(group == Group.BAD ? ResouceManager.badTankD : ResouceManager.goodTankD, x, y, null);
//                break;
//            default:
//                break;
//
//        }
        if (group == Group.BAD) {
            g.setColor(Color.gray);
        }
        if (group == Group.GOOD) {
            g.setColor(Color.white);
        }
        g.fillRect(x, y, 80, 80);
        g.setColor(color);
        move();
    }

    @Override
    public void fire(FireStrategy<AbstractTank> fireStrategy) {
        fireStrategy.fire(this);
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
        String badFireStrategy = PropertyManager.getString("badFireStrategy");
        try {
            Method method = Class.forName(badFireStrategy).getDeclaredMethod("getInstance", null);
            FireStrategy<AbstractTank> badFireStrategytInstance = (FireStrategy<AbstractTank>)method.invoke(Class.forName(badFireStrategy));

            if (group == Group.BAD && random.nextInt(10) > 8) this.fire(badFireStrategytInstance);
            if (group == Group.BAD && random.nextInt(100) > 95) randomDirectiuon();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    private void detectBorder() {
        if (x < 0) x = 0;
        else if (y < 30) y = 30;
        else if (x > TankFrame.GAME_WIDTH - RectTank.WIDTH) x = TankFrame.GAME_WIDTH - RectTank.WIDTH;
        else if (y > TankFrame.GAME_HEIGHT - RectTank.HEIGHT) y = TankFrame.GAME_HEIGHT - RectTank.HEIGHT;
    }

    private void randomDirectiuon() {
        direction = Direction.values()[random.nextInt(4)];
    }



    public void boom() {
        living = false;
    }
}