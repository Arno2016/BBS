package com.bbs.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		String username = (String) ActionContext.getContext().getSession().get("username");
		if (username == null){
			//未登录，进行拦截
			return "login";
		}else {
			//放行
			return arg0.invoke();
		}
		
	}

}
