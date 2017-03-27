package du.tech.baccarat.service.user;

import du.tech.baccarat.domain.uspf.Uspf;

public interface IUserService {
	public Uspf login(Uspf user);
	
	public void editPassword(Uspf user);
	
	public int updateAndGetLatestGameSet(String controlCode);
	
}
