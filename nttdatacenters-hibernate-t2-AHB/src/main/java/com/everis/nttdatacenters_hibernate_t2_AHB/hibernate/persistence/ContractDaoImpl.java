package com.everis.nttdatacenters_hibernate_t2_AHB.hibernate.persistence;



import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * Hibernate - Taller 2
 * 
 * DAO de tabla NTTDATA_TH1_CONTRACT
 * 
 * @author fprieto
 *
 */
public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public ContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<Contract> searchByMonthPrice(final float monthPrice) {

		// Consulta.
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<Contract> cquery = cb.createQuery(Contract.class);
		final Root<Contract> rootP = cquery.from(Contract.class);

		// WHERE.
		final Predicate pr1 = cb.gt(rootP.<Double> get("monthPrice"), monthPrice);

		// Consulta.
		cquery.select(rootP).where(pr1);

		// Ejecución de conslta.
		final List<Contract> results = session.createQuery(cquery).getResultList();

		return results;

	}

}
