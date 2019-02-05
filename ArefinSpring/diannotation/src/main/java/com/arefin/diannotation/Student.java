package com.arefin.diannotation;

public class Student {
    private int id;
    private String name;
    private  Address address;
    private Department department;

    public Student() {
    }

    public Student(int id, String name, Address address, Department department) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.department = department;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", department=" + department +
                '}';
    }
}
