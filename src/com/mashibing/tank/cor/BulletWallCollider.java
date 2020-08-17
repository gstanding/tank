package com.mashibing.tank.cor;

import com.mashibing.tank.*;

public class BulletWallCollider implements Collider{
    @Override
    public boolean collide(GameObject gameObject1, GameObject gameObject2) {
        if (gameObject1 instanceof Bullet && gameObject2 instanceof Wall) {
            Bullet bullet = (Bullet) gameObject1;
            Wall wall = (Wall) gameObject2;
            if (bullet.rectangle.intersects(wall.rectangle)) {
                bullet.boom();
            }
        }
        if (gameObject1 instanceof Wall && gameObject2 instanceof Bullet) {
            collide(gameObject2, gameObject1);
        }
        return true;
    }
}
