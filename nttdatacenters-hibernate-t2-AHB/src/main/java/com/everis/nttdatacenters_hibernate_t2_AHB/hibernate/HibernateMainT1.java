package com.everis.nttdatacenters_hibernate_t2_AHB.hibernate;



import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.everis.nttdatacenters_hibernate_t2_AHB.hibernate.persistence.Contract;
import com.everis.nttdatacenters_hibernate_t2_AHB.hibernate.persistence.Customer;
import com.everis.nttdatacenters_hibernate_t2_AHB.services.ContractManagementServiceI;
import com.everis.nttdatacenters_hibernate_t2_AHB.services.ContractManagementServiceImpl;
import com.everis.nttdatacenters_hibernate_t2_AHB.services.CustomerManagementServiceI;
import com.everis.nttdatacenters_hibernate_t2_AHB.services.CustomerManagementServiceImpl;



/**
 * Hibernate - Taller 2
 * 
 * Clase principal
 * 
 * @author fprietoa
 *
 */
public class HibernateMainT1 {

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Apertura de sesión.
		final Session session = HibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final CustomerManagementServiceI customerService = new CustomerManagementServiceImpl(session);
		final ContractManagementServiceI contractService = new ContractManagementServiceImpl(session);

		// Auditoría.
		final String updatesUser = "FPRIETOA";

		// Generación de clientes.
		final Customer customer1 = new Customer();
		customer1.setName("Maria");
		customer1.setLastName1("Perez");
		customer1.setLastName2("Gomez");
		customer1.setDni("29546235F");
		customer1.setUpdatedDate(new Date());
		customer1.setUpdatedUser(updatesUser);
		customerService.insertNewCustomer(customer1);

		final Customer customer2 = new Customer();
		customer2.setName("Agustin");
		customer2.setLastName1("Guerrero");
		customer2.setLastName2("Reyes");
		customer2.setDni("23594354D");
		customer2.setUpdatedDate(new Date());
		customer2.setUpdatedUser(updatesUser);
		customerService.insertNewCustomer(customer2);

		final Customer customer3 = new Customer();
		customer3.setName("Pablo");
		customer3.setLastName1("Alvarez");
		customer3.setLastName2("Diaz");
		customer3.setDni("24951163T");
		customer3.setUpdatedDate(new Date());
		customer3.setUpdatedUser(updatesUser);
		customerService.insertNewCustomer(customer3);

		final Customer customer4 = new Customer();
		customer4.setName("Alexei");
		customer4.setLastName1("Viadero");
		customer4.setLastName2("Sanchez");
		customer4.setDni("24935642L");
		customer4.setUpdatedDate(new Date());
		customer4.setUpdatedUser(updatesUser);
		customerService.insertNewCustomer(customer4);

		final Customer customer5 = new Customer();
		customer5.setName("Daniel");
		customer5.setLastName1("Vazquez");
		customer5.setLastName2("Muñoz");
		customer5.setDni("24412562P");
		customer5.setUpdatedDate(new Date());
		customer5.setUpdatedUser(updatesUser);
		customerService.insertNewCustomer(customer5);

		// Generación de contratos.
		final Contract contract1 = new Contract();
		contract1.setVigencyDate("24/03/2021");
		contract1.setCaducateDate("30/03/2022");
		contract1.setMonthPrice(1450);
		contract1.setUpdatedDate(new Date());
		contract1.setUpdatedUser(updatesUser);
		contract1.setCustomer(customer1);
		contractService.insertNewContract(contract1);

		final Contract contract2 = new Contract();
		contract2.setVigencyDate("25/03/2021");
		contract2.setCaducateDate("29/03/2022");
		contract2.setMonthPrice(1550);
		contract2.setUpdatedDate(new Date());
		contract2.setUpdatedUser(updatesUser);
		contract2.setCustomer(customer2);
		contractService.insertNewContract(contract2);

		final Contract contract3 = new Contract();
		contract3.setVigencyDate("20/03/2021");
		contract3.setCaducateDate("21/03/2022");
		contract3.setMonthPrice(1500);
		contract3.setUpdatedDate(new Date());
		contract3.setUpdatedUser(updatesUser);
		contract3.setCustomer(customer3);
		contractService.insertNewContract(contract3);

		final Contract contract4 = new Contract();
		contract4.setVigencyDate("24/03/2021");
		contract4.setCaducateDate("25/03/2022");
		contract4.setMonthPrice(1220);
		contract4.setUpdatedDate(new Date());
		contract4.setUpdatedUser(updatesUser);
		contract4.setCustomer(customer4);
		contractService.insertNewContract(contract4);

		final Contract contract5 = new Contract();
		contract5.setVigencyDate("28/03/2021");
		contract5.setCaducateDate("29/03/2021");
		contract5.setMonthPrice(1430);
		contract5.setUpdatedDate(new Date());
		contract5.setUpdatedUser(updatesUser);
		contract5.setCustomer(customer5);
		contractService.insertNewContract(contract5);

		// Cambio de nombre y actualización.
		customer1.setName("Pepe");
		customerService.updateCustomer(customer1);

		session.clear();

		// Consultas (JPA Criteria)

		// Buscar contrato por precio al mes.
		System.out.println("Id Contratos con precio mayor a 1500€: ");

		List<Contract> contrato = contractService.searchByPrice(1500.0f);

		for (final Contract contract : contrato) {
			System.out.println(contract.getContractId() + " | " + contract.getMonthPrice());
		}

		// Buscar nombre cliente por precio al mes.
		System.out.println("Clientes con nombre empezado por P y precio mayor a 1450€: ");

		List<Customer> clientes2 = customerService.searchByNameAndMonthPrice("P%", 1450D);

		for (final Customer customer : clientes2) {
			for (final Contract contract : customer.getContractsList()) {
				System.out.println(customer.getName() + " | " + contract.getMonthPrice());
			}
		}

		// Cerrar la sesión.
		session.close();

	}
}
