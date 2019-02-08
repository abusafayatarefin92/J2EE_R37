package com.coderbd.hellomvc.controller;

import com.coderbd.hellomvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    static List<User> list;

    static {
        list = new ArrayList<>();
        list.add(new User(1L, "susmi", "01686000000"));
        list.add(new User(2L, "moly", "01686000001"));
        list.add(new User(3L, "rojina", "01686000002"));
    }

    @GetMapping(value = "/")
    @ResponseBody
    public String home() {
        return "Hello Mvc";
    }

    @GetMapping(value = "/test")
    public String test() {
        return "Hello Test";
    }

    @RequestMapping(
            value = "/list",
            method = RequestMethod.GET)
    @ResponseBody
    public List<User> getList() {
        return this.list;
    }

    @GetMapping(value = "/user")
    public User getUser() {
        return new User(1L, "susmi", "01686000000");
    }

    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable("id") Long userid) {
        User user = null;
        for (User u : this.list) {
            if (userid == u.getId()) {
                user = new User();
                user = new User(u.getId(), u.getUserName(), u.getMobile());
                break;
            }
        }
        return user;
    }

    @GetMapping(value = "/user/{id}/{mobile}")
    public User getUserById(@PathVariable("id") Long userid, @PathVariable("mobile") String m) {
        User user = null;
        for (User u : this.list) {
            if (userid == u.getId() && m.equalsIgnoreCase(u.getMobile())) {
                user = new User();
                user = new User(u.getId(), u.getUserName(), u.getMobile());
                break;
            }
        }
        return user;
    }

    @GetMapping(value = "/addUser")
    public List<User> addUserToList() {
        list.add(new User(4L, "Mortoza", "01686000003"));
        return list;
    }

    long id = list.size();

    @GetMapping(value = "/add/{userName}/{mobile}")
    public List<User> addUserToListDynamically(@PathVariable("userName") String username,
                                               @PathVariable("mobile") String m) {
        id++;
        list.add(new User(id, username, m));
        return list;
    }

    @GetMapping(value = "/del/{id}")
    public List<User> removeUserToListDynamically(@PathVariable("id") Long id) {
        list.remove(getUserByI(id));
        return list;
    }


    @GetMapping("/best")
    public User getUser(@RequestParam(value = "id") Long userid) {
        User user = null;
        for (User u : this.list) {
            if (userid == u.getId()) {
                user = new User();
                user = new User(u.getId(), u.getUserName(), u.getMobile());
                break;
            }
        }
        return user;
    }

    @GetMapping(value = "/add")
    public List<User> addUserToListUsingParam(@RequestParam(value = "userName") String username,
                                               @RequestParam(value = "mobile") String m) {
        id++;
        list.add(new User(id, username, m));
        return list;
    }

    ///////////////////Extra helper Method=================
    public User getUserByI(Long userid) {
        User user = null;
        for (User u : this.list) {
            if (userid == u.getId()) {
                user = new User();
                user = new User(u.getId(), u.getUserName(), u.getMobile());
                break;
            }
        }
        return user;
    }


}
