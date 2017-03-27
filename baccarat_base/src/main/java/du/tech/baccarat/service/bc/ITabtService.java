package du.tech.baccarat.service.bc;

import java.util.List;

import du.tech.baccarat.domain.tabt.Tabt;

public interface ITabtService extends IService {
	 public void saveOrUpDate(Tabt tabt);
	 public List<Tabt> listTabtSelection();
	 public List<Tabt> listTabtSelectionByLbbyKey(String uuid);
}
