package cn.xuyonghong.demo.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by xuyonghong on 2022/5/7.
 * 测试component
 */
@Component
@ConfigurationProperties(prefix = "car")
public class Car {
    private  Integer price;
    private  String name;

    public Car() {
    }

    public Car(Integer price, String name) {
        this.price = price;
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
