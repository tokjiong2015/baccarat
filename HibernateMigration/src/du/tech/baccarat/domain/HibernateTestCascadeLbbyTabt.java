package du.tech.baccarat.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateTestCascadeLbbyTabt {

	public static void main(String[] args) {
		
		Lbby l1 = new Lbby();
		Lbby l2 = new Lbby();
		Lbby l3 = new Lbby();
		
		Tabt t1 = new Tabt();
		Tabt t2 = new Tabt();
		Tabt t3 = new Tabt();
		
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		
		l1.getTabts().add(t1);
		l1.getTabts().add(t2);
		l1.getTabts().add(t3);
		l2.getTabts().add(t3);
		
		l1.getTabts().remove(t1);
		l1.getTabts().remove(t2);
		l1.getTabts().remove(t3);
		
		p1.setPlayerName("duhong");
		p2.setPlayerName("shunuan");
		p3.setPlayerName("hi");
		
		p1.getLbbys().add(l1);
		p1.getLbbys().add(l2);
		p1.getLbbys().add(l3);
		p2.getLbbys().add(l1);
		
		p1.getLbbys().remove(l1);
		p1.getLbbys().remove(l2);
		p1.getLbbys().remove(l3);
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession(); 
		session.beginTransaction();
		session.persist(p1);
		session.persist(p2);
		session.delete(p1);
		session.getTransaction().commit();
		session.close();

	}

}
