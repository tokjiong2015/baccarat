package du.tech.baccarat.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import du.tech.baccarat.domain.user.User;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (user == null) {
			ActionSupport action = (ActionSupport) invocation.getAction();
			action.addActionError("Please login");
			return "login"; 
		} else {
			return invocation.invoke();
		}
	}

}
