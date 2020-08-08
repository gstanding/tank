
package com.mashibing.tank;
import java.awt.*;
import java.awt.event.*;

import static java.lang.System.*;


public class TankFrame extends Frame{
    Direction direction = Direction.DOWN;
    int x = 200, y = 200;
    Tank tank = new Tank(x, y, direction);

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
        tank.paint(g);
    }

    class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;


        @Override
        public void keyTyped(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if(!bR && !bL && !bU && !bD) tank.setMoving(false);
            else {
                tank.setMoving(true);
                if(bL) tank.setDirection(Direction.LEFT);
                if(bR) tank.setDirection(Direction.RIGHT);
                if(bU) tank.setDirection(Direction.UP);
                if(bD) tank.setDirection(Direction.DOWN);
            }


        }
    }



}