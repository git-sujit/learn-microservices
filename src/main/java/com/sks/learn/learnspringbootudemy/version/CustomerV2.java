package com.sks.learn.learnspringbootudemy.version;

public class CustomerV2 {
	private String firstName;
	private String lastName;

	public CustomerV2() {
		super();
	}

	public CustomerV2(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
