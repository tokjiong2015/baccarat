package org.du.tech.dto;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;

public class HibernateTest5 {

	public static void main(String[] args) {
			
	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession(); 
	session.beginTransaction();
	
	UserDetails exampleUser = new UserDetails();
	exampleUser.setUserId(5);
	// primary key and null value out of consideration
	Example example = Example.create(exampleUser);
	
	
	//Criteria Object
	Criteria criteria = session.createCriteria(UserDetails.class)
			.setProjection(Projections.count("userId"))
			.addOrder(Order.desc("userId"));
	
	Criteria criteria1 = session.createCriteria(UserDetails.class).add(example);
	
	session.getTransaction().commit();
	session.close();
	
		
	}
 
}
