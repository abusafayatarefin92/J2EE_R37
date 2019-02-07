package com.arefin.hellomvc.entity;

public class Student {
    private int id;
    private String stuname;
    private String location;

    public Student() {
    }

    public Student(int id, String stuname, String location) {
        this.id = id;
        this.stuname = stuname;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuname='" + stuname + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
