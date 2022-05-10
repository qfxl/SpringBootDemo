package cn.xuyonghong.demo.service.imp;

import cn.xuyonghong.demo.domain.User;
import cn.xuyonghong.demo.mapper.UserMapper;
import cn.xuyonghong.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper mUserMapper;

    /**
     * 创建User
     *
     * @param user
     * @return
     */
    @Override
    public User createUser(User user) {
        return mUserMapper.createUser(user);
    }

    /**
     * 批量创建User
     *
     * @param users
     * @return
     */
    @Override
    public Integer createBatchUser(List<User> users) {
        return mUserMapper.createBatchUser(users);
    }

    /**
     * 删除User
     *
     * @param id 用户id
     * @return
     */
    @Override
    public Integer deleteUser(Integer id) {
        return mUserMapper.deleteUser(id);
    }

    /**
     * 更新User
     *
     * @param user
     * @return
     */
    @Override
    public Integer updateUser(User user) {
        return mUserMapper.updateUser(user);
    }

    /**
     * 查询所有User
     *
     * @return
     */
    @Override
    public List<User> listUser() {
        return mUserMapper.listUser();
    }

    /**
     * 根据user_id查询User
     *
     * @param id
     * @return
     */
    @Override
    public User queryUserById(Integer id) {
        return mUserMapper.queryUserById(id);
    }
}
