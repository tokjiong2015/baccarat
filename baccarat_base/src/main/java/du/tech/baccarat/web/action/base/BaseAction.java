package du.tech.baccarat.web.action.base;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import du.tech.baccarat.service.user.IUserService;
import du.tech.baccarat.utils.PageRequestBean;
import du.tech.baccarat.utils.PageResponseBean;
import du.tech.baccarat.service.bc.IGameService;
import du.tech.baccarat.service.bc.IPlayerService;
import du.tech.baccarat.service.bc.IService;
import du.tech.baccarat.service.bc.ITabtService;
import du.tech.baccarat.service.bc.ILbbyService;
import du.tech.baccarat.service.bc.IStrategyService;

public abstract class BaseAction extends ActionSupport {
	@Resource(name = "userService")
	protected IUserService IUserService;
	
	@Resource(name = "strategyService")
	protected IStrategyService IStrategyService;
	
	@Resource(name = "playerService")
	protected IPlayerService IPlayerSerivce;
	
	@Resource(name = "gameService")
	protected IGameService IGameSerivce;
	
	@Resource(name = "tabtService")
	protected ITabtService ITabtService;
	
	@Resource(name = "lbbyService")
	protected ILbbyService ILbbyService;
	
	@Resource(name = "IService")
	protected IService IService;
	
	
	//------------------trial-----------------
	private int page;
	
	private int rows;

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
	
	public <T> String processPaginationParent(Class<T> clazz)
	{
		//1 Define page request bean
		PageRequestBean pageRequestBean = new PageRequestBean();
		pageRequestBean.setCurrentPage(page);
		pageRequestBean.setRows(rows);
		
		//2 Define the criteria and set to request bean
		//DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Player.class);
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(clazz);
		detachedCriteria.setProjection(Projections.rowCount());
		pageRequestBean.setDetachedCriteria(detachedCriteria);
		
		//3 Get the total number of records
		long totalPages=IService.getTotalPages(pageRequestBean);
		
		//4 Clear the projection and define page response bean
		detachedCriteria.setProjection(null);
		PageResponseBean pageResponseBean=new PageResponseBean();
		
		//5 get the list of records in current page
		int fromIndex = (pageRequestBean.getCurrentPage()-1)*pageRequestBean.getRows();
		int howManyToGo=pageRequestBean.getRows();
		List l=IService.getCurrContentForPagination(detachedCriteria, fromIndex, howManyToGo);
		
		//6 key content for page response bean
		pageResponseBean.setTotal(totalPages);
		pageResponseBean.setRows(l);
		
		//7 Put pair into stack
		ActionContext.getContext().put("pageResponseBean",pageResponseBean);
		ServletActionContext.getRequest().getSession().setAttribute("pageResponseBean", pageResponseBean);
		
		return "PAGINATIONSUCCESS";
	}
	
	public <T> String processPaginationParent(DetachedCriteria detachedCriteria)
	{
		//1 Define page request bean
		PageRequestBean pageRequestBean = new PageRequestBean();
		pageRequestBean.setCurrentPage(page);
		pageRequestBean.setRows(rows);
		
		//5 get the list of records in current page
		int fromIndex = (pageRequestBean.getCurrentPage()-1)*pageRequestBean.getRows();
		int howManyToGo=pageRequestBean.getRows();
		List l=IService.getCurrContentForPagination(detachedCriteria, fromIndex, howManyToGo);
		
		
		detachedCriteria.setProjection(Projections.rowCount());
		pageRequestBean.setDetachedCriteria(detachedCriteria);
		
		long totalPages=IService.getTotalPages(pageRequestBean);
		
		PageResponseBean pageResponseBean=new PageResponseBean();
		//6 key content for page response bean
		pageResponseBean.setTotal(totalPages);
		pageResponseBean.setRows(l);
		
		//7 Put pair into stack
		ActionContext.getContext().put("pageResponseBean",pageResponseBean);
		ServletActionContext.getRequest().getSession().setAttribute("pageResponseBean", pageResponseBean);
		
		return "PAGINATIONSUCCESS";
	}
	
}
