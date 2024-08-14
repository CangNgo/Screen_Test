package com.cangngo.creanning_test.entity;

import com.cangngo.creanning_test.utils.JpaUtils;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Teacher")
public class Teacher {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "codeTeacher", unique = true)
    private String codeTeacher;
    private String lastName;
    private String firstName;
    private String image;
    private double salary;
    private Date firstDayOfWork;
    @ManyToOne
    @JoinColumn(name = "degreeId")
    private Degree degreeId;
    @ManyToOne
    @JoinColumn(name = "contractId")
    private Contract contractId;

    public Teacher() {
    }

    public Teacher(Long id, String codeTeacher, String lastName, String firstName, String image, double salary, Date firstDayOfWork, Degree degreeId, Contract contractId) {
        this.id = id;
        this.codeTeacher = codeTeacher;
        this.lastName = lastName;
        this.firstName = firstName;
        this.image = image;
        this.salary = salary;
        this.firstDayOfWork = firstDayOfWork;
        this.degreeId = degreeId;
        this.contractId = contractId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeTeacher() {
        return codeTeacher;
    }

    public void setCodeTeacher(String codeTeacher) {
        this.codeTeacher = codeTeacher;
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

    public Degree getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Degree degreeId) {
        this.degreeId = degreeId;
    }

    public Contract getContractId() {
        return contractId;
    }

    public void setContractId(Contract contractId) {
        this.contractId = contractId;
    }


}
