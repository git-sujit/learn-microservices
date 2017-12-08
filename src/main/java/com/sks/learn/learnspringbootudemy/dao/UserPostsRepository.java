package com.sks.learn.learnspringbootudemy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sks.learn.learnspringbootudemy.model.UserPostsBean;

@Repository
public interface UserPostsRepository extends JpaRepository<UserPostsBean, Integer> {

}
