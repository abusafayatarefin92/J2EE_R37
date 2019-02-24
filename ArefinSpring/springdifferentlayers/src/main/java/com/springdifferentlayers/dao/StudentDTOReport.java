package com.springdifferentlayers.dao;

import java.util.Objects;

//////////////////// Data transfer Object ////////////////////////
public class StudentDTOReport {
    private long noOfStudents;
    private String email;

    public StudentDTOReport() {
    }

    public StudentDTOReport(long noOfStudents, String email) {
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
        StudentDTOReport that = (StudentDTOReport) o;
        return noOfStudents == that.noOfStudents &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noOfStudents, email);
    }

    @Override
    public String toString() {
        return "StudentDTOReport{" +
                "noOfStudents=" + noOfStudents +
                ", email='" + email + '\'' +
                '}';
    }
}
