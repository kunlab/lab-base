package com.kunlab.base.common.util;

import com.sun.istack.internal.NotNull;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author likun
 * @date 2021/4/21
 */
public class MD5 {
    public static final String DEFAULT_CHARSET			= "UTF-8";

    /**
     * md5加密
     * @param bytes 待加密内容
     * @param toUpperCase 是否转化为大写输出
     * @return hashCode
     */
    public static String md5(@NotNull byte[] bytes, boolean toUpperCase) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            // no happen
        }
        messageDigest.update(bytes);
        bytes = messageDigest.digest();

        StringBuilder sb = new StringBuilder();
        for(byte b : bytes) {
            int v = b & 0xFF;
            if(v < 0x10) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(v));
        }

        return toUpperCase ? sb.toString().toUpperCase() : sb.toString();
    }

    /**
     * MD5加密
     * @param bytes 待加密内容
     * @return 默认输出大写hashCode
     */
    public static String md5(@NotNull byte[] bytes) {
        return md5(bytes, true);
    }

    /**
     * MD5加密
     * @param text 待加密内容
     * @param key 加密密钥
     * @param toUpperCase 是否转化为大写输出
     * @return hashCode
     */
    public static String md5(@NotNull byte[] text, byte[] key, boolean toUpperCase) {
        byte[] bytes = new byte[text.length + key.length];
        System.arraycopy(text, 0, bytes, 0, text.length);
        System.arraycopy(key, 0, bytes, text.length, key.length);

        return md5(bytes, toUpperCase);
    }

    /**
     * MD5加密
     * @param text 待加密内容
     * @param key 加密密钥
     * @return 默认返回大写hashcode
     */
    public static String md5(@NotNull byte[] text, byte[] key) {
        return md5(text, key, true);
    }

    /**
     * MD5加密,指定字符编码
     * @param text 加密内容
     * @param key 加密密钥
     * @param charsetName
     *        The name of a supported {@linkplain java.nio.charset.Charset
     *         charset}
     * @param toUpperCase 是否大写输出
     * @return hashCode
     * @throws UnsupportedEncodingException
     *         If the named charset is not supported
     *
     */
    public static String md5(@NotNull String text, String key, String charsetName, boolean toUpperCase) throws UnsupportedEncodingException {
        byte[] bytes = (text + key).getBytes(charsetName);
        return md5(bytes, toUpperCase);
    }

    /**
     * MD5加密，默认返回大写hashCode
     * @param text 加密内容
     * @param key 加密密钥
     * @param charsetName
     *        The name of a supported {@linkplain java.nio.charset.Charset
     *         charset}
     * @return 大写hashCode
     * @throws UnsupportedEncodingException
     *         If the named charset is not supported
     */
    public static String md5(@NotNull String text, String key, String charsetName) throws UnsupportedEncodingException {
        return md5(text, key, charsetName, true);
    }

    /**
     * 默认字符编码（UTF-8）的 MD5加密
     * @param text 加密内容
     * @param key 加密密钥
     * @return 大写hashCode
     */
    public static String md5(@NotNull String text, String key) {
        try {
            return md5(text, key, DEFAULT_CHARSET, true);
        } catch (UnsupportedEncodingException ignore) {
            //no happen
            return null;
        }
    }

    /**
     * MD5 加密
     * @param text 加密内容
     * @return hashCode
     */
    public static String md5(@NotNull String text) {
        try {
            return md5(text, "", DEFAULT_CHARSET, true);
        } catch (UnsupportedEncodingException ignore) {
            //no happen
            return null;
        }
    }




    /**
     * 验证MD5
     * @param bytes 待加密原文
     * @param md5 待验证的hashcode
     * @return true：通过； false:未通过
     */
    public static boolean verify(@NotNull byte[] bytes, String md5) {
        return md5.equalsIgnoreCase(md5(bytes));
    }

    /**
     * 验证MD5
     * @param text 待加密原文
     * @param key 加密密钥
     * @param md5 待验证hashcode
     * @return true: 通过； false:未通过
     */
    public static boolean verify(@NotNull byte[] text, byte[] key, String md5) {
        return md5.equalsIgnoreCase(md5(text, key));
    }

    /**
     * 验证MD5
     * @param text 待加密的原文
     * @param key 可选的加密密钥
     * @param charsetName md5计算时使用的字符编码
     *         The name of a supported {@linkplain java.nio.charset.Charset
     *         charset}
     * @param md5 待验证的hashcode
     * @return true:通过； false:未通过
     * @throws UnsupportedEncodingException
     *         If the named charset is not supported
     */
    public static boolean verify(@NotNull String text, String key, String charsetName, String md5) throws UnsupportedEncodingException {
        return md5.equalsIgnoreCase(md5(text, key, charsetName));
    }

    /**
     * 验证MD5, MD5的计算默认采用UTF-8编码
     * @param text 待加密数据原文
     * @param key 加密密钥
     * @param md5 待验证 hashcode
     * @return true:通过； false:未通过
     */
    public static boolean verify(@NotNull String text, String key, String md5){
        return md5.equalsIgnoreCase(md5(text, key));
    }

}
