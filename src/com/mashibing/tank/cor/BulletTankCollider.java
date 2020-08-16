package com.mashibing.tank.cor;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.Explode;
import com.mashibing.tank.GameObject;
import com.mashibing.tank.Tank;

public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(GameObject gameObject1, GameObject gameObject2) {
        if (gameObject1 instanceof Bullet && gameObject2 instanceof Tank) {
            Bullet bullet = (Bullet) gameObject1;
            Tank tank = (Tank) gameObject2;
            if (bullet.getGroup() == tank.getGroup()) return true;
            // 每次生成浪费内存
            // Rectangle bulletRec = new Rectangle(x, y, WIDTH, HEIGHT);
            // Rectangle tankRec = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
            if (bullet.rectangle.intersects(tank.rectangle)) {
                tank.boom();
                bullet.boom();
                return false;
//                gameModel.add(new Explode(tank.getX(), tank.getY(), gameModel));
            }

        }
        if (gameObject2 instanceof Bullet && gameObject1 instanceof Tank) {
            return collide(gameObject2, gameObject1);
        }
        return true;
    }
}
