package com.gs.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by WangGenshen on 7/18/15.
 */
public class Config {

    public Properties properties;

    public Config() {

    }

    public void build(String location) {
        properties = new Properties();
        try {
            properties.load(new BufferedReader(
                    new InputStreamReader(
                            new BufferedInputStream(
                                    new FileInputStream(PathUtil.getResourcePath(location))))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getInt(String key) {
        return Integer.valueOf(properties.getProperty(key));
    }

    public String getString(String key) {
        return properties.getProperty(key);
    }

    public double getDouble(String key) {
        return Double.valueOf(properties.getProperty(key));
    }

}
