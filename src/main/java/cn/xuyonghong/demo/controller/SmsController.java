package cn.xuyonghong.demo.controller;

import cn.xuyonghong.demo.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    private RedisClient mRedisClient;

    /**
     *
     * @return 验证码内容
     */
    @GetMapping("/send")
    public String sendSms(@RequestParam("phone") String phone) {
        return mRedisClient.onSendSms(phone);
    }
}
