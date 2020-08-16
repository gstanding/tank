package com.mashibing.tank;

import com.mashibing.tank.cor.BulletTankCollider;
import com.mashibing.tank.cor.Collider;
import com.mashibing.tank.cor.ColliderChain;
import com.mashibing.tank.cor.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    Tank tank = new Tank(200, 500, Direction.DOWN, Group.GOOD, this);

    List<Bullet> bullets = new ArrayList<>();
    List<Tank> badTanks = new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();

    List<GameObject> gameObjects = new ArrayList<>();

    Collider collider = new BulletTankCollider();
    Collider collider2 = new TankTankCollider();

    ColliderChain colliderChain = new ColliderChain();

    public GameModel() {
        int initTankCount = PropertyManager.getInt("initTantCount");
        // 初始化敌方坦克
        for(int i=0; i < initTankCount; i++) {
            gameObjects.add(new Tank(50 + i * 80, 200, Direction.DOWN, Group.BAD, this));
        }
    }

    public void add(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public void remove(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.white);
//        g.drawString("子弹的数量： " + bullets.size(), 60, 60);
//        g.drawString("敌方的数量： " + badTanks.size(), 60, 80);
//        g.drawString("爆炸的数量： " + explodes.size(), 60, 100);
        g.setColor(color);
        tank.paint(g);
        for (int i=0; i < gameObjects.size(); i++) {
            gameObjects.get(i).paint(g);
        }

        for (int i=0; i < gameObjects.size(); i++) {
            for (int j=i+1; j < gameObjects.size(); j++) {
                GameObject gameObject1 = gameObjects.get(i);
                GameObject gameObject2 = gameObjects.get(j);
//                collider.collide(gameObject1, gameObject2);
//                collider2.collide(gameObject1, gameObject2);
                colliderChain.collide(gameObject1, gameObject2);

            }
        }

//        for (int i=0; i < badTanks.size(); i++) {
//            badTanks.get(i).paint(g);
//        }
//
//
//        for (int i=0; i < bullets.size(); i++)
//            for (int j=0; j< badTanks.size(); j++) {
//                bullets.get(i).colliedWith(badTanks.get(j));
//            }
//
//        for (int i=0; i < explodes.size(); i++) {
//            explodes.get(i).paint(g);
//        }
    }


    public Tank getMainTank() {
        return tank;
    }
}
