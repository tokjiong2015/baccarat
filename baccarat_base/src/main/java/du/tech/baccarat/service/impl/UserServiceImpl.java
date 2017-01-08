package du.tech.baccarat.service.impl;

import java.util.List;

import du.tech.baccarat.domain.user.User;
import du.tech.baccarat.service.base.BaseService;
import du.tech.baccarat.service.user.IUserService;

public class UserServiceImpl extends BaseService implements IUserService {

	@Override
	public User login(User user) {
		List<User> list = userDAO.findByNamedQuery("User.login", user.getUsername(),user.getPassword());
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public void editPassword(User user) {
		userDAO.update(user);
	}

}
