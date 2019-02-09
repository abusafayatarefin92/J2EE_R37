package com.arefin.webmvcthymeleaf.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    @Min(value = 18, message = "Hey, minimum age is 18")
    private byte age;

    @NotNull(message = "Enter an email address")
    @Column(unique = true)
    private String email;

    public Student() {
    }

    public Student(@NotNull @Size(min = 2, max = 30) String name, @Min(value = 18, message = "Hey, minimum age is 18") byte age, @NotNull @Email(message = "Enter a valid email address") String email) {
        this.name = name;
        this.age = age;
        this.email = email;
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

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
