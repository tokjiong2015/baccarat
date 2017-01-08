package du.tech.baccarat.web.action.user;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;

import du.tech.baccarat.domain.user.User;
import du.tech.baccarat.web.action.base.BaseAction;

public class LoginAction extends BaseAction implements ModelDriven<User> {

	private User user = new User();
	private String validationCode;
	
	@Override
	public User getModel() {
		return user;
	}

	public String execute()
	{
		String validationCodeFromSym=(String) ServletActionContext.getRequest().getSession().getAttribute("key");
		if(validationCodeFromSym==null || validationCode==null || (!validationCode.equalsIgnoreCase(validationCodeFromSym)))
		{
			this.addActionError("Wrong Validation Code");
			return INPUT;
		}
		
		User loginUser = IUserService.login(user);
		if(loginUser==null){
			this.addActionError("Username or Password not correct");
			return INPUT;
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("user", loginUser);
			return SUCCESS; 
		}
	}
	
	
	public void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
	}
	
}
