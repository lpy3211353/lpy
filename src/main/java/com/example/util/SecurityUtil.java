/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Author LPY.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * 安全相关util
 * 拥有常见的几种字符串转化和加密功能
 */
public class SecurityUtil {

    /**
     * 用于将字符串转化为MD5字符串
     * @param txt 需要加密的文本内容
     * @return 返回一个已经加密为md5的字符串
     */
    public static String stringToMD5(String txt){
        byte[] secretByte;
        try {
            secretByte= MessageDigest.getInstance("md5").digest(txt.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        String md5code=new BigInteger(1,secretByte).toString(16);
        for (int i = 0; i < 32-md5code.length(); i++) {
            md5code="0"+md5code;
        }
        return md5code;
    }

    /**
     * 用于将字符串转化为Base64
     * @param txt 需要转化的字符串
     * @return 返回一个经过Base64转义后的字符串
     */
    public static String stringToBase64(String txt){
        return Base64.getEncoder().encodeToString(txt.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 用于将Base64字符串还原为普通字符串
     * @param txt Base64字符串
     * @return 返回一个普通字符串
     */
    public static String base64ToString(String txt){
        byte[] bytes=Base64.getDecoder().decode(txt);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
