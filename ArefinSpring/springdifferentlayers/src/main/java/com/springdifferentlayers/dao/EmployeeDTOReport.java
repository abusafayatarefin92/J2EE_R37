package com.springdifferentlayers.dao;

import java.util.Objects;

public class EmployeeDTOReport {
    private long noOfStudents;
    private String email;

    public EmployeeDTOReport() {
    }

    public EmployeeDTOReport(long noOfStudents, String email) {
        this.noOfStudents = noOfStudents;
        this.email = email;
    }

    public long getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(long noOfStudents) {
        this.noOfStudents = noOfStudents;
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
        EmployeeDTOReport that = (EmployeeDTOReport) o;
        return noOfStudents == that.noOfStudents &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noOfStudents, email);
    }

    @Override
    public String toString() {
        return "EmployeeDTOReport{" +
                "noOfStudents=" + noOfStudents +
                ", email='" + email + '\'' +
                '}';
    }
}
