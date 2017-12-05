package com.sks.learn.learnspringbootudemy.model;

public class UserPostsBean {
	private int userId;
	private int postsId;
	private String postsMessage;

	public UserPostsBean(int userId, int postsId, String postsMessage) {
		super();
		this.userId = userId;
		this.postsId = postsId;
		this.postsMessage = postsMessage;
	}

	public UserPostsBean() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

}
