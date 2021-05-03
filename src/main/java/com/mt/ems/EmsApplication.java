package com.mt.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mt.ems.entity.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class EmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
		//log.info("message");
		
		log.info("spring boot app");

	
	}

}
