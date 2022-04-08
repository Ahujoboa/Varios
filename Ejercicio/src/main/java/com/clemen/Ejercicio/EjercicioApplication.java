package com.clemen.Ejercicio;

import com.clemen.Ejercicio.entities.Edificio;
import com.clemen.Ejercicio.service.ServiceEdificio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EjercicioApplication implements CommandLineRunner {

	@Autowired
	ServiceEdificio serviceEdificio;

	/**
	 * Método principal
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(EjercicioApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//Código final aquí


		

		serviceEdificio.rellenarEdificio(serviceEdificio.getEdificio());


		serviceEdificio.listarInquilinos(serviceEdificio.getEdificio());


	}
}
