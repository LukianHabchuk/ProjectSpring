package com.pl.Project.controller;

import com.pl.Project.dao.UserDao;
import com.pl.Project.entity.User;
import com.pl.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = {"/login","/login.html"})
    public String login() {
        return "login";
    }

    @GetMapping(value = {"/login?succes","/login.html?succes"})
    public String loginSucces() {
        return "main";
    }

    @GetMapping({"/registration","registration.html"})
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping({"/registration","registration.html"})
    public String registration(@ModelAttribute(value = "userForm") User user, Model m) {
        if(user==null || user.getAge()==0) return "/registration";
        List<User> users = userService.getUserList();
        for(User u : users){
            if(u.getLogin().equals(user.getLogin())) return "redirect:/main.html";
    }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        m.addAttribute("userForm",user);
        this.userService.addUser(user);
        return "redirect:/login";
    }

}
