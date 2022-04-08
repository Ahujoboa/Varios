package com.everis.nttdatacenters_hibernate_t2_AHB.services;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NTTDataCustomer;
import com.nttdata.hibernate.persistence.NTTDataCustomerDaoI;
import com.nttdata.hibernate.persistence.NTTDataCustomerDaoImpl;

/**
 * Hibernate - Taller 2
 * 
 * Implementación del servicio de gestión de clientes.
 * 
 * @author fprietoa
 *
 */
public class CustomerManagementServiceImpl implements CustomerManagementServiceI {

	/** DAO: NTTDATA_TH1_CUSTOMER */
	private CustomerDaoI customerDao;

	/**
	 * Método constructor.
	 */
	public CustomerManagementServiceImpl(final Session session) {
		this.customerDao = new CustomerDaoImpl(session);
	}

	@Override
	public void insertNewCustomer(final Customer newCustomer) {

		// Verificación de nulidad e inexistencia.
		if (newCustomer != null && newCustomer.getCustomerId() == null) {

			// Insercción del nuevo jugador.
			customerDao.insert(newCustomer);
		}

	}

	@Override
	public void updateCustomer(final Customer updatedCustomer) {

		// Verificación de nulidad y existencia.
		if (updatedCustomer != null && updatedCustomer.getCustomerId() != null) {

			// Actualización del jugador.
			customerDao.update(updatedCustomer);
		}

	}

	@Override
	public void deleteCustomer(final Customer deletedCustomer) {

		// Verificación de nulidad y existencia.
		if (deletedCustomer != null && deletedCustomer.getCustomerId() != null) {

			// Eliminación del jugador.
			customerDao.delete(deletedCustomer);
		}

	}

	@Override
	public Customer searchById(final Long customerId) {

		// Resultado.
		Customer customer = null;

		// Verificación de nulidad.
		if (customerId != null) {

			// Obtención del jugador por ID.
			customer = (Customer) customerDao.searchById(customerId);
		}

		return customer;
	}

	@Override
	public List<Customer> searchAll() {

		// Resultado.
		List<Customer> customersList = new ArrayList<Customer>();

		// Obtención de jugadores.
		customersList = customerDao.searchAll();

		return customersList;
	}

	@Override
	public List<Customer> searchByNameAndMonthPrice(final String name, final Double budget) {

		// Resultado
		List<Customer> customerList = new ArrayList<Customer>();

		// Obetncion de los cliente
		customerList = customerDao.searchByNameAndMonthPrice(name, budget);

		return customerList;
	}

}
