package org.du.tech.dto;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CacheMain {

	public static void main(String[] args) {
			
	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession(); 
	session.beginTransaction();
	
	UserDetails user = (UserDetails)session.get(UserDetails.class, 1);
	
	UserDetails user2 = (UserDetails)session.get(UserDetails.class, 1); 
	
	session.getTransaction().commit();
	session.close();
		
	
	
	Session session2 = sessionFactory.openSession(); 
	session2.beginTransaction();
	
	user2.setUserName("2 up");
	session2.update(user2);
	
	session2.getTransaction().commit();
	session2.close();
	
	}
 
}
