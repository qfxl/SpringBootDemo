package cn.xuyonghong.demo.mapper;

import cn.xuyonghong.demo.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 创建User
     * @param user
     * @return
     */
    User createUser(User user);

    /**
     * 批量创建User
     * @param users
     * @return
     */
    Integer createBatchUser(List<User> users);

    /**
     * 删除User
     * @param id 用户id
     * @return
     */
    Integer deleteUser(@Param("id") Integer id);

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
    User queryUserById(@Param("id") Integer id);
}
