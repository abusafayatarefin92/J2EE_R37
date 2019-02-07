package com.arefin.hellomvc.entity;

import java.util.Objects;

public class User {
    private Long id;
    private String username;
    private String mobile;

    public User() {
    }

    public User(Long id, String username, String mobile) {
        this.id = id;
        this.username = username;
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(mobile, user.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, mobile);
    }
}
