package du.tech.baccarat.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import du.tech.baccarat.key.CardKey;


public class HibernateTestNewElements {

	public static void main(String[] args) {
		/*
		CardKey ck1=new CardKey("club","ace",4);
		Card card1 = new Card(ck1);
		
		CardKey ck2=new CardKey("heart","ace",4);
		Card card2 = new Card(ck2);
		
		Pack p = new Pack();
		
		p.getCards().add(card1);
		p.getCards().add(card2);
		card1.setPack(p);
		card2.setPack(p);
		
		Control c = new Control("A");
		c.setControlValue("1");
		*/
		
		//Tabt table = new Tabt();
		//table.setDealerName("notnuan");
		
		//Tabt table1 = new Tabt();
		//table1.setDealerName("notIrene");
		
		//Tabt table2 = new Tabt();
		//table2.setDealerName("notSasa");
		
		//Tabt table3 = new Tabt();
		//table3.setDealerName("notMing");
		/*
		Strategy  c1 = new Strategy();
		c1.setStrategyName("C1");
		c1.setStrategyDesc("Bid after 4 in a row");
		
		Strategy  c2 = new Strategy();
		c2.setStrategyName("C2");
		c2.setStrategyDesc("Bid after 5 in a row");
		
		Strategy  c3 = new Strategy();
		c3.setStrategyName("C3");
		c3.setStrategyDesc("Bid after 6 in a row");
		*/
		
		Tabt t1 = new Tabt();
		t1.setDealerName("Sasa");
		t1.setTabtName("Money");
		Tabt t2 = new Tabt();
		t2.setDealerName("suqian");
		t2.setTabtName("Sexy");
		Tabt t3 = new Tabt();
		t3.setDealerName("Qilin");
		t3.setTabtName("Dream");
		Tabt t4 = new Tabt();
		t4.setDealerName("maoge");
		t3.setTabtName("Not Bad");
		
		Lbby lbby1 = new Lbby();
		Lbby lbby2 = new Lbby();
		Lbby lbby3 = new Lbby();
		Lbby lbby4 = new Lbby();
		
		lbby1.setCasinoName("Golden");
		lbby2.setCasinoName("Silver");
		lbby3.setCasinoName("Brown");
		lbby4.setCasinoName("Plain");
		
		lbby1.getTabts().add(t1);
		lbby1.getTabts().add(t2);
		lbby2.getTabts().add(t3);
		lbby2.getTabts().add(t4);
		
		Player player1 = new Player();
		player1.setPlayerName("maoge");
		player1.getLbbys().add(lbby1);
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession(); 
		session.beginTransaction();

		session.persist(player1);
		
		session.getTransaction().commit();
		session.close();
		//402881bd5b10158f015b101592a10000
		//402881bd5b10158f015b101592a10000
	}

}
