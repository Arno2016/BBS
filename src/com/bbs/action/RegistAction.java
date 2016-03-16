package com.bbs.action;


import com.bbs.biz.UserBiz;
import com.bbs.constants.Constant;
import com.bbs.model.User;
import com.bbs.utils.MailUtil;
import com.bbs.utils.Utils;

/**
 * @author 张建浩、卜凡、卢静、余莎、姚文娜
 * @version 1.0
 * 2016年3月16日下午3:08:03
 */
public class RegistAction extends BaseAction {
	private User user;
	private UserBiz userBiz;
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @param userBiz the userBiz to set
	 */
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (user == null)
			return "regist";
		switch (userBiz.isExist(user)) {
		case 1:
			addFieldError("username", "该用户名已被注册");
			return "regist";
		case 2:
			addFieldError("email","该邮箱已被注册");
			return "regist";
		default:
			break;
		}		
		userBiz.regist(user);
		String code = Utils.createUUID();
		userBiz.updateCode(user.getUserName(),code);
		MailUtil mail = new MailUtil();
		mail.sendEmail(user.getEmail(),code,Constant.ACTIVE_EMAIL);
		//注册完成后跳转至中转页面，等待用户邮箱验证
		return "skip";
	}
	
	
	
	
	

	

}
