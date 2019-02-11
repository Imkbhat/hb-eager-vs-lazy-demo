package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemoApp {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			int Id =3;

			Query<Instructor> query = 
					session.createQuery(" SELECT i from Instructor i "
							+ " JOIN FETCH i.courses "
							+ " WHERE i.id=:theInstructorId",
					Instructor.class);
			System.out.println(query);
			//HQL
			query.setParameter("theInstructorId", Id);
			Instructor tempInst = query.getSingleResult();

			System.out.println(tempInst);

			session.getTransaction().commit();
			session.close();
			
			System.out.println(tempInst.getCourses());
		 } finally {
			
			factory.close();
		  }
		}
}
