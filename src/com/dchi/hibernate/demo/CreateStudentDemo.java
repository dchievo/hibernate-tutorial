package com.dchi.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dchi.hibernate.demo.entity.Customer;

public class CreateStudentDemo {

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
			Customer tempStudent = new Customer("David", "Chi", "dchi@dchi.com");
			// create student object
			session.beginTransaction();
			// start a transaction
			session.save(tempStudent);
			// save the student object
			session.getTransaction().commit();
			// commit transaction
		} finally {
			factory.close();
		}
		
		
	}

}
