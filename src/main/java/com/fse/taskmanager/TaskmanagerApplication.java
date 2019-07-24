/*
 * 
 */
package com.fse.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The Class TaskmanagerApplication.
 */
@SpringBootApplication
@ComponentScan({"com.fse.taskmanager"})
public class TaskmanagerApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);

	}

}
