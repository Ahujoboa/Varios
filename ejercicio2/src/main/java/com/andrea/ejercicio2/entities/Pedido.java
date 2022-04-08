package com.andrea.ejercicio2.entities;

import java.util.List;

public class Pedido {

	private Long id;
	private String nombre;
	private String direccion;
	private boolean peninsular;
	
	private List<Producto> productos;

	public Pedido() {

	}
	
	

	public Pedido(Long id, String nombre, String direccion, boolean peninsular, List<Producto> productos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.peninsular = peninsular;
		this.productos = productos;
	}







	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}





	public boolean isPeninsular() {
		return peninsular;
	}





	public void setPeninsular(boolean peninsular) {
		this.peninsular = peninsular;
	}

	

}
