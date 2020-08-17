package com.mashibing.tank;

import com.mashibing.tank.decorator.RectDecorator;
import com.mashibing.tank.decorator.TailDecorator;

public class DefaultFireStrategy implements FireStrategy<Tank> {
    private static final DefaultFireStrategy INSTANCE = new DefaultFireStrategy();
    private DefaultFireStrategy() {
    }
    public static DefaultFireStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public void fire(Tank tank) {
        int bx = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int by = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
//        new Bullet(bx, by, tank.getDirection(), tank.getGroup());
        GameModel.getInstance().add(new RectDecorator(new TailDecorator(new Bullet(bx, by, tank.getDirection(), tank.getGroup()))));
    }
}

