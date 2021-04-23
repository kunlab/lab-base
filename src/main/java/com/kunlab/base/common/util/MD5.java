package com.kunlab.base.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5计算信息摘要
 * @author likun
 * @date 2021/4/21
 */
public class MD5 {

    public static final String DEFAULT_CHARSET			= "UTF-8";
    public static final String DEFAULT_ALGORITHM        = "MD5";

    /**
     * 根据指定的算法和输入计算散列码
     * @param input 待计算散列码数据
     * @param algorithm the name of the algorithm requested. 支持 MD5/SHA-1/SHA-256
     * @return byteSource, 进而可以转化为 Hex,
     * @throws NoSuchAlgorithmException if no Provider supports a
     *          MessageDigestSpi implementation for the
     *          specified algorithm.
     */
    public static byte[] digest(byte[] input, String algorithm) throws NoSuchAlgorithmException {
        //获取MessageDigest实例
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        //添加需要计算散列的数据
        messageDigest.update(input);
        //生成散列码
        return messageDigest.digest();
    }

    /**
     * md5信息摘要
     * @param bytes 待计算散列码数据
     * @param toUpperCase 是否转化为大写输出
     * @return HexString
     */
    public static String md5(byte[] bytes, boolean toUpperCase) {
        try {
            bytes = digest(bytes, DEFAULT_ALGORITHM);
        } catch (NoSuchAlgorithmException ignore) {
        }

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
     * MD5信息摘要
     * @param bytes 待计算散列码数据
     * @return HexString
     */
    public static String md5(byte[] bytes) {
        return md5(bytes, false);
    }

    /**
     * MD5信息摘要
     * @param text 待计算散列码数据
     * @param key 给text增加的密钥成分
     * @param toUpperCase 是否转化为大写输出
     * @return HexString
     */
    public static String md5(byte[] text, byte[] key, boolean toUpperCase) {
        byte[] bytes = new byte[text.length + key.length];
        System.arraycopy(text, 0, bytes, 0, text.length);
        System.arraycopy(key, 0, bytes, text.length, key.length);

        return md5(bytes, toUpperCase);
    }

    /**
     * MD5信息摘要
     * @param text 待计算散列码数据
     * @param key 给text增加的密钥成分
     * @return HexString
     */
    public static String md5(byte[] text, byte[] key) {
        return md5(text, key, false);
    }

    /**
     * MD5信息摘要, 指定字符编码
     * @param text 待计算散列码数据
     * @param key 给text增加的密钥成分
     * @param charsetName
     *        The name of a supported {@linkplain java.nio.charset.Charset
     *         charset}
     * @param toUpperCase 是否大写输出
     * @return HexString
     * @throws UnsupportedEncodingException
     *         If the named charset is not supported
     *
     */
    public static String md5(String text, String key, String charsetName, boolean toUpperCase) throws UnsupportedEncodingException {
        byte[] bytes = (text + key).getBytes(charsetName);
        return md5(bytes, toUpperCase);
    }

    /**
     * MD5信息摘要, 指定字符编码
     * @param text 待计算散列码数据
     * @param key 给text增加的密钥成分
     * @param charsetName
     *        The name of a supported {@linkplain java.nio.charset.Charset
     *         charset}
     * @return HexString
     * @throws UnsupportedEncodingException
     *         If the named charset is not supported
     */
    public static String md5(String text, String key, String charsetName) throws UnsupportedEncodingException {
        return md5(text, key, charsetName, false);
    }

    /**
     * 指定字符编码的 MD5信息摘要
     * @param text 待计算散列码数据
     * @param charsetName
     *        The name of a supported {@linkplain java.nio.charset.Charset
     *         charset}
     * @return HexString
     */
    public static String md5(String text, String charsetName) throws UnsupportedEncodingException{
        return md5(text, "", charsetName, false);
    }

    /**
     * 默认字符编码（UTF-8）的 MD5信息摘要
     * @param text 待计算散列码数据
     * @return HexString
     */
    public static String md5(String text) {
        try {
            return md5(text, "", DEFAULT_CHARSET, false);
        } catch (UnsupportedEncodingException ignore) {
            //no happen
            return null;
        }
    }






    /**
     * 验证MD5
     * @param bytes 待计算散列码数据
     * @param md5 待验证的HexString
     * @return true：通过； false:未通过
     */
    public static boolean verify(byte[] bytes, String md5) {
        return md5.equalsIgnoreCase(md5(bytes));
    }

    /**
     * 验证MD5
     * @param text 待计算散列码数据
     * @param key 加密密钥
     * @param md5 待验证的HexString
     * @return true: 通过； false:未通过
     */
    public static boolean verify(byte[] text, byte[] key, String md5) {
        return md5.equalsIgnoreCase(md5(text, key));
    }

    /**
     * 验证MD5
     * @param text 待计算散列码数据
     * @param key 加密密钥
     * @param charsetName md5计算时使用的字符编码
     *         The name of a supported {@linkplain java.nio.charset.Charset
     *         charset}
     * @param md5 待验证的HexString
     * @return true:通过； false:未通过
     * @throws UnsupportedEncodingException
     *         If the named charset is not supported
     */
    public static boolean verify(String text, String key, String charsetName, String md5) throws UnsupportedEncodingException {
        return md5.equalsIgnoreCase(md5(text, key, charsetName));
    }

    /**
     * 验证MD5, MD5的计算默认采用UTF-8编码
     * @param text 待计算散列码数据
     * @param charsetName 加密密钥
     * @param md5 待验证的HexString
     * @return true:通过； false:未通过
     */
    public static boolean verify(String text, String charsetName, String md5) throws UnsupportedEncodingException {
        return md5.equalsIgnoreCase(md5(text, charsetName));
    }

    /**
     * 验证MD5
     * @param text 待计算散列码数据
     * @param md5 待验证的HexString
     * @return true:通过； false:未通过
     */
    public static boolean verify(String text, String md5) {
        return md5.equalsIgnoreCase(md5(text));
    }

}
