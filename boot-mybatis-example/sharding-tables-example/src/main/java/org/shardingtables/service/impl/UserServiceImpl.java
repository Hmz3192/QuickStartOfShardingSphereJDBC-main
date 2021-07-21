package org.shardingtables.service.impl;

import org.shardingtables.domain.Tdate;
import org.shardingtables.domain.User;
import org.shardingtables.domain.UserDatePojo;
import org.shardingtables.mapper.DateMapper;
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
    @Autowired
    private DateMapper dateMapper;

    @Override
    public List<User> list() {
        return userMapper.showAll();
    }

    @Override
    public String saveUser() {
        User user = new User();
        user.setId(13L);
        user.setStr_user("new Date()");
        user.setStr_num(13L);
        user.setStr_date("2020-03-20");
        userMapper.insert(user);
        return " saved successfully ! ";
    }

    @Override
    public String deleteUser(Long id) {
        userMapper.deleteUser(id);
        return " deleted successfully ! ";
    }

    @Override
    public List<UserDatePojo> getUnion(String date, String startDate, String endDate) {
        return userMapper.selectUnion(date);
    }

    @Override
    public String addDate() {
        for (int i = 1; i <= 10; i++) {
            Tdate user = new Tdate();
            //由于主键策略有问题，手动注入ID
            user.setId((long) i);
            user.setStr_date("2020-" + String.format("%02d", i) + "-11");
            user.setEnd_date("2020-" + String.format("%02d", i + 1) + "-11");
            long resutl = dateMapper.insert(user);
        }
        return "添加成功";
    }

    @Override
    public List<Tdate> showALL() {
        String date = "2020-01-10";
        String endDate = "2020-07-11";
        return dateMapper.showAll(date, endDate);
    }
}
