package cn.xuyonghong.demo.service;

import cn.xuyonghong.demo.domain.User;

import java.util.List;

public interface IUserService {
    /**
     * 创建User
     * @param user
     * @return
     */
    User createUser(User user);

    /**
     * 批量创建User
     * @param user
     * @return
     */
    Integer createBatchUser(List<User> users);

    /**
     * 删除User
     * @param id 用户id
     * @return
     */
    Integer deleteUser(Integer id);

    /**
     * 更新User
     * @param user
     * @return
     */
    Integer updateUser(User user);

    /**
     * 查询所有User
     * @return
     */
    List<User> listUser();

    /**
     * 根据user_id查询User
     * @param id
     * @return
     */
    User queryUserById(Integer id);
}
