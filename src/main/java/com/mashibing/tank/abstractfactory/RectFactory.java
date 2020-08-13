package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.Direction;
import com.mashibing.tank.Group;
import com.mashibing.tank.TankFrame;

public class RectFactory extends GameFactory{
    @Override
    public AbstractTank createTank(int x, int y, Direction direction, Group group, TankFrame tankFrame) {
        return new RectTank(x, y, direction, group, tankFrame);
    }

    @Override
    public AbstractBullet createBullet(int x, int y, Direction direction, Group group, TankFrame tankFrame) {
        return new RectBullet(x, y, direction, group, tankFrame);
    }

    @Override
    public AbstractExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new RectExplode(x, y, tankFrame);
    }
}
