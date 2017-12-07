package com.sks.learn.learnspringbootudemy.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonFilter("UserBeanFilter")
@ApiModel(description = "All details about user")
@Entity
public class UserBean {
	@Id
	@GeneratedValue
	private int id;

	@Size(min = 2, message = "Name should have at least 2 chars.")
	@ApiModelProperty(notes = "Name should have at least 2 chars")
	private String name;

	@Past(message = "Date of birth must be in past")
	@ApiModelProperty(notes = "Date of birth must be in past")
	private Date dob;

	@Transient
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
