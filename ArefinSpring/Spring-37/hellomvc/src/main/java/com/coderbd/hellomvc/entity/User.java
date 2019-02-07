package com.coderbd.hellomvc.entity;


import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private Long id;
    private String userName;
    private String mobile;

    public User() {
    }

    public User(Long id, String userName, String mobile) {
        this.id = id;
        this.userName = userName;
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getMobile() {
        return mobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(getUserName(), user.getUserName()) &&
                Objects.equals(getMobile(), user.getMobile());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getUserName(), getMobile());
    }
}
