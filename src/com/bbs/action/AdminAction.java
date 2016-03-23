package com.bbs.action;

import java.io.File;

import com.bbs.biz.AdminBiz;

public class AdminAction extends BaseAction{
	private String username;
	private String password;
	private String email;
	private File photoImg;
	private AdminBiz adminBiz;
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhotoImg(File photoImg) {
		this.photoImg = photoImg;
	}
	public void setAdminBiz(AdminBiz adminBiz) {
		this.adminBiz = adminBiz;
	}
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}

}
