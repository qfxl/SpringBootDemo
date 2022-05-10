package cn.xuyonghong.demo.config;

import cn.xuyonghong.demo.domain.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xuyonghong on 2022/5/7.
 */
@Configuration
@MapperScan("cn.xuyonghong.demo.mapper")
public class DemoConfig {

    /**
     * 在SpringBoot中注册一个user
     * @return
     */
    @Bean
    public User user() {
        return new User(-1, "qfxl", "123", "10086");
    }

}
