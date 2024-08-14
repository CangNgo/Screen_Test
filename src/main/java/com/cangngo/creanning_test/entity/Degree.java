package com.cangngo.creanning_test.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="Degree")
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String degreeName;

    public Degree() {
    }

    public Degree(Long id, String degreeName) {
        this.id = id;
        this.degreeName = degreeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }
}
