package com.mashibing.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
    public static void main(String[] args) {
        TankFrame frame = new TankFrame();
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setTitle("tank war");

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}