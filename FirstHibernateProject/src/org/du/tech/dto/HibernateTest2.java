package org.du.tech.dto;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest2 {

	public static void main(String[] args) {
			
	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession(); 
	session.beginTransaction();
	
	/*
	for(int i=0;i<10;i++){
		UserDetails user = new UserDetails();
		user.setUserName("User "+i);
		session.save(user);
	}
	*/
	
	
	UserDetails user=(UserDetails)session.get(UserDetails.class,5);
	
	/*
	System.out.println("User name fetched is : "+user.getUserName());
	user.setUserName("duhong update");
	session.update(user);
	
	//session.delete(user);
	*/
	session.getTransaction().commit();
	session.close();
	
	//also can read though close session
	//System.out.println("User name fetched is (2nd) : "+user.getUserName());

	user.setUserName("change");
	session = sessionFactory.openSession(); 
	session.beginTransaction();
	session.update(user);
	session.getTransaction().commit();
	session.close();
	}
 
}
