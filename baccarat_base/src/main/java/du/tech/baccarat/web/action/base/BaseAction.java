package du.tech.baccarat.web.action.base;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;

import du.tech.baccarat.service.user.IUserService;

public abstract class BaseAction extends ActionSupport {
	@Resource(name = "userService")
	protected IUserService IUserService;
}
