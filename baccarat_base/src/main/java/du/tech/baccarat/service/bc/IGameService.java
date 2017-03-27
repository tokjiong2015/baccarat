package du.tech.baccarat.service.bc;

import java.util.List;

import du.tech.baccarat.domain.game.Game;
import du.tech.baccarat.domain.tabt.Tabt;

public interface IGameService extends IService {
	 public void saveOrUpDate();
	 public void saveOrUpdateByFile(Game game);
	 public void saveToSession(Game game);
	 public List<Tabt> findAllTabts();
}
