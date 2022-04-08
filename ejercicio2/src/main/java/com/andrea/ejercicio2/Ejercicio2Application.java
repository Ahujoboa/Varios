package com.andrea.ejercicio2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andrea.ejercicio2.service.IService;
import com.andrea.ejercicio2.service.ServicePeninsularImpl;

@SpringBootApplication
public class Ejercicio2Application {
	@Autowired
	@Qualifier("insular")
	IService serviceInsular;
	
	@Autowired
	@Qualifier("peninsular")
	IService servicePeninsular;

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio2Application.class, args);
		
		//TODO: crear productos
		//TODO crear 2 pedidos
		//TODO distinguir pedido y calcular IVA

	}

}
