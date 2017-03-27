/**
 * CopyRight DuHong on 8:42:47 PM. All rights reversed. Declared in GitHub and Local both!
 */
package du.tech.baccarat.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import du.tech.baccarat.domain.tabt.Tabt;
import du.tech.baccarat.service.bc.ITabtService;


public class TabtServiceImpl extends IServiceImpl implements ITabtService{

	@Override
	public void saveOrUpDate(Tabt tabt) {
		tabtDAO.saveOrUpdate(tabt);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tabt> listTabtSelection() {
		return tabtDAO.findAll();
	}

	@Override
	public List<Tabt> listTabtSelectionByLbbyKey(String uuid) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Tabt.class);
		detachedCriteria.createAlias("lbbys", "lt");
		detachedCriteria.add(Restrictions.like("lt.uuid", "%" + uuid + "%"));
		return tabtDAO.findByCriteria(detachedCriteria);
	}

}
