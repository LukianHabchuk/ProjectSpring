package com.pl.Project.service;

import com.pl.Project.dao.UserDao;
import com.pl.Project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getUserList(){
        List<User> users = new ArrayList<>();
        this.userDao.findAll().forEach(users::add);
        return users;
    }

    public User getUser(Long id){
        return this.userDao.findById(id).get();
    }

    public void addUser(User user){
        this.userDao.save(user);
    }

    public void updateUser(Long id, String name, String surName, String email, int age){
        User user = this.userDao.findById(id).get();
        user.setName(name);
        user.setSurName(surName);
        user.setEmail(email);
        user.setAge(age);
        this.userDao.save(user);
    }

    public void updatePassword(Long id, String password){
        User user = this.userDao.findById(id).get();
        user.setPassword(password);
        this.userDao.save(user);
    }

    public void deleteUser(Long id){
        this.userDao.deleteById(id);
    }

}
