package com.clemen.mvc;


import com.clemen.mvc.entity.Cliente;
import com.clemen.mvc.service.impl.ClienteServiceImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@EnableEurekaClient
@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext context  = SpringApplication.run(Application.class, args);
		ClienteServiceImpl service = context.getBean(ClienteServiceImpl.class);

		Cliente cliente = new Cliente("Antonio", "Rodriguez", LocalDate.now(),"12345678M");
		service.crearCliente(cliente);
	}


}
