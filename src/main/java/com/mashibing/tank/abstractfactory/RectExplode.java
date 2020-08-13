package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.ResouceManager;
import com.mashibing.tank.Tank;
import com.mashibing.tank.TankFrame;

import java.awt.*;
import java.util.Collection;

public class RectExplode extends AbstractExplode {
    private static int WIDTH = ResouceManager.explodes[0].getWidth();
    private static int HEIGHT = ResouceManager.explodes[0].getHeight();

    private int x;
    private int y;

    private boolean living = true;
    private TankFrame tankFrame = null;

    private int step = 0;

    public RectExplode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    @Override
    public void paint(Graphics g) {
//        g.drawImage(ResouceManager.explodes[step++], x + Tank.WIDTH/2 - WIDTH/2, y + Tank.HEIGHT/2 - HEIGHT/2, null);
        Color color = g.getColor();
        g.setColor(Color.red);
        g.fillRect(x + Tank.WIDTH/2 - 15*step/2, y + Tank.HEIGHT/2 - 15*step/2, 15*step, 15*step);
        step++;
        g.setColor(color);
        if (step >= ResouceManager.explodes.length) {
            step = 0;
            tankFrame.explodes.remove(this);
        }

    }
}
