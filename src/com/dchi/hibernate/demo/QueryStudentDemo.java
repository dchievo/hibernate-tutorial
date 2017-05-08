package com.dchi.hibernate.demo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dchi.hibernate.demo.entity.Customer;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use session object to save Java object
			// start transaction
			System.out.println("Beginning...");
			session.beginTransaction();

			// query customers
			@SuppressWarnings("unchecked")
			List<Customer> theCust = session.createQuery("from Customer c "
					+ "where c.lastName = 'Chi'"
					+ "and c.firstName = 'David'"
					+ "and c.id = '8'").list();
						
			// display customers
			for (Customer theC : theCust) {
				System.out.println(theC);
			}
			
			//theCust = session.createQuery("from Customer c where c.id = 9").list();
			//theCust = session.delete("from Customer c where c.id = 9");
			System.out.println(theCust);
			// commit transaction		
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
		
		
	}

}
