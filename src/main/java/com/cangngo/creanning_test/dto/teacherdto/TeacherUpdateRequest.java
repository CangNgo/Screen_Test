package com.cangngo.creanning_test.dto.teacherdto;

import java.sql.Date;

public class TeacherUpdateRequest {
    private String lastName;
    private String firstName;
    private String image;
    private double salary;
    private Date firstDayOfWork;
    private String degree;
    private String contract;

    public TeacherUpdateRequest() {
    }

    public TeacherUpdateRequest(String lastName, String firstName, String image, double salary, Date firstDayOfWork, String degree, String contract) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.image = image;
        this.salary = salary;
        this.firstDayOfWork = firstDayOfWork;
        this.degree = degree;
        this.contract = contract;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getFirstDayOfWork() {
        return firstDayOfWork;
    }

    public void setFirstDayOfWork(Date firstDayOfWork) {
        this.firstDayOfWork = firstDayOfWork;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
}
