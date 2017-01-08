package du.tech.baccarat.service.user;

import du.tech.baccarat.domain.user.User;

public interface IUserService {
	public User login(User user);
	
	public void editPassword(User user);
}
