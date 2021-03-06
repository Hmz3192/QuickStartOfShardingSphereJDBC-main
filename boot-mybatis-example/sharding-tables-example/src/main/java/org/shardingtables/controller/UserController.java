package org.shardingtables.controller;

import org.shardingtables.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Test API
 * http://localhost:8080/save-user: add a line of data
 * http://localhost:8080/list-user: show all of data
 * http://localhost:8080/delete-user: delete a line of data about user
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("save-user")
    public String saveUser() {
        return userService.saveUser();
    }

    @GetMapping("addDate")
    public String addDate() {
        return userService.addDate();
    }

    @DeleteMapping("delete-user")
    public String deleteUser(Long id) {
        return userService.deleteUser(id);
    }

    @GetMapping("list-user")
    public Object listUser() {
        return userService.list();
    }

    @GetMapping("list-date")
    public Object listDate() {
        return userService.showALL();
    }

    @GetMapping("getUnion")
    public Object getUnion() {
        String date = "2020-08-11";
        String startDate = "2020-05-11";
        String endDate = "2020-10-11";
        return userService.getUnion(date, date, endDate);
    }

}
