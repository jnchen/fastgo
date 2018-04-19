package cn.wellt.system.service.impl;

import cn.wellt.system.dao.UserRepository;
import cn.wellt.system.domain.User;
import cn.wellt.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户Service层实现类
 */
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * 根据用户名查找用户对象
     * @param username 用户名
     * @return
     */
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
