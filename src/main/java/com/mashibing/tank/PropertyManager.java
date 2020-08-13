package com.mashibing.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    static Properties properties = new Properties();


    static {
        try {
            System.out.println(PropertyManager.class.getClassLoader().getResource(""));
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

    public static Integer getInt(String key) {
        if (properties == null) {
            return 0;
        }
        return Integer.parseInt((String) properties.get(key));
    }

    public static String getString(String key) {
        if (properties == null) {
            return "";
        }
        return (String) properties.get(key);
    }

    public static void main(String[] args) {
        Integer width = PropertyManager.getInt("gameWidth");
    }
}
