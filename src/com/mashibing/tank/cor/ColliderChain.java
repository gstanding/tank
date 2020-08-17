package com.mashibing.tank.cor;

import com.mashibing.tank.GameModel;
import com.mashibing.tank.GameObject;

import java.util.LinkedList;
import java.util.List;

public class ColliderChain implements Collider {
    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain() {
        add(new BulletTankCollider());
        add(new TankTankCollider());
        add(new BulletWallCollider());
        add(new TankWallCollider());
    }

    public void add(Collider collider) {
        colliders.add(collider);
    }

    public boolean collide(GameObject gameObject1, GameObject gameObject2) {
        for (Collider collider : colliders) {
            if (!collider.collide(gameObject1, gameObject2)) {
                return false;
            }
        }
        return true;
    }
}
