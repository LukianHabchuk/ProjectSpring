package com.pl.Project.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;
    private String name;
    private String surName;
    private String login;
    private String password;
    private int age;
    @ManyToMany
    private Set<Post> cart;
    private String role;

    public User() {
    }

    public User(String name, String surName, String login, String password, int age, Set<Post> cart) {
        this.name = name;
        this.surName = surName;
        this.login = login;
        this.password = password;
        this.age = age;
        this.cart = cart;
    }

    public User(String name, String surName, String login, String password, int age) {
        this.name = name;
        this.surName = surName;
        this.login = login;
        this.password = password;
        this.age = age;
    }

    public User(String name, String surName, String login, String password, int age,String role) {
        this.name = name;
        this.surName = surName;
        this.login = login;
        this.password = password;
        this.age = age;
        this.role=role;
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

    public Set<Post> getCart() {
        return cart;
    }

    public void setCart(Set<Post> cart) {
        this.cart = cart;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
