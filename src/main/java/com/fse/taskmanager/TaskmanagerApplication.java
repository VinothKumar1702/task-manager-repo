/*
 * 
 */
package com.fse.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * The Class TaskmanagerApplication.
 */
@SpringBootApplication
@ComponentScan({"com.fse.taskmanager"})
public class TaskmanagerApplication extends SpringBootServletInitializer{

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);

	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TaskmanagerApplication.class);
	}

}
