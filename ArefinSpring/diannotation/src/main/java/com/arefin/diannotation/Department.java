package com.arefin.diannotation;

public class Department {
    private String depName;

    public Department() {
    }

    public Department(String depName) {
        this.depName = depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depName='" + depName + '\'' +
                '}';
    }
}
