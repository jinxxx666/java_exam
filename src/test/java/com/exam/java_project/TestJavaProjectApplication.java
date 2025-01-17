package com.exam.java_project;

import org.springframework.boot.SpringApplication;

public class TestJavaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.from(JavaProjectApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
