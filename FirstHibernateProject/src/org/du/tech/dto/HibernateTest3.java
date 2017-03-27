package org.du.tech.dto;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

import org.hibernate.Query;

public class HibernateTest3 {

	public static void main(String[] args) {
			
	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession(); 
	session.beginTransaction();
	
	Query<UserDetails> query =  session.createQuery("from UserDetails where userId > ? and userName = ?");
	
	List<UserDetails> usersList = (List<UserDetails>)query.list();
	session.getTransaction().commit();
	session.close();
	
	for(UserDetails u : usersList)
	{
		System.out.println(u.getUserName());
	}
		
	}
 
}
