package com.pl.Project;

import com.pl.Project.dao.PostDao;
import com.pl.Project.dao.UserDao;
import com.pl.Project.entity.BookGenre;
import com.pl.Project.entity.Post;
import com.pl.Project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ProjectApplication {

	@Autowired
	UserDao userDao;
	@Autowired
	PostDao postDao;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@PostConstruct
	public void init(){
		postDao.save(new Post("Harry Potter i Kamień Filozoficzny","\t\n" +
				"Rowling J.K.",29.99,"https://ecsmedia.pl/c/harry-potter-i-kamien-filozoficzny-tom-1-b-iext43794838.jpg", BookGenre.Fantasy));
		postDao.save(new Post("Czysty kod","\t\n" +
				"Robert C. Martin",62.99,"https://ecsmedia.pl/c/czysty-kod-podrecznik-dobrego-programisty-b-iext43256635.jpg", BookGenre.ScienceFiction));
		postDao.save(new Post("1984","George Orwell",20,"https://wordery.com/jackets/6e2f899f/1984-george-orwell-9781432839611.jpg", BookGenre.Classic));
		postDao.save(new Post("The Book Thief","Markus Zusak",12,"https://images-na.ssl-images-amazon.com/images/I/9123eop9gIL.jpg", BookGenre.FanFiction));
		userDao.save(new User("name","surname","login",passwordEncoder.encode("password123"),9,"normalUser"));
		userDao.save(new User("name1","surname1","login1",passwordEncoder.encode("password123"),91,"normalUser"));
		userDao.save(new User("name2","surname2","login2",passwordEncoder.encode("password123"),92,"normalUser"));
		userDao.save(new User("admin","admin","admin",passwordEncoder.encode("admin"),69,"admin"));
	}

}
