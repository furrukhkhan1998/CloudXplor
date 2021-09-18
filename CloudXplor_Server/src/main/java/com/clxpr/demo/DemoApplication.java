package com.clxpr.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.clxpr.demo"})
@EntityScan(basePackages= {"com.clxpr.demo.model"})
@ComponentScan(basePackages= {"com.clxpr.demo.repo"})
@ComponentScan(basePackages= {"com.clxpr.demo.service"})
@ComponentScan(basePackages= {"com.clxpr.demo.controller"})
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext springContext = SpringApplication.run(DemoApplication.class, args); // starts application 
		LinuxListener l; // listener for receiving resource monitoring data
		try {
			l = new LinuxListener(springContext);
			Thread thread= new Thread(l);
			thread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
