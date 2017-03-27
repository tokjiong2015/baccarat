package org.du.tech.dto;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

import org.hibernate.Query;

public class HibernateTest4 {

	public static void main(String[] args) {
			
	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession(); 
	session.beginTransaction();
	
	//not table name, object name
	Query<UserDetails> query =  session.createQuery("from UserDetails");
	//Query<UserDetails> query =  session.createQuery("select new map(userId,userName) from UserDetails");
	query.setFirstResult(5);
	query.setMaxResults(4);
	List<UserDetails> usersList = (List<UserDetails>)query.list();
	session.getTransaction().commit();
	session.close();
	
	System.out.println("Here begin" +usersList.size());
	for(UserDetails u : usersList)
	{
		System.out.println(u.getUserName());
	}
		
	}
 
}
