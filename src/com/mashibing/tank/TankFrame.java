
package com.mashibing.tank;
import java.awt.*;
import java.awt.event.*;

import static java.lang.System.*;


public class TankFrame extends Frame{
    int x = 200, y = 200;

    public TankFrame() {
        setSize(800, 600);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit(0);
            }
        });

        addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g) {
        System.out.println(22);
        g.fillRect(200, 200, 50, 50);
    }

    class MyKeyListener extends KeyAdapter {


        @Override
        public void keyTyped(KeyEvent e) {
            x += 200;
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            y += 200;
            repaint();
        }
    }

}