package cn.xuyonghong.demo.redis;

import cn.xuyonghong.demo.util.RandomUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisClient {

    private final StringRedisTemplate redisTemplate;

    public RedisClient(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 生成一个一分钟过期的验证码存放到redis
     * 1，生成随机6位数验证码
     * 2，验证码1分钟内有效
     * 3，每天最多获取3次验证码
     *
     * @param phone
     */
    public String onSendSms(String phone) throws RuntimeException {
        int maxSendTimes = 3;
        //记录验证码发送次数
        StringBuilder counterKeyBuilder = new StringBuilder();
        counterKeyBuilder.append("sms")
                .append(phone)
                .append(":count");
        String counterKey = counterKeyBuilder.toString();
        //记录验证码内容
        StringBuilder smsKeyBuilder = new StringBuilder();
        smsKeyBuilder.append("sms")
                .append(phone)
                .append(":code");
        String smsKey = smsKeyBuilder.toString();
        //获取已经发送的次数
        String count = redisTemplate.opsForValue().get(counterKey);
        if (count == null) {
            //第一次发送
            redisTemplate.opsForValue().set(counterKey, "1", 24, TimeUnit.HOURS);
        } else if (Integer.parseInt(count) <= maxSendTimes - 1) {
            redisTemplate.opsForValue().increment(counterKey);
        } else {
            throw new RuntimeException("验证码发送次数超过限制");
        }
        //保存验证码到redis，60秒过期
        String smsCode = RandomUtil.getRandomSmsCode();
        redisTemplate.opsForValue().set(smsKey, smsCode, 60L, TimeUnit.SECONDS);
        return smsCode;
    }
}
