package com.springsecuritymysql.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Enter your name")
    private String name;

    @NotBlank(message = "Enter your mobile")
    private String mobile;

    @NotBlank(message = "Enter your email")
    private String email;

    @NotNull(message = "Select your status")
    private boolean status;

    @NotBlank(message = "Enter your username")
    private String username;

    @NotBlank(message = "Enter your password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "u_id"),
            inverseJoinColumns = @JoinColumn(name = "r_id")
    )
    private Set<Role> roles;

    public User() {
    }

    public User(@NotBlank(message = "Enter your name") String name, @NotBlank(message = "Enter your mobile") String mobile, @NotBlank(message = "Enter your email") String email, @NotNull(message = "Select your status") boolean status, @NotBlank(message = "Enter your username") String username, @NotBlank(message = "Enter your password") String password, Set<Role> roles) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.status = status;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User(User user) {
        this.name = user.name;
        this.mobile = user.mobile;
        this.email = user.email;
        this.status = user.status;
        this.username = user.username;
        this.password = user.password;
        this.roles = user.roles;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                status == user.status &&
                Objects.equals(name, user.name) &&
                Objects.equals(mobile, user.mobile) &&
                Objects.equals(email, user.email) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mobile, email, status, username, password, roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
