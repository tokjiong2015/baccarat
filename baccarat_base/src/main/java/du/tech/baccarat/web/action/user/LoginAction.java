package du.tech.baccarat.web.action.user;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;

import du.tech.baccarat.domain.uspf.Uspf;
import du.tech.baccarat.web.action.base.BaseAction;

public class LoginAction extends BaseAction implements ModelDriven<Uspf> {
	private Uspf user = new Uspf();
	private String validationCode;
	
	@Override
	public Uspf getModel() {
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
		Uspf loginUser = IUserService.login(user);
		IUserService.updateAndGetLatestGameSet("A");
	
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
