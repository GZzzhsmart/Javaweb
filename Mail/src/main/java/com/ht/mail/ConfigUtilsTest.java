package com.ht.mail;


import org.junit.Test;

import java.util.Properties;

public class ConfigUtilsTest {

    @Test
    public void testBuild() {
        Properties properties = ConfigUtils.build("src/main/resources/mail.properties");
        System.out.println(ConfigUtils.getString("username"));
        System.out.println(ConfigUtils.getInteger("mail.smtp.port"));
    }

}
