package com.sv.techteachers.configuration;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@EnableAutoConfiguration
@ComponentScan({"com.sv.techteachers.demo","com.sv.tokengenerator","com.sv.techteachers.gcm", "com.techteachers.login","com.techteachers.course"}) 
public class Application {
	

	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Exception handleException(Exception e) {
	    return e;
	}
	
	public static void main(String[] args) throws Exception {
		   SpringApplication.run(Application.class, args);
		 }
}
