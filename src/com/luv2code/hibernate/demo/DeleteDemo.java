package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			/*Instructor ins = new Instructor("Kiran","Bhat" ,"kbs71190@gmail.com" );
			
			InstructorDetail detail = new InstructorDetail("bhat@youtube.com","Video Gamer");*/

			Instructor ins = new Instructor("Anusha","Bhat" ,"anu71190@gmail.com" );
			InstructorDetail detail = new InstructorDetail("anubhat@youtube.com","Game Changer");
			
			ins.setInstructordetail(detail);
			session.beginTransaction();
			session.save(ins);
			session.getTransaction().commit();
			
		 } finally {
			session.close();
			factory.close();
		  }
		}
}
