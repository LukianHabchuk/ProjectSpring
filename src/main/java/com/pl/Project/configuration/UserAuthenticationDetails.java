package com.pl.Project.configuration;

import com.pl.Project.dao.UserDao;
import com.pl.Project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
//public class UserAuthenticationDetails implements UserDetailsService {
//
//    @Autowired
//    private UserDao userDao;
//
//    @Autowired
//    public UserAuthenticationDetails(UserDao userDao){
//        this.userDao=userDao;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        User user = this.userDao.findByLogin(login);
//
//        if(user != null){
//            List<GrantedAuthority> grupa = new ArrayList<>();
//            grupa.add(new SimpleGrantedAuthority("normalUser"));
//            return new org.springframework.security.core.userdetails
//                    .User(user.getLogin(),user.getPassword(),
//                    true,true,true,true,grupa);
//        } else {
//            throw new UsernameNotFoundException("incorrect login or password");
//        }
//    }
//}
