package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.*;

import java.awt.*;

public abstract class AbstractTank {

    public abstract void paint(Graphics graphics);

    public abstract void setDirection(Direction left);

    public abstract void setMoving(boolean b);

    public abstract void fire(FireStrategy<AbstractTank> goodFireStrategyInstance);

    public abstract Group getGroup();

    public abstract void boom();

    public abstract int getX();

    public abstract int getY();

    public abstract TankFrame getTankFrame();

    public abstract Direction getDirection();

    public abstract Rectangle getRectangle();
}
