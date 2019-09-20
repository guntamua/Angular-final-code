package com.cvs.rules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration 

//@SpringBootApplication(scanBasePackages = { "java/com/cvs/model", "java/com/cvs/repo","java/com/cvs/controller"})
@SpringBootApplication
public class rulesEngineApplication {

	String home() {
		return "Hello World!";
	}

	public static void main(String[] args) {
			SpringApplication.run(rulesEngineApplication.class);
		}

}

