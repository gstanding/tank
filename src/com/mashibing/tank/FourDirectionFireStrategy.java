package com.mashibing.tank;

public class FourDirectionFireStrategy implements FireStrategy<Tank> {
    private static final FourDirectionFireStrategy INSTANCE = new FourDirectionFireStrategy();

    private FourDirectionFireStrategy() {
    }

    public static FourDirectionFireStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public void fire(Tank tank) {
        int bx = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        Direction[] directions = Direction.values();
        for(Direction direction: directions) {
            new Bullet(bx, by, direction, tank.getGroup(), tank.getGameModel());
        }
    }
}