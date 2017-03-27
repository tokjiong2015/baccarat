package du.tech.baccarat.domain;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import du.tech.baccarat.key.GameKey;

public class HibernateTest {

	public static void main(String[] args) {
		
		Uspf uspf = new Uspf();
		uspf.setUserName("duhongistesting");
		uspf.setPassWord("123");
		uspf.setUserEmail("89288375@qq.com");
		uspf.setStrategyTendencyDesc("test");
		
		
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		p3.setPlayerName("p3");
		p3.setInitialFund(new BigDecimal(30));
		p2.setPlayerName("p2");
		p2.setInitialFund(new BigDecimal(20));
		p1.setPlayerName("p1");
		p2.setInitialFund(new BigDecimal(10));
		
		p1.setUspf(uspf);
		p2.setUspf(uspf);
		
		
		Strategy str1= new Strategy();
		Strategy str2= new Strategy();
		Strategy str3= new Strategy();
		str1.setStrategyName("C1");
		str2.setStrategyName("C2");
		str3.setStrategyName("C3");
		
		p1.getStrategies().add(str1);
		p1.getStrategies().add(str2);
		p2.getStrategies().add(str1);
		p3.getStrategies().add(str3);
		//These do not work. Because of player side maintain?
		str3.getPlayers().add(p3);
		str3.getPlayers().add(p2);
		str3.getPlayers().add(p1);
		
		Lbby lbby1 = new Lbby();
		Lbby lbby2 = new Lbby();
		Lbby lbby3 = new Lbby();
		
		p1.getLbbys().add(lbby1);
		p1.getLbbys().add(lbby2);
		p2.getLbbys().add(lbby2);
		
		
		
		Tabt tabt = new Tabt();
		Tabt tabt2= new Tabt();
		
		Game game = new Game();
		GameKey gk = new GameKey(1,1);
		game.setGameKey(gk);
		

		
		tabt.getGames().add(game);
		

		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession(); 
		session.beginTransaction();
		session.save(uspf);
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(str1);
		session.save(str2);
		session.save(str3);
		session.save(game);
		session.save(tabt);
		session.save(tabt2);
		session.save(lbby1);
		session.save(lbby2);
		session.save(lbby3);
		session.getTransaction().commit();
		session.close();

	}

}
