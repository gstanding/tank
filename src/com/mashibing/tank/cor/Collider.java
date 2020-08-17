package com.mashibing.tank.cor;

import com.mashibing.tank.GameModel;
import com.mashibing.tank.GameObject;

public interface Collider {
    boolean collide(GameObject gameObject1, GameObject gameObject2);
}
