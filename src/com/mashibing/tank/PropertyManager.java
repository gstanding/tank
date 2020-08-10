package com.mashibing.tank;

import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    static Properties properties = new Properties();

    private PropertyManager() {
    }


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
}
