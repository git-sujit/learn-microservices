package com.sks.learn.learnspringbootudemy.controller;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sks.learn.learnspringbootudemy.dao.UserDao;
import com.sks.learn.learnspringbootudemy.exception.NotFoundException;
import com.sks.learn.learnspringbootudemy.model.UserBean;
import com.sks.learn.learnspringbootudemy.util.LMSConstants;

@RestController
public class UserController {
	@Autowired
	private UserDao userDao;

	@GetMapping("/users")
	public MappingJacksonValue allUsers() {
		System.out.println(LMSConstants.CUSTOM_LOG_IDENTIFIER + "Getting all users, filtering post list");
		// Dynamic filtering
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "dob");
		FilterProvider fp = new SimpleFilterProvider().addFilter("UserBeanFilter", filter);
		List<UserBean> userList = userDao.findAll();

		MappingJacksonValue mjv = new MappingJacksonValue(userList);
		mjv.setFilters(fp);

		return mjv;
	}

	@GetMapping("/users/{id}")
	public Resource<UserBean> oneUser(@PathVariable int id) {
		System.out.println(LMSConstants.CUSTOM_LOG_IDENTIFIER + "Getting user details for: " + id);
		UserBean user = null;
		try {
			user = userDao.findOne(id);
		} catch (NoSuchElementException e) {
			throw new NotFoundException("User with id-" + id + ": NOT FOUND");
		}

		Resource<UserBean> resource = new Resource<UserBean>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).allUsers());

		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserBean user) throws Exception {
		System.out.println(LMSConstants.CUSTOM_LOG_IDENTIFIER + "Creating user");
		UserBean createdUser = userDao.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdUser.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		System.out.println(LMSConstants.CUSTOM_LOG_IDENTIFIER + "Deleting user: " + id);
		try {
			userDao.deleteUser(id);
		} catch (NoSuchElementException e) {
			throw new NotFoundException("User with id-" + id + ": NOT FOUND");
		}
	}
}
