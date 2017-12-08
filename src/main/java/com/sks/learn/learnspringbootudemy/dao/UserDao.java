package com.sks.learn.learnspringbootudemy.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sks.learn.learnspringbootudemy.exception.AlreadyExistsException;
import com.sks.learn.learnspringbootudemy.model.UserBean;

@Component
public class UserDao {
	private static List<UserBean> userList = new ArrayList<UserBean>();
	private static int userCount = 2;
	static {
		userList.add(new UserBean(10001, "Ram", new Date(), null));
		userList.add(new UserBean(10002, "Shyam", new Date(), null));
	}

	public List<UserBean> findAll() {
		return userList;
	}

	public UserBean findOne(int id) {
		return userList.stream().filter(t -> t.getId() == id).findFirst().get();
	}

	public UserBean save(UserBean user) throws Exception {
		if (user.getId() == 0) {
			user.setId(++userCount);
		}
		if (userList.stream().filter(t -> t.getId() == user.getId()).findFirst().isPresent()) {
			throw new AlreadyExistsException("User [" + user.getId() + "] already exists");
		}
		userList.add(user);
		return user;
	}

	public void deleteUser(int id) {
		userList.remove(userList.stream().filter(t -> t.getId() == id).findFirst().get());
	}

}
