package com.mashibing.tank.cor;

import com.mashibing.tank.*;

public class TankWallCollider implements Collider {
    @Override
    public boolean collide(GameObject gameObject1, GameObject gameObject2) {
        if (gameObject1 instanceof Tank && gameObject2 instanceof Wall) {
            Tank tank = (Tank) gameObject1;
            Wall wall = (Wall) gameObject2;
            if (tank.rectangle.intersects(wall.rectangle)) {
                tank.stop();
            }
        }
        if (gameObject1 instanceof Wall && gameObject2 instanceof Bullet) {
            collide(gameObject2, gameObject1);
        }
        return true;
    }
}
