package com.pl.Project.dao;

import com.pl.Project.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Long> {
}
