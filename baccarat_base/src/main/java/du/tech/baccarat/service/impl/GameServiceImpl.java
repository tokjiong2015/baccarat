/**
 * CopyRight DuHong on 9:45:01 PM. All rights reversed. Declared in GitHub and Local both!
 */
package du.tech.baccarat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import du.tech.baccarat.domain.game.Game;
import du.tech.baccarat.domain.tabt.Tabt;
import du.tech.baccarat.service.bc.IGameService;

public class GameServiceImpl<T> extends IServiceImpl implements IGameService{

	@Override
	public void saveOrUpDate() {
		if(ServletActionContext.getRequest().getSession().getAttribute("temGameList")!=null)
		{
			@SuppressWarnings("unchecked")
			List <Game>currList =  (List<Game>) ServletActionContext.getRequest().getSession().getAttribute("temGameList");
			for(Game game :currList)
			{
				gameDAO.saveOrUpdate(game);
			}
			
			ServletActionContext.getRequest().getSession().setAttribute("temGameList", null);
		}	
	}
	
	@Override
	public void saveToSession(Game game) {
		
		if(ServletActionContext.getRequest().getSession().getAttribute("temGameList")!=null)
		{
			@SuppressWarnings("unchecked")
			List <Game>currList =  (List<Game>) ServletActionContext.getRequest().getSession().getAttribute("temGameList");
			currList.add(game);
		}
		else
		{
			List <Game>currList = new ArrayList<Game>();
			currList.add(game);
			ServletActionContext.getRequest().getSession().setAttribute("temGameList", currList);
		}
		
		
	}

	@Override
	public void saveOrUpdateByFile(Game game) {
		gameDAO.saveOrUpdate(game);
	}

	@Override
	public List<Tabt> findAllTabts() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Tabt.class);
		return gameDAO.findByCriteria(detachedCriteria);
	}


}


