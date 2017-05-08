package com.dchi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dchi.hibernate.demo.entity.Customer;

public class PrimaryKeyDemo {

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
			System.out.println("Creating a new student object...");
			Customer tempStudent = new Customer("Jimmy", "Chi", "jchi@dchi.com");
			Customer tempStudent2 = new Customer("Helen", "Chi", "hchi@dchi.com");
			Customer tempStudent3 = new Customer("Linda", "Chi", "lchi@dchi.com");			
			// create student object
			session.beginTransaction();
			// start a transaction
			session.save(tempStudent);
			session.save(tempStudent2);
			session.save(tempStudent3);			
			// save the student object
			session.getTransaction().commit();
			// commit transaction
		} finally {
			factory.close();
		}
		
		
	}

}
