package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {

			int studentId=1;
			
			// start a transaction
			
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class,studentId);
			
			System.out.println("Updating Student");
			
			myStudent.setFirstName("Scooby");
			// commit transaction
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			System.out.println("Update email for all Students");
			
			session.createQuery("Update Student set email='rishabhahuja279@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}
}
