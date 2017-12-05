package com.sks.learn.learnspringbootudemy.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.sks.learn.learnspringbootudemy.model.HelloWorldBean;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/hello-world/sujit")
	public HelloWorldBean helloWorld() {
		return new HelloWorldBean("Gotcha...Hello Sujit");
	}

	@GetMapping("/hello-world/{name}")
	public HelloWorldBean helloWorld(@PathVariable String name) {
		return new HelloWorldBean("Hello World: " + name);
	}

	@GetMapping("/hello-world-i18n")
	public String helloWorldI18N(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}

}
