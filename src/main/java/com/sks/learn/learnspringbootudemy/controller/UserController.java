package com.sks.learn.learnspringbootudemy.controller;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sks.learn.learnspringbootudemy.dao.UserDao;
import com.sks.learn.learnspringbootudemy.exception.UserNotFoundException;
import com.sks.learn.learnspringbootudemy.model.UserBean;

@RestController
public class UserController {
	@Autowired
	private UserDao userDao;

	@GetMapping("/users")
	public List<UserBean> allUsers() {
		return userDao.findAll();
	}

	@GetMapping("/users/{id}")
	public UserBean oneUsers(@PathVariable int id) {
		UserBean user = null;
		try {
			user = userDao.findOne(id);
		} catch (NoSuchElementException e) {
			throw new UserNotFoundException("User with id-" + id + ": NOT FOUND");
		}
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody UserBean user) throws Exception {
		UserBean createdUser = userDao.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdUser.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
}
