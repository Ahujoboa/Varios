package com.everis.nttdatacenters_hibernate_t2_AHB.services;



import java.util.List;



/**
 * Hibernate - Taller 2
 * 
 * Interface del servicio de gestión de contratos.
 * 
 * @author fprietoa
 *
 */
public interface ContractManagementServiceI {

	/**
	 * Inserta un nuevo contrato.
	 * 
	 * @param newcontrato
	 */
	public void insertNewContract(final Contract newContract);

	/**
	 * Actualiza un contrato existente.
	 * 
	 * @param updatedContract
	 */
	public void updateContract(final Contract updatedContract);

	/**
	 * Elimina un contrato existente.
	 * 
	 * @param deletedContract
	 */
	public void deleteContract(final Contract deletedContract);

	/**
	 * Obtiene un contrato mediante su ID.
	 * 
	 * @param contractId
	 */
	public Contract searchById(final Long customerId);

	/**
	 * Obtiene todos los contratos existentes.
	 * 
	 * @return List<NTTDataContract>
	 */
	public List<Contract> searchAll();

	/**
	 * @param price
	 * @return
	 */
	public List<Contract> searchByPrice(final float price);

}
