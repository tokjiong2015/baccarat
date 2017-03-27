package du.tech.baccarat.utils;
import org.hibernate.criterion.DetachedCriteria;
/*
 * encapsulate the request amt
 * */
public class PageRequestBean {
	
	//which page are you in now
	private int currentPage; 
	
	//how many records you want to show per page
	private int rows; 
	
	//All the conditional searches can be within this object
	//Otherwise we need to use dynamic SQL (set parameters)
	private DetachedCriteria DetachedCriteria;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public DetachedCriteria getDetachedCriteria() {
		return DetachedCriteria;
	}

	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		DetachedCriteria = detachedCriteria;
	}
	
}
