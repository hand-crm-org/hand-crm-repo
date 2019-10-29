package com.hand.frame.util;

import java.util.Arrays;

/**
 * 值列表转化
 */
public class LstOfValList {
    public static String listOfValList(String val){
        String[] strArr = val.split("\\,");
        String[] str = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            str[i] = "'" + strArr[i] + "'";
        }
        val = Arrays.toString(str).replace("[", "");
        val = val.replace("]", "");
        return val;
    }
}
