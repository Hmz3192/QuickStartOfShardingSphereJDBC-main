package org.shardingtables.service;


import org.shardingtables.domain.User;
import org.shardingtables.domain.UserDatePojo;

import java.util.List;

public interface UserService {

    List<User> list();

    String saveUser();

    String deleteUser(Long id);

    List<UserDatePojo> getUnion(String date);
}