package com.gs.test.common.util;

import com.gs.common.util.EncryptUtil;
import org.junit.Test;

/**
 * Created by WangGenshen on 12/3/15.
 */
public class EncryptUtilTest {

    @Test
    public void testEncrypt() {
        System.out.println(EncryptUtil.md5Encrypt("123"));
    }
}
