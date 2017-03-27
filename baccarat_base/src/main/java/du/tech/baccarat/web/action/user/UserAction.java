package du.tech.baccarat.web.action.user;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import du.tech.baccarat.domain.uspf.Uspf;
import du.tech.baccarat.web.action.base.BaseAction;

public class UserAction extends BaseAction implements ModelDriven<Uspf> {

	private Uspf user = new Uspf();

	@Override
	public Uspf getModel() {
		return user;
	}

	public String editPassword() {
		Uspf loginUser = (Uspf) ServletActionContext.getRequest().getSession().getAttribute("user");
		//user.setId(loginUser.getUserName());
		//user.setEmailAdd(loginUser.getEmailAdd());
		//user.setUsername(loginUser.getUsername());

		try {
			IUserService.editPassword(user);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", "success");
			map.put("msg", "transaction successful");
			ActionContext.getContext().put("map", map);
		} catch (Exception e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", "failure");
			map.put("msg", "fail," + e.getMessage());
			ActionContext.getContext().put("map", map);
		}

		return "editpasswordSUCCESS";

	}
}
