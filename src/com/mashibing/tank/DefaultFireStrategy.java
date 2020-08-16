package com.mashibing.tank;

public class DefaultFireStrategy implements FireStrategy<Tank> {
    private static final DefaultFireStrategy INSTANCE = new DefaultFireStrategy();
    private DefaultFireStrategy() {
    }
    public static DefaultFireStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public void fire(Tank tank) {
        System.out.println("1232142123ffdsf;lkds;lfkdslfk dspfl");
        int bx = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int by = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        new Bullet(bx, by, tank.getDirection(), tank.getGroup(), tank.getGameModel());
    }
}

