package com.example.testTasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.testTasks")
public class TestTasksApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestTasksApplication.class, args);
	}

}
