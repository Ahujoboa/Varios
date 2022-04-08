package com.everis.ProyectoPruebaHibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
   	 //builder para poder construir el SessionFactory
   	 StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
   	 
   	 //construimos SessionFactory
   	 SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
       
   	 //abrir sesión
   	 Session session = sf.openSession();
   	 
   	 User user = new User();
   	 user.setId(1);
   	 user.setUserName("Andrea");
   	 user.setUserMesagge("Hello world from Andrea");
   	 
   	 User user2 = new User();
   	 user2.setId(2);
   	 user2.setUserName("Inés");
   	 user2.setUserMesagge("Hello world from Inés");
   	 
   	 session.getTransaction().begin();
   	 
   	 session.save(user);
   	 session.save(user2);
   	 
   	 
   	 session.getTransaction().commit();
   	 session.close();
   	 sf.close();
    }
}

