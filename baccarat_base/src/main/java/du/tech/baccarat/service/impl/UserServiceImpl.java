package du.tech.baccarat.service.impl;

import java.util.List;

import du.tech.baccarat.domain.uspf.Uspf;
import du.tech.baccarat.service.base.BaseService;
import du.tech.baccarat.service.user.IUserService;
import du.tech.baccarat.utils.MD5Utils;

public class UserServiceImpl extends IServiceImpl implements IUserService {

	@Override
	public Uspf login(Uspf user) {
		List<Uspf> list = userDAO.findByNamedQuery("User.login", user.getUserName(),MD5Utils.md5(user.getPassWord()));
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public void editPassword(Uspf user) {
		userDAO.update(user);
	}

	@Override
	public int updateAndGetLatestGameSet(String controlCode) {
		return super.updateAndGetLatestGameSet(controlCode);
	}

}
