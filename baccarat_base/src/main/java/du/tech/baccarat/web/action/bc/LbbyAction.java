package du.tech.baccarat.web.action.bc;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import du.tech.baccarat.domain.lbby.Lbby;
import du.tech.baccarat.web.action.base.BaseAction;

public class LbbyAction extends BaseAction implements ModelDriven<Lbby> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Lbby lbby;

	@Override
	public Lbby getModel() {
		if (lbby == null) {
			lbby = new Lbby();
		}
		return lbby;
	}

	public String saveOrUpdate()
	{
		ILbbyService.saveOrUpDate(lbby);
		return "saveOrUpdateSUCCESS";
	}
	// ---------This part will be used in pagation, later will optimize

	public String listLbbySelection()
	{
		List<Lbby> listLbby = ILbbyService.listLbbySelection();
		ActionContext.getContext().put("listLbby",listLbby);
		return "listSelectionSUCCESS";
	}
	public String processPagination() {
		return processPaginationParent(Lbby.class);
	}

}
