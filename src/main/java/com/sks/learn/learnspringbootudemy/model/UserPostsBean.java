package com.sks.learn.learnspringbootudemy.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserPostsBean {
	@Id
	@GeneratedValue
	private int postsId;

	private String postsMessage;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private UserBean user;

	public UserPostsBean(UserBean user, int postsId, String postsMessage) {
		super();
		this.postsId = postsId;
		this.postsMessage = postsMessage;
		this.user = user;
	}

	public UserPostsBean() {
		super();
	}

	public int getPostsId() {
		return postsId;
	}

	public void setPostsId(int postsId) {
		this.postsId = postsId;
	}

	public String getPostsMessage() {
		return postsMessage;
	}

	public void setPostsMessage(String postsMessage) {
		this.postsMessage = postsMessage;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

}
