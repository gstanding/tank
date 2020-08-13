package com.mashibing.tank;


import com.mashibing.tank.abstractfactory.AbstractTank;

public class FourDirectionFireStrategy implements FireStrategy<AbstractTank> {
    private static final FourDirectionFireStrategy INSTANCE = new FourDirectionFireStrategy();

    private FourDirectionFireStrategy() {
    }

    public static FourDirectionFireStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public void fire(AbstractTank tank) {
        int bx = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        Direction[] directions = Direction.values();
        for(Direction direction: directions) {
//            new Bullet(bx, by, direction, tank.getGroup(), tank.getTankFrame());
            tank.getTankFrame().gameFactory.createBullet(bx, by, direction, tank.getGroup(), tank.getTankFrame());
        }
    }
}
