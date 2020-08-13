package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.Direction;
import com.mashibing.tank.Group;
import com.mashibing.tank.TankFrame;

public abstract class GameFactory {
    public abstract AbstractTank createTank(int x, int y, Direction direction, Group group, TankFrame tankFrame);
    public abstract AbstractBullet createBullet(int x, int y, Direction direction, Group group, TankFrame tankFrame);
    public abstract AbstractExplode createExplode(int x, int y, TankFrame tankFrame);
}
