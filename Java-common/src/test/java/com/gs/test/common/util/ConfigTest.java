package com.gs.test.common.util;

import com.gs.common.util.Config;
import com.gs.common.util.SingletonConfig;
import org.junit.Test;

/**
 * Created by WangGenshen on 7/20/15.
 */
public class ConfigTest {

    @Test
    public void testConfig() {

        final Config config = new Config();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (config) {
                    System.out.println("begin to run thread1");
                    config.build("classpath:/config/db.properties");
                    System.out.println(config.properties);
                    System.out.println("thread1: " + config.getInt("test"));
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (config) {
                    System.out.println("begin to run thread2");
                    config.build("classpath:/config/db1.properties");
                    System.out.println(config.properties);
                    System.out.println("thread2: " + config.getInt("test"));
                }
            }
        });

        final SingletonConfig singletonConfig = SingletonConfig.getInstance();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("begin to run thread3");
                singletonConfig.build("classpath:/config/db.properties");
                System.out.println("thread3: " + singletonConfig.getInt("test"));
            }
        });

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("begin to run thread3");
                singletonConfig.build("classpath:/config/db1.properties");
                System.out.println("thread4: " + singletonConfig.getInt("test"));
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

}
