package du.tech.baccarat.web.action.bc;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import du.tech.baccarat.domain.player.Player;
import du.tech.baccarat.domain.strategy.Strategy;
import du.tech.baccarat.web.action.base.BaseAction;

public class StrategyAction extends BaseAction implements ModelDriven<Strategy> {

	Strategy strategy = new Strategy();
	Player   p        = new Player();
	//Attribute Driven for pagination
	private int page;
	
	private int rows;
	
	@Override
	public Strategy getModel() {
		return strategy;
	}
	
	
	public String addStr()
	{
		//strategy.setUpdatetime(new Timestamp(System.currentTimeMillis()));
		//if(strategy.getQuit()==null) strategy.setQuit(0.0);
		//if(strategy.getExpRev()==null) strategy.setExpRev(0.0);
		IStrategyService.addStr(strategy);
		return "STRSUCCESS";
	}
	
	public String processPagination()
	{		
		//2 Define the criteria and set to request bean
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Strategy.class);	
		return "";
	}
	
	//-----getters and setters
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public String delBatch()
	{
		//String[] ids = strategy.getStrId().split(", ");
		//IStrategyService.delBatch(ids);
		return "delBatchSUCCESS";
	}
	
	public String listStrategySelection()
	{
		List<Strategy> liStrategy = IStrategyService.listStrategySelection();
		ActionContext.getContext().put("liStr",liStrategy);
		return "listSelectionSUCCESS";
	}
}
