package com.mashibing.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("apple.awt.UIElement", "true");
        TankFrame frame = new TankFrame();
        // 初始化敌方坦克
        for(int i=0; i < 5; i++) {
            frame.badTanks.add(new Tank(50 + i * 80, 200, Direction.DOWN, Group.BAD, frame));
        }
        while (true) {
            Thread.sleep(50);
            frame.repaint();
        }
    }
}