package com.fan.bootdemo.bootjdbc;

import com.fan.bootdemo.bootjdbc.User;

import java.util.List;
import java.util.Map;

/**
 * Created by fanyuexin on 2021/03/05
 */
public interface UserService {

    int createUser(User user);

    int updateUser(User user);

    int deleteUserById(Long id);

    int deleteAllUser();

    List<Map<String, Object>> getAllUser();

    User getUserById(Long id);
}
