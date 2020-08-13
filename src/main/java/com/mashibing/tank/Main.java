package com.mashibing.tank;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("apple.awt.UIElement", "true");
        TankFrame frame = new TankFrame();

        int initTankCount = PropertyManager.getInt("initTantCount");
        // 初始化敌方坦克
        for(int i=0; i < initTankCount; i++) {
            frame.badTanks.add(frame.gameFactory.createTank(50 + i * 80, 200, Direction.DOWN, Group.BAD, frame));
        }

        /**
         * 游戏画面刷新
         */
        do {
            sleep(50);
            frame.repaint();
        } while (true);
    }
}