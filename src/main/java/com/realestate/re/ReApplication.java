package com.realestate.re;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ReApplication implements CommandLineRunner {
	
	Logger log = LoggerFactory.getLogger(ReApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ReApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.debug("Starting code");		
	}
}
