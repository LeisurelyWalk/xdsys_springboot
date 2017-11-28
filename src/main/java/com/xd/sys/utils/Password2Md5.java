package com.xd.sys.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zhoukang on 2017/11/28.
 */
public class Password2Md5 {
    public static String stringMD5(String password){
        try {
            MessageDigest messageDigest=MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            byte[] result=messageDigest.digest();
            return result.toString();

        }catch (NoSuchAlgorithmException e){
            return null;

        }
    }

}
