package com.nttdata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.nttdata.domain.Person;

@Configuration
public class Config {
	
	@Bean(name = "personPrototype")
	@Scope("prototype")
	public Person personPrototype () {
		return Person.builder().name("Mariano Prototype").age(38).build();
	}
	
	@Bean(name = "personSingleton")
	//@Scope("singleton")
	public Person personSingleton () {
		return Person.builder().name("Mariano Singleton").age(38).build();
	}

}
