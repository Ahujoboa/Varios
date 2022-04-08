package com.everis.nttdatacenters_hibernate_t2_AHB.hibernate.persistence;



import java.util.List;

/**
 * Hibernate - Taller 2
 * 
 * DAO de tabla NTTDATA_TH1_CUSTOMER
 * 
 * @author fprietoa
 *
 */
public interface CustomerDaoI extends CommonDaoI<Customer> {

	/**
	 * Buscar un cliente por nombre.
	 * 
	 * @param nombre
	 */
	public List<Customer> searchByName(final String nombre);

	/**
	 * Obtiene clientes por nombre y salario.
	 * 
	 * @param namePattern
	 * @param budget
	 * @return List<NTTDataCustomer>
	 */
	public List<Customer> searchByNameAndMonthPrice(final String name, final Double budget);

}
