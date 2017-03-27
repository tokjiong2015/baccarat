package du.tech.baccarat.service.base;

import javax.annotation.Resource;

import du.tech.baccarat.dao.GenericDAO;
import du.tech.baccarat.domain.game.Game;
import du.tech.baccarat.domain.lbby.Lbby;
import du.tech.baccarat.domain.player.Player;
import du.tech.baccarat.domain.strategy.Strategy;
import du.tech.baccarat.domain.tabt.Tabt;
import du.tech.baccarat.domain.uspf.Uspf;

public class BaseService<T> {
	@Resource(name="userDAO")
	protected GenericDAO<Uspf> userDAO;
	
	@Resource(name="strategyDAO")
	protected GenericDAO<Strategy> strategyDAO;
	
	@Resource(name="playerDAO")
	protected GenericDAO<Player> playerDAO;
	
	@Resource(name="gameDAO")
	protected GenericDAO<Game> gameDAO;
	
	@Resource(name="tabtDAO")
	protected GenericDAO<Tabt> tabtDAO;
	
	@Resource(name="lbbyDAO")
	protected GenericDAO<Lbby> lbbyDAO;
	
	@Resource(name="genericDAO")
	protected GenericDAO<T> genericDAO;
	
	
}
