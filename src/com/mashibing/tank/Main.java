package com.mashibing.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("apple.awt.UIElement", "true");
        TankFrame frame = new TankFrame();
        while (true) {
            Thread.sleep(50);
            frame.repaint();
        }
    }
}