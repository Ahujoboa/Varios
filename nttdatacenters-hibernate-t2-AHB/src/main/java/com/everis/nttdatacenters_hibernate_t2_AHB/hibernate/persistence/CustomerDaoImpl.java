package com.everis.nttdatacenters_hibernate_t2_AHB.hibernate.persistence;



import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * Hibernate - Taller 2
 * 
 * DAO de tabla NTTDATA_TH1_CUSTOMER
 * 
 * @author fprietoa
 *
 */
public class CustomerDaoImpl extends CommonDaoImpl<Customer> implements CustomerDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public CustomerDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> searchByName(final String nombre) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza jugadores en función del nombre.
		final List<Customer> customerList = session
		        .createQuery("FROM " + Customer.class.getName() + " WHERE " + "NAME LIKE " + "'" + nombre + "'").list();

		return customerList;

	}

	@Override
	public List<Customer> searchByNameAndMonthPrice(final String name, final Double budget) {

		// Consulta.
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<Customer> cquery = cb.createQuery(Customer.class);
		final Root<Customer> rootP = cquery.from(Customer.class);
		final Join<Customer, Contract> pJoinT = rootP.join("contractsList");

		// Where.
		final Predicate pr1 = cb.like(pJoinT.getParent().<String> get("name"), name);
		final Predicate pr2 = cb.ge(pJoinT.<Double> get("monthPrice"), budget);

		// Consulta.
		cquery.select(rootP).where(pr1, pr2);

		// Ordenación descendente (mayor a menor) de presupuestos.
		cquery.orderBy(cb.desc(pJoinT.get("monthPrice")));

		// Ejecución de consulta.
		final List<Customer> results = session.createQuery(cquery).getResultList();

		return results;
	}

}
