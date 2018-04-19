package cn.wellt.system.service;

import cn.wellt.system.domain.User;

/**
 * 用户Service层 接口
 */
public interface UserService {
    User findByUsername(String username);
}
