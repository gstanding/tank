package com.mashibing.tank;

import com.mashibing.tank.abstractfactory.AbstractExplode;
import sun.audio.AudioPlayer;

import java.applet.AudioClip;
import java.awt.*;

public class Explode extends AbstractExplode {
    private static int WIDTH = ResouceManager.explodes[0].getWidth();
    private static int HEIGHT = ResouceManager.explodes[0].getHeight();

    private int x;
    private int y;

    private boolean living = true;
    private TankFrame tankFrame = null;

    private int step = 0;

    public Explode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResouceManager.explodes[step++], x + Tank.WIDTH/2 - WIDTH/2, y + Tank.HEIGHT/2 - HEIGHT/2, null);
        if (step >= ResouceManager.explodes.length) {
            step = 0;
            tankFrame.explodes.remove(this);
        }

    }

}
