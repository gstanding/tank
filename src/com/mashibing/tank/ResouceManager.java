package com.mashibing.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

/**
 * 初始化加载资源
 */
public class ResouceManager {
     public static BufferedImage tankL;
     public static BufferedImage tankR;
     public static BufferedImage tankU;
     public static BufferedImage tankD;

     public static BufferedImage bulletL;
     public static BufferedImage bulletR;
     public static BufferedImage bulletU;
     public static BufferedImage bulletD;

     static {
         try {
             tankL = ImageIO.read(Objects.requireNonNull(ResouceManager.class.getClassLoader().getResourceAsStream("images/tankL.gif")));
             tankR = ImageIO.read(Objects.requireNonNull(ResouceManager.class.getClassLoader().getResourceAsStream("images/tankR.gif")));
             tankU = ImageIO.read(Objects.requireNonNull(ResouceManager.class.getClassLoader().getResourceAsStream("images/tankU.gif")));
             tankD = ImageIO.read(Objects.requireNonNull(ResouceManager.class.getClassLoader().getResourceAsStream("images/tankD.gif")));

             bulletL = ImageIO.read(Objects.requireNonNull(ResouceManager.class.getClassLoader().getResourceAsStream("images/bulletL.gif")));
             bulletR = ImageIO.read(Objects.requireNonNull(ResouceManager.class.getClassLoader().getResourceAsStream("images/bulletR.gif")));
             bulletU = ImageIO.read(Objects.requireNonNull(ResouceManager.class.getClassLoader().getResourceAsStream("images/bulletU.gif")));
             bulletD = ImageIO.read(Objects.requireNonNull(ResouceManager.class.getClassLoader().getResourceAsStream("images/bulletD.gif")));
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
}
