package com.evan.wj.utils;

import java.util.Random;

public class StringUtils {

    public static boolean isNotEmpty(String str){

        if(null==str || "".equals(str)){
            return false;
        }
        return true;
    }

    public static String getRandomString(int length){
        String base="abcdefghijklmnopqrstuvwxyj1234567890";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));     //返回指定索引处的字符
        }
        return sb.toString();
    }
}