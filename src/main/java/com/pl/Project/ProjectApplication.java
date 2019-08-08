package com.pl.Project;

import com.pl.Project.dao.CommentDao;
import com.pl.Project.dao.PostDao;
import com.pl.Project.dao.UserDao;
import com.pl.Project.entity.BookGenre;
import com.pl.Project.entity.Comment;
import com.pl.Project.entity.Post;
import com.pl.Project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ProjectApplication {

	@Autowired
	UserDao userDao;
	@Autowired
	PostDao postDao;
	@Autowired
	CommentDao commentDao;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@PostConstruct
	public void init(){
		String actualDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());

		User user = new User("name", "surname", "uniqueLogin228", passwordEncoder.encode("password123"), 9, "normalUser");
		userDao.save(user);
		userDao.save(new User("name1","surname1","login1",passwordEncoder.encode("password123"),91,"normalUser"));
		userDao.save(new User("name2","surname2","login2",passwordEncoder.encode("password123"),92,"normalUser"));
		userDao.save(new User("admin","admin","admin",passwordEncoder.encode("admin"),69,"admin"));
		Post post = new Post("Harry Potter i Kamień Filozoficzny", "\t\n" +
				"Rowling J.K.", 29.99, "https://ecsmedia.pl/c/harry-potter-i-kamien-filozoficzny-tom-1-b-iext43794838.jpg", BookGenre.Fantasy);

		postDao.save(post);
		postDao.save(new Post("Czysty kod","\t\n" +
				"Robert C. Martin",62.99,"https://ecsmedia.pl/c/czysty-kod-podrecznik-dobrego-programisty-b-iext43256635.jpg", BookGenre.ScienceFiction));
		postDao.save(new Post("1984","George Orwell",20,"https://wordery.com/jackets/6e2f899f/1984-george-orwell-9781432839611.jpg", BookGenre.Classic));
		postDao.save(new Post("The Book Thief","Markus Zusak",12,"https://images-na.ssl-images-amazon.com/images/I/9123eop9gIL.jpg", BookGenre.FanFiction));

		List<Comment> list = new ArrayList<>();
		Comment comment = new Comment("text comment",actualDate, user.getLogin(), post.getId());
		Comment comment1 = new Comment("text comment1",actualDate, user.getLogin(), post.getId());
		Comment comment2 = new Comment("text comment2",actualDate, user.getLogin(), post.getId());
		commentDao.save(comment);
		commentDao.save(comment1);
		commentDao.save(comment2);
		list.add(comment);
		list.add(comment1);
		list.add(comment2);
		post.setCommentList(list);
		postDao.save(post);
	}

}
