package com.mashibing.tank;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("apple.awt.UIElement", "true");
        TankFrame frame = new TankFrame();



        /**
         * 游戏画面刷新
         */
        do {
            sleep(50);
            frame.repaint();
        } while (true);
    }
}