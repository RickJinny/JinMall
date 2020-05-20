package com.rick.jinmall.seckill.utils;

import java.text.SimpleDateFormat;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 生成随机数 Util
 */
public class RandomUtil {

    private static final SimpleDateFormat dateFormatOne = new SimpleDateFormat("yyyyMMddHHmmsssSS");

    /**
     * 保证线程安全的随机数
     */
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    /**
     * 生成订单编号：时间戳 + 随机数
     */
    public static String generateOrderCode() {
        return System.currentTimeMillis() + generateNumber(4);
    }

    public static String generateNumber(int num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            sb.append(random.nextInt(9));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(generateOrderCode());
        }
    }
}
