package com.everis.nttdatacenters_hibernate_t2_AHB.services;



import java.util.List;

import com.everis.nttdatacenters_hibernate_t2_AHB.hibernate.persistence.Customer;


/**
 * Hibernate - Taller 2
 * 
 * Interface del servicio de gestión de clientes.
 * 
 * @author fprietoa
 *
 */
public interface CustomerManagementServiceI {

	/**
	 * Inserta un nuevo cliente.
	 * 
	 * @param newCustomer
	 */
	public void insertNewCustomer(final Customer newCustomer);

	/**
	 * Actualiza un cliente existente.
	 * 
	 * @param updatedCustomer
	 */
	public void updateCustomer(final Customer updatedCustomer);

	/**
	 * Elimina un cliente existente.
	 * 
	 * @param deletedCustomer
	 */
	public void deleteCustomer(final Customer deletedCustomer);

	/**
	 * Obtiene un cliente mediante su ID.
	 * 
	 * @param customerId
	 */
	public Customer searchById(final Long customerId);

	/**
	 * Obtiene todos los clientes existentes.
	 * 
	 * @return List<NTTDataCustomer>
	 */
	public List<Customer> searchAll();

	/**
	 * Obtiene jugadores por nombre y salario.
	 * 
	 * @param namePattern
	 * @param budget
	 * @return List<EverisPlayer>
	 */
	public List<Customer> searchByNameAndMonthPrice(final String name, final Double budget);

}
