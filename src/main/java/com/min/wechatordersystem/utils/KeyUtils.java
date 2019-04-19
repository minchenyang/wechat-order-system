package com.min.wechatordersystem.utils;

import java.util.Random;

public class KeyUtils {
    private static Random random = new Random();

    /**
     * 生成唯一主键
     * 格式:时间+随机数
     */
    public static  synchronized String genUniqueKey(){
        int number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + number +"";
    }
}
