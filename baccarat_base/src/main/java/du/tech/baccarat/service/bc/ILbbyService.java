package du.tech.baccarat.service.bc;

import java.util.List;

import du.tech.baccarat.domain.lbby.Lbby;

public interface ILbbyService extends IService {
	 public void saveOrUpDate(Lbby lbby);
	 public List<Lbby> listLbbySelection();

}
