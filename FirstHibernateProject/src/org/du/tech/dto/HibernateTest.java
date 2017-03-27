package org.du.tech.dto;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {

	UserDetails user= new UserDetails();
	user.setUserName("Sixth User");
	
	UserDetails user2= new UserDetails();
	user2.setUserName("Seventh User");
	
	Vehicle v = new Vehicle();
	v.setVehicleName("Car");
	
	Vehicle v2 = new Vehicle();
	v2.setVehicleName("Train");
	
	TwoWheeler t2 = new TwoWheeler();
	FourWheeler t4= new FourWheeler();
	t2.setSteeringHandle("T2");
	t4.setSteeringWheel("T4");
	
	
	//user.setDesc("First Desc");
	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession(); 
	session.beginTransaction();
	//session.persist(user);
	session.save(v);
	session.save(t2);
	session.save(t4);
	session.getTransaction().commit();
	session.close();
	/*
	user=null;
	session = sessionFactory.openSession();
	session.beginTransaction();
	user=(UserDetails)session.get(UserDetails.class, 4);
	System.out.println(user.getUserName());	
	*/
	}
 
}
