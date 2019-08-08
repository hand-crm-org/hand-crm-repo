package com.hand.frame.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
    public static Date strToDate(String str){
        try {
            Date date = null;
            if(!StringUtil.isEmpty(str)){
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                date = format.parse(str);
            }else {
                date = null;
            }
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
