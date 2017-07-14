package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			System.out.println("Create new Student object");
			Student tempStudent1 = new Student("Paul1", "Wall1", "paul@luv2code.com1");
			Student tempStudent2 = new Student("Paul2", "Wall2", "paul@luv2code.com2");
			Student tempStudent3 = new Student("Paul3", "Wall3", "paul@luv2code.com3");
			

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}

}
