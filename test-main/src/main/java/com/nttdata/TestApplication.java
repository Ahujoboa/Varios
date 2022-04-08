package com.nttdata;

import com.nttdata.facade.Licencias;
import com.nttdata.facade.LicenciasFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nttdata.chain.Unit;
import com.nttdata.decorator.PersonDecorator;
import com.nttdata.domain.Person;
import com.nttdata.domain.PersonLombok;
import com.nttdata.proxy.PersonProxyClass1;
import com.nttdata.proxy.PersonProxyClass2;
import com.nttdata.singleton.PersonSingletonEager;
import com.nttdata.singleton.PersonSingletonEnum;
import com.nttdata.singleton.PersonSingletonLazy;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("=============================================================================");
		System.out.println("Prácticas con Singleton");
		System.out.println("=============================================================================");

		PersonSingletonLazy.getInstance().setName("Mariano");
		PersonSingletonLazy.getInstance().setAge(88);


		System.out.println(PersonSingletonLazy.getInstance().getName());
		System.out.println(PersonSingletonLazy.getInstance().getAge());

		PersonSingletonEager.INSTANCE.setName("segundo usuario");
		PersonSingletonEager.INSTANCE.setAge(44);

		System.out.println(PersonSingletonEager.INSTANCE.getName());
		System.out.println(PersonSingletonEager.INSTANCE.getAge());

		PersonSingletonEnum.INSTANCE.getPerson().setName("tercer usuario");
		PersonSingletonEnum.INSTANCE.getPerson().setAge(30);

		System.out.println(PersonSingletonEnum.INSTANCE.getPerson().getName());
		System.out.println(PersonSingletonEnum.INSTANCE.getPerson().getAge());


		System.out.println("=============================================================================");
		System.out.println("Prácticas con Prototype");
		System.out.println("=============================================================================");


		//Person personClone = PersonSingletonEnum.INSTANCE.getPerson().getClone();
		Person personClone = PersonSingletonLazy.getInstance().getClone();


		System.out.println("============================ objeto clonado ============================");
		System.out.println(personClone.getName());
		System.out.println(personClone.getAge());
		System.out.println("=============================================================================");

		PersonLombok person1 = new PersonLombok("Mariano",18);
		PersonLombok person2 = person1.builder().name("Laura").age(20).build();
		PersonLombok person3 = person2.toBuilder().age(10).build(); //toBuilder genera una copia (clona)

		System.out.println("============================ objeto modificado clonado ============================");
		System.out.println(person3.getName());
		System.out.println(person3.getAge());
		System.out.println("========================================================");

		System.out.println("=============================================================================");
		System.out.println("Prácticas con Builder");
		System.out.println("=============================================================================");

		Person person = Person.builder().age(18).name("Mariano ... mas adelante... decorador").build();
		System.out.println(person.getName());


		System.out.println("=============================================================================");
		System.out.println("Prácticas con Singleton/prototype");
		System.out.println("=============================================================================");

		String[] allBeanNames = context.getBeanDefinitionNames();
		System.out.println(" ================ beans en el context ================");
		for(String beanName : allBeanNames) {
			if(beanName.equals("personPrototype") || beanName.equals("personSingleton")){
				System.out.println(beanName);
			}
		}
		
		System.out.println("Prototype Object name ->" + ((Person)context.getBean("personPrototype")).getName());
		System.out.println("Prototype Object ID ->" + context.getBean("personPrototype").hashCode());
		System.out.println("Prototype Object ID ->" + context.getBean("personPrototype").hashCode());
		System.out.println("Prototype Object ID ->" + context.getBean("personPrototype").hashCode());

		System.out.println("Singleton Object name ->" + ((Person)context.getBean("personSingleton")).getName());
		System.out.println("Singleton Object ID ->" + context.getBean("personSingleton").hashCode());
		System.out.println("Singleton Object ID ->" + context.getBean("personSingleton").hashCode());
		System.out.println("Singleton Object ID ->" + context.getBean("personSingleton").hashCode());
		
		System.out.println("=============================================================================");
		System.out.println("Prácticas con Decorador");
		System.out.println("=============================================================================");
		
		PersonDecorator personDecorator = new PersonDecorator(person);
		System.out.println(personDecorator.getName());
		
		System.out.println("=============================================================================");
		System.out.println("Prácticas con Proxy");
		System.out.println("=============================================================================");


		System.out.println("=============================================================================");
		System.out.println("Prácticas Facade");
		System.out.println("=============================================================================");

		System.out.println("**** Sin Facade: ");
		Licencias licenciaA1 = new Licencias();
		licenciaA1.setDni("11111111");
		licenciaA1.setCategoria("A");
		licenciaA1.setTipo("I");
		System.out.println("      " + licenciaA1.verDetalle());

		System.out.println("**** Con Facade: ");
		LicenciasFacade a1Facade = new LicenciasFacade("2222222");
		System.out.println("      " +a1Facade.verDetalle());

		System.out.println("=============================================================================");
		System.out.println("Prácticas con Proxy");
		System.out.println("=============================================================================");




		PersonProxyClass1 personProxyClass1 = new PersonProxyClass1(person);
		PersonProxyClass2 personProxyClass2 = new PersonProxyClass2(person);
		
		personProxyClass1.operacion();
		personProxyClass2.operacion();
		
		System.out.println("=============================================================================");
		System.out.println("Prácticas con Cadena de Mando");
		System.out.println("=============================================================================");
		
		Unit soldier = Unit.builder().name("soldier").build();
		Unit sergeant = Unit.builder().name("sergeant").subordinate(soldier).build();
		Unit captain = Unit.builder().name("captain").subordinate(sergeant).build();
		
		captain.executeCommand("Make a coffee");
		
		
	}

}
