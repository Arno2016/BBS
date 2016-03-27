package com.bbs.action;

import java.io.File;

import com.bbs.biz.AdminBiz;

public class AdminAction extends BaseAction{
	private String username;
	private String password;
	private String email;
	private File photoImg;
	private AdminBiz adminBiz;
	private String sex;
	
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public File getPhotoImg() {
		return photoImg;
	}
	public String getSex() {
		return sex;
	}
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
	
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String execute() throws Exception {
		
		return super.execute();
	}
	
	
	public String update(){
		return SUCCESS;
	}
	
	public String login(){
		if (username != null && password != null){
			int result = adminBiz.login(username, password);
			if (result > 0){
				//将用户id，和姓名写入session
				getSession().put("adminname", username);
				getSession().put("adminId", result);
				return SUCCESS;
			}
			switch (result) {
			case -1:
				this.addFieldError("adminPassword", "密码不正确");
				return "login";
			case 0:
				this.addFieldError("adminName", "该用户不存在");
				return "login";
			default:
				break;
			}
		
		return SUCCESS;
		}
		return "login";
	}

}
