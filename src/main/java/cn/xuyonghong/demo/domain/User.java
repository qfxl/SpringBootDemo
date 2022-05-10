package cn.xuyonghong.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by xuyonghong on 2022/5/6.
 */
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String password;
    private String phone;
}
