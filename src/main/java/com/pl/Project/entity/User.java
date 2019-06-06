package com.pl.Project.entity;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;
    private String name;
    private String surName;
    private String email;
    private String password;
    private int age;

    public User() {
    }

    public User(String name, String surName, String email, String password, int age) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
