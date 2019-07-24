package com.pl.Project.service;

import com.pl.Project.dao.UserDao;
import com.pl.Project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    PasswordEncoder passwordEncoder;

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

    public void updateUser(Long id, String name, String surName, String login, String password, int age, Model model){
        User user = userDao.findById(id).get();
        if(!name.isEmpty() && name !=null) user.setName(name);
        if(!surName.isEmpty() && surName!=null) user.setSurName(surName);
        if(!login.isEmpty() && login!=null) user.setLogin(login);
        if(!password.isEmpty() && password!=null) user.setPassword(passwordEncoder.encode(password));
        if(!String.valueOf(age).isEmpty() && age!=0 && String.valueOf(age)!=null) user.setAge(age);
        this.userDao.save(user);
        model.addAttribute("user",user);
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
