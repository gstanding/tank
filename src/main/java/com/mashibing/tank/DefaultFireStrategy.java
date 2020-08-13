package com.mashibing.tank;

import com.mashibing.tank.abstractfactory.AbstractTank;
import com.mashibing.tank.singleton.Mgr01;

public class DefaultFireStrategy implements FireStrategy<AbstractTank> {
    private static final DefaultFireStrategy INSTANCE = new DefaultFireStrategy();
    private DefaultFireStrategy() {
    }
    public static DefaultFireStrategy getInstance() {
        return INSTANCE;
    }

    public void fire(AbstractTank tank) {
        int bx = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int by = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
//        new Bullet(bx, by, tank.getDirection(), tank.getGroup(), tank.getTankFrame());
        tank.getTankFrame().gameFactory.createBullet(bx, by, tank.getDirection(), tank.getGroup(), tank.getTankFrame());
    }
}
