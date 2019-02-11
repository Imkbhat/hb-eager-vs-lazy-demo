package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			Instructor instructor = session.get(Instructor.class, Id);
			
			Course course = new Course("Mathematics");
			Course course1 = new Course("Science");
		
			instructor.addCourse(course);
			instructor.addCourse(course1);
			
			session.save(course);
			session.save(course1);
			
			session.getTransaction().commit();
		 } finally {
			session.close();
			factory.close();
		  }
		}
}
