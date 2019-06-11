package com.pl.Project.dao;

import com.pl.Project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    public User findByEmail(String name);
}
