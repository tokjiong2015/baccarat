package du.tech.baccarat.service.impl;

import du.tech.baccarat.domain.player.Player;
import du.tech.baccarat.service.bc.IPlayerService;


public class PlayerServiceImpl extends IServiceImpl implements IPlayerService{

	@Override
	public void saveOrUpDate(String entityName,Player player) {
		playerDAO.saveOrUpdate(entityName,player);
	}
	
	@Override
	public void batchDeletion(String playerName) {
		Player player=(Player)playerDAO.findById(playerName);
		playerDAO.delete(player);
	}

	@Override
	public void save(Player player) {
		playerDAO.save(player);
	}

	@Override
	public void createPlayer(Player player) {
		playerDAO.findByNamedQuery("player.creation", player.getPlayerName(),player.getInitialFund());
		
	}

}
