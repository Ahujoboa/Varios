package com.andrea.ejercicio2.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.andrea.ejercicio2.entities.Pedido;
import com.andrea.ejercicio2.entities.Producto;

@Service
@Qualifier("insular")
public class ServiceInsularImpl implements IService {

	@Override
	public Double calcularIva(Pedido pedido) {
		Double precioTotal = 0.0;

		for (Producto producto : pedido.getProductos()) {
			precioTotal += producto.getPvd();
		}
		return precioTotal * 1.04;

	}

}
