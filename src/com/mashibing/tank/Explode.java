package com.mashibing.tank;

import java.awt.*;

public class Explode extends GameObject {
    private static int WIDTH = ResouceManager.explodes[0].getWidth();
    private static int HEIGHT = ResouceManager.explodes[0].getHeight();

    private int x;
    private int y;

    private boolean living = true;
    private GameModel gameModel = null;

    private int step = 0;

    public Explode(int x, int y, GameModel gameModel) {
        this.x = x;
        this.y = y;
        this.gameModel = gameModel;
        gameModel.add(this);
    }

    public void paint(Graphics g) {
        g.drawImage(ResouceManager.explodes[step++], x + Tank.WIDTH/2 - WIDTH/2, y + Tank.HEIGHT/2 - HEIGHT/2, null);
        if (step >= ResouceManager.explodes.length) {
            step = 0;
            gameModel.remove(this);
        }

    }
}
