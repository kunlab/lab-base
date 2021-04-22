package com.kunlab.base.common.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;


/**
 * @author likun
 * @date 2021/4/22
 */
public class MD5Test {

    @Test
    public void md5OfTextKeyAndUpperCase() {
        byte[] bytes = new byte[1];
        bytes[0] = 1;
        byte[] keys = new byte[1];
        keys[0] = 0;

        Assert.assertNotNull(MD5.md5(bytes, keys, false));
    }

    @Test
    public void verifyByTextKeyAndUpperCase() {
        String targetHashCode = "25daad3d9e60b45043a70c4ab7d3b1c6";

        byte[] bytes = new byte[1];
        bytes[0] = 1;
        byte[] keys = new byte[1];
        keys[0] = 0;

        Assert.assertEquals(targetHashCode, MD5.md5(bytes, keys, false));
    }

    @Test
    public void verifyByString() {
        String text = "1";
        String key = "0";
        String charsetName = MD5.DEFAULT_CHARSET;
        String targetHashCode = "d3d9446802a44259755d38e6d163e820";

        try {
            Assert.assertTrue(MD5.verify(text, key, charsetName, targetHashCode));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
