package com.hand.frame.util;

import java.math.BigInteger;

public class StringUtil {
    public static boolean isEmpty(String str){
        if(str!=null && !"".equals(str)){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * 生成主键
     * ("精确到毫秒时间戳"+"两位随机数") to 32进制
     */
    public static String getCode(){
        String code = "";
        Long timeMs = System.currentTimeMillis();
        int randNum = (int)(Math.random()*91+10);
        code += String.valueOf(timeMs);
        code += String.valueOf(randNum);
        return new BigInteger(code,10).toString(32);
    }
}
