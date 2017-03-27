/**
 * CopyRight DuHong on 9:04:36 PM. All rights reversed. Declared in GitHub and Local both!
 */
package du.tech.baccarat.service.bc;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import du.tech.baccarat.utils.PageRequestBean;

public interface IService {
	 public <T> long getTotalPages(PageRequestBean pageRequestBean);
	 public List getCurrContentForPagination(DetachedCriteria detachedCriteria,int min,int max);
	 public int updateAndGetLatestGameSet(String controlCode);
	 public int getCurrentGameSet();
	 public int getCurrentGameNo();
}


