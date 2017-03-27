/**
 * CopyRight DuHong on 9:45:01 PM. All rights reversed. Declared in GitHub and Local both!
 */
package du.tech.baccarat.service.impl;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import du.tech.baccarat.domain.control.Control;
import du.tech.baccarat.service.base.BaseService;
import du.tech.baccarat.service.bc.IService;
import du.tech.baccarat.utils.PageRequestBean;

public class IServiceImpl<T> extends BaseService implements IService{

	@Override
	public long getTotalPages(PageRequestBean pageRequestBean) {
		List l =genericDAO.findByCriteria(pageRequestBean.getDetachedCriteria());
		return  (Long) l.get(0);
	}

	@Override
	public List<T> getCurrContentForPagination(DetachedCriteria detachedCriteria, int min, int max) {
		return genericDAO.getCurrContentForPagination(detachedCriteria,min,max);
	}
	
	@Override
	public int updateAndGetLatestGameSet(String controlCode){
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Control.class);
		detachedCriteria.add(Restrictions.eq("controlCode", controlCode)); 
		Control result=(Control)genericDAO.findByCriteria(detachedCriteria).get(0);
		int newResult=Integer.parseInt(result.getControlValue()) +1;
		result.setControlValue(String.valueOf(newResult));
		genericDAO.save(result);
		return newResult;
		
	}

	@Override
	public int getCurrentGameSet() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Control.class);
		detachedCriteria.add(Restrictions.eq("controlCode", "A")); 
		Control result=(Control)genericDAO.findByCriteria(detachedCriteria).get(0);
		return Integer.parseInt(result.getControlValue());
	}

	@Override
	public int getCurrentGameNo() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Control.class);
		detachedCriteria.setProjection(Projections.rowCount());
		detachedCriteria.add(Restrictions.eq("controlCode", "A")); 
		
		int currGameNo=0;
		if(ServletActionContext.getRequest().getSession().getAttribute("GameNo")!=null)
		{
			currGameNo = (Integer) ServletActionContext.getRequest().getSession().getAttribute("GameNo");
			currGameNo++;
			ServletActionContext.getRequest().getSession().setAttribute("GameNo", currGameNo);
		}
		else
		{
			currGameNo=1;
			ServletActionContext.getRequest().getSession().setAttribute("GameNo", 1);
		}
		
		return currGameNo;
	}

}


