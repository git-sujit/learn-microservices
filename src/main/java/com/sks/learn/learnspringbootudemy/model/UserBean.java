package com.sks.learn.learnspringbootudemy.model;

import java.util.Date;
import java.util.List;

public class UserBean {
	private int id;
	private String name;
	private Date dob;
	private List<UserPostsBean> postsList;

	public UserBean() {
	}

	public UserBean(int id, String name, Date dob, List<UserPostsBean> postsList) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.postsList = postsList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<UserPostsBean> getPostsList() {
		return postsList;
	}

	public void setPostsList(List<UserPostsBean> postsList) {
		this.postsList = postsList;
	}

}
