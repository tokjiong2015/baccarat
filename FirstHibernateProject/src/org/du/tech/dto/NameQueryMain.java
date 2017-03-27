package org.du.tech.dto;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

import org.hibernate.Query;

public class NameQueryMain {

	public static void main(String[] args) {
			
	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession(); 
	session.beginTransaction();
	
	Query query = session.getNamedQuery("UserDetails.byId");
	query.setInteger(0, 2);
	
	List<UserDetails> usersList = (List<UserDetails>)query.list();
	session.getTransaction().commit();
	session.close();
	
	for(UserDetails u : usersList)
	{
		System.out.println(u.getUserName());
	}
		
	}
 
}
