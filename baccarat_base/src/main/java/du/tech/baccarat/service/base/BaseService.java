package du.tech.baccarat.service.base;

import javax.annotation.Resource;

import du.tech.baccarat.dao.GenericDAO;
import du.tech.baccarat.domain.user.User;

public class BaseService {
	@Resource(name="userDAO")
	protected GenericDAO<User> userDAO;
}
