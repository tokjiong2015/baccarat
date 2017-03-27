/**
 * CopyRight DuHong on 8:42:47 PM. All rights reversed. Declared in GitHub and Local both!
 */
package du.tech.baccarat.service.impl;

import java.util.List;

import du.tech.baccarat.domain.lbby.Lbby;
import du.tech.baccarat.service.bc.ILbbyService;


public class LbbyServiceImpl extends IServiceImpl implements ILbbyService{

	@Override
	public void saveOrUpDate(Lbby lbby) {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lbby> listLbbySelection() {
		return lbbyDAO.findAll();
	}


}
