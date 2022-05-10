package cn.xuyonghong.demo.controller;

import cn.xuyonghong.demo.base.ServerResponse;
import cn.xuyonghong.demo.domain.User;
import cn.xuyonghong.demo.service.imp.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyonghong on 2022/5/6.
 */
@Slf4j
@RestController
@RequestMapping(path = "/user", produces = "application/json")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService mUserService;

    @GetMapping("/list")
    public ServerResponse<List<User>> list() {
        return ServerResponse.createBySuccess(mUserService.listUser());
    }

    @GetMapping("/{id}")
    public ServerResponse<User> queryUserById(@PathVariable("id") Integer id) {
        return ServerResponse.createBySuccess(mUserService.queryUserById(id));
    }

    @PatchMapping("/update")
    public ServerResponse<Integer> updateUser(@RequestBody User user) {
        return ServerResponse.createBySuccess(mUserService.updateUser(user));
    }

    @PutMapping("/create")
    public ServerResponse<User> createUser(@RequestBody User user) {
        return ServerResponse.createBySuccess(mUserService.createUser(user));
    }

    @PutMapping("/createBatch")
    public ServerResponse<Integer> createBatchUser(@RequestBody List<User> users) {
        return ServerResponse.createBySuccess(mUserService.createBatchUser(users));
    }

    @DeleteMapping("/delete/{id}")
    public ServerResponse<Integer> deleteUser(@PathVariable Integer id) {
        return ServerResponse.createBySuccess(mUserService.deleteUser(id));
    }
}
