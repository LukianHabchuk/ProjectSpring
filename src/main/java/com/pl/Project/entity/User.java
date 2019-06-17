package com.pl.Project.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String surName;
    @NotNull
    private String login;
    @NotNull
    private String password;
    @NotNull
    private int age;

    public User() {
    }

    public User(String name, String surName, String login, String password, int age) {
        this.name = name;
        this.surName = surName;
        this.login = login;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
