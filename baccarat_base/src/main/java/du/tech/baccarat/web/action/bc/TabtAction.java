package du.tech.baccarat.web.action.bc;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import du.tech.baccarat.domain.tabt.Tabt;
import du.tech.baccarat.web.action.base.BaseAction;

public class TabtAction extends BaseAction implements ModelDriven<Tabt> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tabt tabt;
	private String currGetSelected;

	@Override
	public Tabt getModel() {
		if (tabt == null) {
			tabt = new Tabt();
		}
		return tabt;
	}

	public String saveOrUpdate()
	{
		ITabtService.saveOrUpDate(tabt);
		return "saveOrUpdateSUCCESS";
	}
	// ---------This part will be used in pagation, later will optimize

	public String listTabtSelection()
	{
		Map parameters =  ActionContext.getContext().getParameters();
        Iterator it = parameters.entrySet().iterator();  
        String lbbbKey = null;
        while (it.hasNext() && lbbbKey==null) {  
        	Map.Entry entry = (Entry) it.next();
        	String key = (String) entry.getKey();
        	lbbbKey=key;
        }  
		
		List<Tabt> listTabt = ITabtService.listTabtSelectionByLbbyKey(lbbbKey);
		ActionContext.getContext().put("listTabt",listTabt);
		return "listSelectionSUCCESS";
	}
	public String processPagination() {
		return processPaginationParent(Tabt.class);
	}

	public String getCurrGetSelected() {
		return currGetSelected;
	}

	public void setCurrGetSelected(String currGetSelected) {
		this.currGetSelected = currGetSelected;
	}

}
