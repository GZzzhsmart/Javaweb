package com.ht.mail;

import java.io.*;
import java.util.Properties;

public class ConfigUtils {

    /**
     * Properties类是由JDKjava.util包提供的专门存储.properties文件的类
     * Poperties是存储key-value键值对的结构，Map
     */
    private static Properties properties;

    public static Properties build1(String path) {
        if (properties == null) {
            try {
                InputStream inputStream = new FileInputStream(new File(path));
                properties = new Properties();
                properties.load(inputStream); // 载入输入流内的内容
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    /**
     * 根据properties文件的路径读取该文件的内容，并把内容存储到Properties对象中
     * @param path properties文件路径
     * @return
     */
    public static Properties build(String path) {
        synchronized (ConfigUtils.class) {
            if (properties == null) {
                synchronized (ConfigUtils.class) {
                    try {
                        InputStream inputStream = new FileInputStream(new File(path));
                        properties = new Properties();
                        properties.load(inputStream); // 载入输入流内的内容
                        return properties;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public static String getString(String key) {
        return properties.getProperty(key);
    }

    public static Integer getInteger(String key) {
        return Integer.valueOf(properties.getProperty(key));
    }

    public static Double getDouble(String key) {
        return Double.valueOf(properties.getProperty(key));
    }
}
