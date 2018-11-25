package com.fh.shop.api.list.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public   static  final String Y_M_D="yyyy-MM-dd";

    public  static  String  convertDate2Str(Date date, String pattern){
        SimpleDateFormat sim = new SimpleDateFormat(pattern);
        return  sim.format(date);
    }

    public static  Date convertSrt2Date(String str, String pattern){
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            return  dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
     return  null;
    }

}
