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

import com.sks.learn.learnspringbootudemy.dao.UserPostsDao;
import com.sks.learn.learnspringbootudemy.exception.NotFoundException;
import com.sks.learn.learnspringbootudemy.model.UserPostsBean;

@RestController
public class UserPostsController {

	@Autowired
	private UserPostsDao usePostsDao;

	@GetMapping("/posts")
	public List<UserPostsBean> allPosts() {
		return usePostsDao.findAll();
	}

	@GetMapping("/posts/{postId}")
	public UserPostsBean postsDetails(@PathVariable int postId) {
		UserPostsBean post = null;
		try {
			post = usePostsDao.postDetails(postId);
		} catch (NoSuchElementException e) {
			throw new NotFoundException("Post with id-" + postId + ": NOT FOUND");
		}
		return post;
	}

	@GetMapping("/users/{userId}/posts")
	public List<UserPostsBean> userPosts(@PathVariable int userId) {
		return usePostsDao.findUserPosts(userId);
	}

	@PostMapping("/users/posts")
	public ResponseEntity<Object> save(@RequestBody UserPostsBean userPosts) {
		UserPostsBean createdUserPost = usePostsDao.save(userPosts);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdUserPost.getPostsId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
