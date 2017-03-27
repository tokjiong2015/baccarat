package du.tech.baccarat.domain;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateTestCascadeUspfPlayer {

	public static void main(String[] args) {
		
		Uspf up1 = new Uspf();
		up1.setUserName("du1");
		up1.setUserEmail("89288375@qq.com");
		up1.setPassWord("u1");
	
		
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		Player p4 = new Player();
		p4.setPlayerName("p4");
		p4.setInitialFund(new BigDecimal(40));
		p3.setPlayerName("p3");
		p3.setInitialFund(new BigDecimal(30));
		p2.setPlayerName("p2");
		p2.setInitialFund(new BigDecimal(20));
		p1.setPlayerName("p1");
		p1.setInitialFund(new BigDecimal(10));
		
		
		up1.getPlayer().add(p1);
		up1.getPlayer().add(p2);
		up1.getPlayer().add(p3);
		
		p1.setUspf(up1);
		p2.setUspf(up1);
		p3.setUspf(up1);
		
		up1.getPlayer().remove(p1);
		up1.getPlayer().remove(p2);
		up1.getPlayer().remove(p3);
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession(); 
		session.beginTransaction();
		session.persist(up1);
		session.delete(up1);
		session.getTransaction().commit();
		session.close();

	}

}
