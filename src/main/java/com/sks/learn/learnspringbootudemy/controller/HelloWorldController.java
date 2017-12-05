package com.sks.learn.learnspringbootudemy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sks.learn.learnspringbootudemy.model.HelloWorldBean;

@RestController
public class HelloWorldController {
	

	@GetMapping("hello-world/sujit")
	public HelloWorldBean helloWorld() {
		return new HelloWorldBean("Gotcha...Hello Sujit");
	}
	@GetMapping("hello-world/{name}")
	public HelloWorldBean helloWorld(@PathVariable String name) {
		return new HelloWorldBean("Hello World: " + name);
	}
}
