package du.tech.baccarat.domain;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import du.tech.baccarat.key.GameKey;


public class HibernateTestCascade {

	public static void main(String[] args) {
		
		Tabt   t1 = new Tabt();
		
		Game   g1 = new Game();
		Game   g2 = new Game();
		Game   g3 = new Game();
		//-- Initialize Tabt and Game
		t1.setNoOfPlayers(1);
		g1.setGameKey(new GameKey(1,1));
		g2.setGameKey(new GameKey(1,2));
		g3.setGameKey(new GameKey(1,3));
		
		//begin to Cascade Operation
		t1.getGames().add(g1);
		t1.getGames().add(g2);
		t1.getGames().add(g3);
		
		g1.setTabt(t1);
		g2.setTabt(t1);
		g3.setTabt(t1);
		
		//begin to Cascade Delete
		t1.getGames().remove(g1);
		t1.getGames().remove(g2);
		t1.getGames().remove(g3);

		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession(); 
		session.beginTransaction();
		session.persist(t1);
		
		session.delete(t1);
		session.getTransaction().commit();
		session.close();

	}

}
