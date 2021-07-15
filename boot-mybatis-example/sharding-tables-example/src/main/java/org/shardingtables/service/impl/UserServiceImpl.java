package org.shardingtables.service.impl;

import org.shardingtables.domain.User;
import org.shardingtables.domain.UserDatePojo;
import org.shardingtables.mapper.UserMapper;
import org.shardingtables.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.showAll();
    }

    @Override
    public String saveUser() {
        User user = new User();
        user.setId(13L);
        user.setT_user("new Date()");
        user.setNum(13L);
        user.setT_date("2020-03-20");
        userMapper.insert(user);
        return " saved successfully ! ";
    }

    @Override
    public String deleteUser(Long id) {
        userMapper.deleteUser(id);
        return " deleted successfully ! ";
    }

    @Override
    public List<UserDatePojo> getUnion(String date) {
        return userMapper.selectUnion(date);
    }
}
