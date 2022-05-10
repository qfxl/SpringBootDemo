package cn.xuyonghong.demo.controller;

import cn.xuyonghong.demo.base.ResponseCode;
import cn.xuyonghong.demo.base.ServerResponse;
import cn.xuyonghong.demo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    void testListAllUser() {
        ServerResponse<List<User>> response = userController.list();
        assertIsSuccess(response);
        response.getData().forEach(System.out::println);
    }

    @Test
    void testCreateUser() {
        User testUser = new User(-1, "qfxl", "HelloWorld", "10010");
        ServerResponse<User> response = userController.createUser(testUser);
        assertIsSuccess(response);
        System.out.println("create user success");
    }

    @Test
    void testCreateBatchUser() {
        List<User> batchUserList = new ArrayList<>();
        batchUserList.add(new User(-1, "Anna", "AnnaPwd", "10086"));
        batchUserList.add(new User(-1, "Bruce", "BrucePwd", "10000"));
        ServerResponse<Integer> response = userController.createBatchUser(batchUserList);
        assertIsSuccess(response);
        System.out.println("batch insert success");
    }

    @Test
    void testUpdateUser() {
        ServerResponse<User> response = userController.queryUserById(1);
        assertIsSuccess(response);
        System.out.println("find user " + response.getData());
        User existUser = response.getData();
        existUser.setName("modified " + existUser.getName());
        existUser.setPassword("modified "+ existUser.getPassword());
        existUser.setPhone("modified "+ existUser.getPhone());
        ServerResponse<Integer> updateUserResponse = userController.updateUser(existUser);
        assertIsSuccess(updateUserResponse);
        System.out.println("update user success");
    }

    @Test
    void testDeleteUser() {
        ServerResponse<Integer> response = userController.deleteUser(1);
        assertIsSuccess(response);
        System.out.println("delete user success");
    }

    private <T> void assertIsSuccess(ServerResponse<T> response) {
        Assert.isTrue(response.getStatus() == ResponseCode.SUCCESS.getCode(), "response failed " + response.getMsg());
    }
}
