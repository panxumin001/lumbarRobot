package com.germaine.lumbarRobot.service.impl;

import com.germaine.lumbarRobot.service.UserService;
import com.germaine.lumbarRobot.entity.User;
import com.germaine.lumbarRobot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByMobile(String mobile) {
        return userMapper.getUserByMobile(mobile);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public int update(String mobile, User user) {
        return userMapper.update(mobile, user);
    }

    @Override
    public int delete(String mobile) {
        return userMapper.delete(mobile);
    }
}
