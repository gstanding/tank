package com.mashibing.tank;

import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    static Properties properties = new Properties();
    static {
        try {
            properties.load(PropertyManager.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (properties == null) {
            return null;
        }
        return properties.get(key);
    }
}
