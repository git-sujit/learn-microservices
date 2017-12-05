package com.sks.learn.learnspringbootudemy.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sks.learn.learnspringbootudemy.model.UserPostsBean;

@Component
public class UserPostsDao {
	private List<UserPostsBean> userPostList = new ArrayList<UserPostsBean>();

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
	
	public List<UserPostsBean> findUserPosts(int userId) {
		return null;//userPostList.stream().allMatch(t -> t.getUserId() == userId);
	}
}
