package com.arefin.hellomvc.controller;

import com.arefin.hellomvc.entity.Student;
import com.arefin.hellomvc.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {
    static List<User> list1;
    static List<Student> list2;

    static {
        list1 = new ArrayList<>();
        list1.add(new User((long) 1, "Arefin", "0123456789"));
        list1.add(new User((long) 2, "Zakir", "0123456788"));
        list1.add(new User((long) 3, "Ariful", "0123456787"));
        list1.add(new User((long) 4, "Shohidul", "0123456786"));

        list2 = new ArrayList<>();
        list2.add(new Student(1, "Masud", "Borishal"));
        list2.add(new Student(2, "Zulqar", "Dhaka"));
        list2.add(new Student(3, "Ruma", "Chadpur"));
        list2.add(new Student(4, "Yeasin", "Dhaka"));
    }

    @GetMapping(value = "/")
    public String home() {
        return "Hello MVC";
    }

    @GetMapping(value = "/test")
    public String test() {
        return "Hello TEST";
    }

    @GetMapping(value = "/userlist")
    public List<User> getList() {
        return this.list1;
    }

    @GetMapping(value = "/stulist")
    public List<Student> getStuList(){
        return this.list2;
    }

    @GetMapping(value = "/user")
    public User sample() {
        User user = new User();
        user.setId((long) 1);
        user.setUsername("Arefin");
        user.setMobile("0123456789");
        return user;
    }

    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        User user = null;
        for (User u : this.list1) {
            if (id == u.getId()) {
                user = new User();
                user = new User(u.getId(), u.getUsername(), u.getMobile());
                break;
            }
        }
        return user;
    }

    @GetMapping(value = "/stu/{id}")
    public Student getStuById(@PathVariable("id") int id){
        Student stu = null;
        for(Student s : this.list2){
            if(id == s.getId()){
                stu = new Student();
                stu = new Student(s.getId(), s.getStuname(), s.getLocation());
                break;
            }
        }
        return stu;
    }

    @GetMapping(value = "/user/{id}/{mobile}")
    public User getUserByIdMobile(@PathVariable("id") Long id, @PathVariable("mobile") String mobile) {
        User user = null;
        for (User u : this.list1) {
            if (id == u.getId() && mobile.equalsIgnoreCase(u.getMobile())) {
                user = new User();
                user = new User(u.getId(), u.getUsername(), u.getMobile());
                break;
            }
        }
        return user;
    }

    @GetMapping(value = "/stu/{id}/{loc}")
    public Student getStuByIdLoc(@PathVariable("id") int id, @PathVariable("loc") String loc){
        Student stu = null;
        for(Student s : this.list2){
            if(id == s.getId() && loc.equalsIgnoreCase(s.getLocation())){
                stu = new Student();
                stu = new Student(s.getId(), s.getStuname(), s.getLocation());
                break;
            }
        }
        return stu;
    }

    @GetMapping(value = "/adduser")
    public List<User> addUserToList(){
        list1.add(new User((long) 5, "Mahabub", "0123456784"));
        return list1;
    }

    long id = list1.size();

    @GetMapping(value = "/add/{username}/{mobile}")
    public List<User> addUserToListDynamically(@PathVariable("username") String username, @PathVariable("mobile") String mobile){
        id++;
        list1.add(new User(id, username, mobile));
        return list1;
    }

    int id2 = list2.size();
    @GetMapping(value = "/addstu/{stuname}/{loc}")
    public List<Student>addStuDynamically(@PathVariable("stuname") String stuname, @PathVariable("loc") String loc){
        id2++;
        list2.add(new Student(id2, stuname, loc));
        return list2;
    }

    @GetMapping(value = "/best")
    public User getUser(@RequestParam(value = "id") Long id){
        User user = null;
        for(User u : this.list1){
            if(id == u.getId()){
                user = new User();
                user = new User(u.getId(), u.getUsername(), u.getMobile());
                break;
            }
        }
        return user;
    }

    @GetMapping(value = "/addu")
    public List<User> addUserToListUsingParam(@RequestParam(value = "username") String username, @RequestParam(value = "mobile") String mobile){
        id++;
        list1.add(new User(id, username, mobile));
        return list1;
    }

    @GetMapping(value = "/remove/{id}")
    public List<User> removeUserToListDynamically(@PathVariable("id") long id){
        list1.remove(getUserByI(id));
        return list1;
    }

    ///////////////////Extra helper Method=================
    public User getUserByI(Long id) {
        User user = null;
        for (User u : this.list1) {
            if (id == u.getId()) {
                user = new User();
                user = new User(u.getId(), u.getUsername(), u.getMobile());
                break;
            }
        }
        return user;
    }
}
