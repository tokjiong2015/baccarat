package du.tech.baccarat.utils;

import java.util.List;

/*
 * encapsulate the respsonse amt
 * */
@SuppressWarnings("rawtypes")
public class PageResponseBean {
	
	//How many records we have
	private long total;
	
	//The list of datas within current page
	private List rows;
	
	public List getRows() {
		return rows;
	}
	
	public void setRows(List rows) {
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}
