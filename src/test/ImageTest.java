package test;

import org.junit.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class ImageTest {

    @Test
    public void test() {
        try {
            // 不使用绝对路径
            BufferedImage bufferedImage =  ImageIO.read(new File("/Users/viaeou/Desktop/截屏 2020-07-16 下午10.53.36.PNG"));
            // classloader
            BufferedImage bufferedImage1 = ImageIO.read(ImageTest.class.getResourceAsStream("images/bulletD.gif"));
            assertNotNull(bufferedImage1);
            assertNotNull(bufferedImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
