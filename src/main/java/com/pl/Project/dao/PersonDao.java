package com.pl.Project.dao;

import com.pl.Project.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person, Long> {
}
