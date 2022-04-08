package com.everis.nttdatacenters_hibernate_t2_AHB.hibernate.persistence;



import java.util.List;

/**
 * Hibernate - Taller 2
 * 
 * DAO de tabla NTTDATA_TH1_CONTRACT
 * 
 * @author fprieto
 *
 */
public interface ContractDaoI extends CommonDaoI<Contract> {

	/**
	 * Obtiene contratos por salario.
	 * 
	 * @param monthPrice
	 * @return List<NTTDataContract>
	 */
	public List<Contract> searchByMonthPrice(final float monthPrice);

}
