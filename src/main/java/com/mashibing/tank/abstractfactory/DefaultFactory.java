package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.*;

public class DefaultFactory extends GameFactory{
    @Override
    public AbstractTank createTank(int x, int y, Direction direction, Group group, TankFrame tankFrame) {
        return new Tank(x, y, direction, group, tankFrame);
    }

    @Override
    public AbstractBullet createBullet(int x, int y, Direction direction, Group group, TankFrame tankFrame) {
        return new Bullet(x, y, direction, group, tankFrame);
    }

    @Override
    public AbstractExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new Explode(x, y, tankFrame);
    }
}
