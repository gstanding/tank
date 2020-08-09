package com.mashibing.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * 初始化加载资源
 */
public class ResouceManager {
     public static BufferedImage goodTankL;
     public static BufferedImage goodTankU;
     public static BufferedImage goodTankR;
     public static BufferedImage goodTankD;

    public static BufferedImage badTankL;
    public static BufferedImage badTankU;
    public static BufferedImage badTankR;
    public static BufferedImage badTankD;


     public static BufferedImage bulletL;
     public static BufferedImage bulletR;
     public static BufferedImage bulletU;
     public static BufferedImage bulletD;

     public static BufferedImage[] explodes = new BufferedImage[16];

     static {
         try {
             badTankU = ImageIO.read(Objects.requireNonNull(ResouceManager.class.getClassLoader().getResourceAsStream("images/BadTank1.png")));
             badTankR = ImageUtil.rotateImage(badTankU, 90);
             badTankL = ImageUtil.rotateImage(badTankU, -90);
             badTankD = ImageUtil.rotateImage(badTankU, 180);

             goodTankU = ImageIO.read(Objects.requireNonNull(ResouceManager.class.getClassLoader().getResourceAsStream("images/GoodTank1.png")));
             goodTankR = ImageUtil.rotateImage(goodTankU, 90);
             goodTankL = ImageUtil.rotateImage(goodTankU, -90);
             goodTankD = ImageUtil.rotateImage(goodTankU, 180);

             bulletL = ImageIO.read(Objects.requireNonNull(ResouceManager.class.getClassLoader().getResourceAsStream("images/bulletL.gif")));
             bulletR = ImageIO.read(Objects.requireNonNull(ResouceManager.class.getClassLoader().getResourceAsStream("images/bulletR.gif")));
             bulletU = ImageIO.read(Objects.requireNonNull(ResouceManager.class.getClassLoader().getResourceAsStream("images/bulletU.gif")));
             bulletD = ImageIO.read(Objects.requireNonNull(ResouceManager.class.getClassLoader().getResourceAsStream("images/bulletD.gif")));

             for(int i=0; i<explodes.length; i++) {
                 explodes[i] = ImageIO.read(Objects.requireNonNull(ResouceManager.class.getClassLoader().getResourceAsStream("images/e" + (i+1) + ".gif")));
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
}
