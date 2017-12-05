package com.sks.learn.learnspringbootudemy;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.sks.learn.learnspringbootudemy.util.LMSConstants;

@SpringBootApplication
public class LearnSpringbootUdemyApplication {

	public static void main(String[] args) {
		System.out.println(LMSConstants.CUSTOM_LOG_IDENTIFIER + "Launching spring boot application");
		SpringApplication.run(LearnSpringbootUdemyApplication.class, args);
	}

	/**
	 * To setup default locale
	 * 
	 * @return
	 */
	@Bean
	public LocaleResolver localeResolver() {
		System.out.println(LMSConstants.CUSTOM_LOG_IDENTIFIER + "Setting default locale");
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	/**
	 * To setup message source base file name messageSource is defined in
	 * HelloWorldController Make sure names are same
	 * 
	 * @return
	 */
	@Bean(name = "messageSource")
	public ResourceBundleMessageSource bundleMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		System.out.println(LMSConstants.CUSTOM_LOG_IDENTIFIER + "Print message(English) : "
				+ messageSource.getMessage("good.morning.message", null, Locale.US));
		System.out.println(LMSConstants.CUSTOM_LOG_IDENTIFIER + "Print message(French) : "
				+ messageSource.getMessage("good.morning.message", null, Locale.FRANCE));
		System.out.println(LMSConstants.CUSTOM_LOG_IDENTIFIER + "Print message(Default) : "
				+ messageSource.getMessage("good.morning.message", null, null));
		return messageSource;

	}
}
