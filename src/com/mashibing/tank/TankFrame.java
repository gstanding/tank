
package com.mashibing.tank;
import java.awt.*;
import java.awt.event.*;

import static java.lang.System.*;


public class TankFrame extends Frame{
    Direction direction = Direction.DOWN;
    Tank tank = new Tank(200, 200, direction);
    Bullet bullet = new Bullet(300, 300, Direction.DOWN);

    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 600;

    public TankFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
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

    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color color = gOffScreen.getColor();
        gOffScreen.setColor(Color.black);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(color);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        tank.paint(g);
        bullet.paint(g);
    }

    class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;
        boolean emit = false;


        @Override
        public void keyTyped(KeyEvent e) {
            int keyCode = e.getExtendedKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_A:
                    bL = true;
                    break;
                case KeyEvent.VK_D:
                    bR = true;
                    break;
                case KeyEvent.VK_W:
                    bU = true;
                    break;
                case KeyEvent.VK_S:
                    bD = true;
                    break;
                case KeyEvent.VK_CONTROL:
                    emit = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getExtendedKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_A:
                    bL = false;
                    break;
                case KeyEvent.VK_D:
                    bR = false;
                    break;
                case KeyEvent.VK_W:
                    bU = false;
                    break;
                case KeyEvent.VK_S:
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