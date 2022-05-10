package cn.xuyonghong.demo.util;

import java.util.Random;

public class RandomUtil {

    private RandomUtil() {}

    /**
     * 生成6位随机数
     * @return
     */
    public static String getRandomSmsCode() {
        return String.valueOf(new Random().nextInt(1000000));
    }
}
