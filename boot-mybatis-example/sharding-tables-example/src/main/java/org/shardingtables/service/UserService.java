package org.shardingtables.service;


import org.shardingtables.domain.Tdate;
import org.shardingtables.domain.User;
import org.shardingtables.domain.UserDatePojo;

import java.util.List;

public interface UserService {

    List<User> list();

    String saveUser();

    String deleteUser(Long id);

    List<UserDatePojo> getUnion(String date,String startDate,String endDate);

    String addDate();

    List<Tdate> showALL();
}