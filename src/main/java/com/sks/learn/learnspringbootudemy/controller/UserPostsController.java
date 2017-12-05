package com.sks.learn.learnspringbootudemy.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sks.learn.learnspringbootudemy.dao.UserPostsDao;
import com.sks.learn.learnspringbootudemy.model.UserPostsBean;

@RestController
public class UserPostsController {

	@Autowired
	private UserPostsDao usePostsDao;

	@GetMapping("/users/posts")
	public List<UserPostsBean> allPosts() {
		return null;
	}

	@GetMapping("/users/posts/{postId}")
	public UserPostsBean postsDetails(@PathVariable int postId) {
		return null;
	}

	@GetMapping("/users/{id}/posts")
	public List<UserPostsBean> userPosts() {
		return null;
	}

	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> save(UserPostsBean userPosts) {
		UserPostsBean createdUserPost = usePostsDao.save(userPosts);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdUserPost.getPostsId()).toUri();

		return ResponseEntity.created(location).build();

	}
}
