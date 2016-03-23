package com.bbs.action;

import java.io.File;

import com.bbs.biz.UserBiz;

public class UserAction  extends BaseAction{
	private String username;
	private String password;
	private String sex;
	private String email;
	private File photoImg;
	
	
	public void setPhotoImg(File photoImg) {
		this.photoImg = photoImg;
	}
	private UserBiz userBiz;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	
	

}
