package du.tech.baccarat.service.bc;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import du.tech.baccarat.domain.strategy.Strategy;
import du.tech.baccarat.utils.PageRequestBean;

public interface IStrategyService {
	public void addStr(Strategy strategy);
	public void delBatch(String[] ids);
	public List<Strategy> listStrategySelection();
}
