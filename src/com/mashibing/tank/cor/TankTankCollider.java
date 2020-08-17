package com.mashibing.tank.cor;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.GameModel;
import com.mashibing.tank.GameObject;
import com.mashibing.tank.Tank;

public class TankTankCollider implements Collider {
    @Override
    public boolean collide(GameObject gameObject1, GameObject gameObject2) {
        if (gameObject1 instanceof Tank && gameObject2 instanceof Tank) {
            Tank tank1 = (Tank) gameObject1;
            Tank tank2 = (Tank) gameObject2;
            // 每次生成浪费内存
            // Rectangle bulletRec = new Rectangle(x, y, WIDTH, HEIGHT);
            // Rectangle tankRec = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
            if (tank1.rectangle.intersects(tank2.rectangle)) {
                tank1.stop();
                tank2.stop();
//                gameModel.add(new Explode(tank.getX(), tank.getY(), gameModel));
            }

        }
        return true;
    }
}
