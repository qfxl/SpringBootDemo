package cn.xuyonghong.demo.redis;

import cn.xuyonghong.demo.controller.SmsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisTest {

    @Autowired
    private SmsController smsController;

    @Test
    void testSendSmsCode() {
        String smsCode = smsController.sendSms("10010");
        System.out.println(smsCode);
    }
}
