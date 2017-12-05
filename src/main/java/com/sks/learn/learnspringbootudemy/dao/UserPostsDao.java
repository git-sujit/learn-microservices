package com.sks.learn.learnspringbootudemy.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sks.learn.learnspringbootudemy.model.UserPostsBean;

@Component
public class UserPostsDao {
	private static List<UserPostsBean> userPostList = new ArrayList<UserPostsBean>();

	@Autowired
	private UserDao userDao;

	public UserPostsBean save(UserPostsBean userPosts) {
		if (userDao.findAll().stream().filter(t -> t.getId() == userPosts.getUserId()).findFirst().isPresent()) {
			userPostList.add(userPosts);
			userDao.findAll().stream().filter(t -> t.getId() == userPosts.getUserId()).findFirst().get().getPostsList()
					.add(userPosts);
		}

		return userPosts;
	}

	public List<UserPostsBean> findAll() {
		return userPostList;
	}

	public UserPostsBean postDetails(int postsId) {
		return userPostList.stream().filter(t -> t.getPostsId() == postsId).findFirst().get();
	}

	public List<UserPostsBean> findUserPosts(int userId) {
		return userPostList.stream().filter(t -> t.getUserId() == userId).collect(Collectors.toList());
	}
}
