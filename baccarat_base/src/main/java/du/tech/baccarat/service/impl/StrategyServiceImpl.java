package du.tech.baccarat.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

import du.tech.baccarat.domain.strategy.Strategy;
import du.tech.baccarat.service.base.BaseService;
import du.tech.baccarat.service.bc.IStrategyService;
import du.tech.baccarat.utils.PageRequestBean;

public class StrategyServiceImpl extends IServiceImpl implements IStrategyService{

	@Override
	public void addStr(Strategy strategy) {
		strategyDAO.saveOrUpdate(strategy);
	}

	@Override
	public void delBatch(String [] ids) {
		for(String id:ids)
		{
			Strategy strategy = (Strategy) strategyDAO.findById(id);
			//strategy.setDeltag("1");
		}
	}

	@Override
	public List<Strategy> listStrategySelection() {
		return strategyDAO.findAll();
	}
	
}
