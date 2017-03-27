package du.tech.baccarat.service.bc;


import du.tech.baccarat.domain.player.Player;

public interface IPlayerService extends IService {
	 public void save(Player player);
	 public void saveOrUpDate(String entityName,Player player);
	 public void batchDeletion(String playerName);
	 public void createPlayer(Player player);
}
