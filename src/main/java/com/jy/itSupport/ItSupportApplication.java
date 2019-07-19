package com.jy.itSupport;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ItSupportApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItSupportApplication.class, args);
	}

	@Bean
	public CommandLineRunner setup(TicketRepository repository){

		return (args) -> {

			repository.create(new Ticket(Long.MIN_VALUE, "App01", "no access", "started"));
			repository.create(new Ticket(Long.MIN_VALUE, "App02", "login failed", "started"));


		};


	}

}
