package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			int theId = 2;
			Instructor ins = session.get(Instructor.class, theId);
			
			System.out.println(ins);
			
			if (null != ins) {
				System.out.println("Deleteing "+ins);
				session.delete(ins);
			}

			session.getTransaction().commit();
		 } finally {
			session.close();
			factory.close();
		  }
		}
}
