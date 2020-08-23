
package com.mashibing.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.System.exit;


public class TankFrame extends Frame{
    GameModel gameModel = GameModel.getInstance();


    public static final int GAME_WIDTH = PropertyManager.getInt("gameWidth");
    public static final int GAME_HEIGHT = PropertyManager.getInt("gameHeight");


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
        gameModel.paint(g);

    }

    class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;


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
                case KeyEvent.VK_F:
                    gameModel.save();
                    break;
                case KeyEvent.VK_L:
                    gameModel.load();
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
                case KeyEvent.VK_CONTROL:
                    String goodFireStrategy = PropertyManager.getString("goodFireStrategy");
                    try {
                        Method method = Class.forName(goodFireStrategy).getDeclaredMethod("getInstance", null);
                        FireStrategy<Tank> goodFireStrategyInstance = (FireStrategy<Tank>)method.invoke(Class.forName(goodFireStrategy));
                        gameModel.getMainTank().fire(goodFireStrategyInstance);
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    } catch (IllegalAccessException illegalAccessException) {
                        illegalAccessException.printStackTrace();
                    } catch (NoSuchMethodException noSuchMethodException) {
                        noSuchMethodException.printStackTrace();
                    } catch (InvocationTargetException invocationTargetException) {
                        invocationTargetException.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if(!bR && !bL && !bU && !bD) gameModel.getMainTank().setMoving(false);
            else {
                gameModel.getMainTank().setMoving(true);
                if(bL) gameModel.getMainTank().setDirection(Direction.LEFT);
                if(bR) gameModel.getMainTank().setDirection(Direction.RIGHT);
                if(bU) gameModel.getMainTank().setDirection(Direction.UP);
                if(bD) gameModel.getMainTank().setDirection(Direction.DOWN);
            }
        }
    }



}