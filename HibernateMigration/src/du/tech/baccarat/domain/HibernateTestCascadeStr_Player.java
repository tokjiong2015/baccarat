package du.tech.baccarat.domain;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateTestCascadeStr_Player {

	public static void main(String[] args) {
		
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		Player p4 = new Player();
		p4.setPlayerName("p444");
		p4.setInitialFund(new BigDecimal(400));
		p3.setPlayerName("p333");
		p3.setInitialFund(new BigDecimal(300));
		p2.setPlayerName("p222");
		p2.setInitialFund(new BigDecimal(200));
		p1.setPlayerName("p111");
		p1.setInitialFund(new BigDecimal(100));
		
		
		Strategy s1 = new Strategy();
		Strategy s2 = new Strategy();
		Strategy s3 = new Strategy();
		Strategy s4 = new Strategy();
		s1.setStrategyName("A11");
		s2.setStrategyName("A22");
		s3.setStrategyName("A33");
		s4.setStrategyName("A44");
		
		p1.getStrategies().add(s1);
		p1.getStrategies().add(s2);
		p1.getStrategies().add(s3);
		p1.getStrategies().add(s4);
		p2.getStrategies().add(s4);

		
		p1.getStrategies().remove(s1);
		p1.getStrategies().remove(s2);
		p1.getStrategies().remove(s3);
		p1.getStrategies().remove(s4);
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession(); 
		session.beginTransaction();

		session.persist(p1);
		session.persist(p2);
		session.persist(p3);
		session.delete(p1);

		session.getTransaction().commit();
		session.close();

	}

}
