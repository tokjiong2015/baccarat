package du.tech.baccarat.web.action.bc;


import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ModelDriven;

import du.tech.baccarat.domain.player.Player;
import du.tech.baccarat.domain.uspf.Uspf;
import du.tech.baccarat.web.action.base.BaseAction;

public class PlayerAction extends BaseAction implements ModelDriven<Player> {

	private Player player;
	private String strId;
	private String strategyName;

	@Override
	public Player getModel() {
		if (player == null) {
			player = new Player();
		}
		return player;
	}

	public String saveOrUpdate() {
		
		Uspf user = (Uspf) ServletActionContext.getRequest().getSession().getAttribute("user");
		player.setUspf(user);
		IPlayerSerivce.saveOrUpDate("player", player);
		return "saveOrUpdateSUCCESS";
	}

	public String getStrId() {
		return strId;
	}

	public void setStrId(String strId) {
		this.strId = strId;
	}
	
	//---------This part is for batch deletion
	
	public String getStrategyName() {
		return strategyName;
	}

	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}

	public String batchDeletion(){
		
		String rawPlayerName=player.getPlayerName();
		String playerNameList[]=rawPlayerName.split(", ");
		for(String playerName:playerNameList)
		{
			IPlayerSerivce.batchDeletion(playerName);
		}
		
		return "batchDeleteSUCCEESS";
	}
	
	//---------This part will be used in pagation, later will optimize

	public String processPagination()
	{		
		return processPaginationParent(Player.class);
	}

}
