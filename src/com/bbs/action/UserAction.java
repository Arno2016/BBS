package com.bbs.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.bbs.biz.UserBiz;
import com.bbs.model.User;
import com.bbs.utils.Utils;
import com.opensymphony.xwork2.ActionContext;

public class UserAction  extends BaseAction{
	private String username;
	private String password;
	private String sex;
	private String email;
	private File photoImg;
	private String photoImgFileName;
	
	public String getPhotoImgFileName() {
		return photoImgFileName;
	}

	public void setPhotoImgFileName(String photoImgFileName) {
		this.photoImgFileName = photoImgFileName;
	}

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
		if (username!=null || password != null || email != null || photoImg != null){
			
			User user = userBiz.getUserById((Integer)getSession().get("userId"));
			if (username != null)
			user.setUsername(username);
			if (sex != null)
				user.setSex(sex);
			if (email != null)
			user.setEmail(email);
			if (password != null)
			user.setPassword(password);
			System.out.println("username:"+username+email);
			switch (userBiz.isExist(user)) {
			case 1:
				int id = userBiz.getUserIdByUsername(username);
				if (id != (Integer)getSession().get("userId")){
					System.out.println("该用户已存在");
					addFieldError("username", "该用户名已存在");
					return SUCCESS;
				}else if (username != null){
					getSession().put("username", username);
				}
				
			case 2:
				int id2 = userBiz.getUserIdByUsername(username);
				if (id2 != (Integer)getSession().get("userId")){
					System.out.println("该邮箱已存在");
					addFieldError("email","该邮箱已存在");
					return SUCCESS;
				}
			default:
				break;
			}
			if (photoImg != null){
				String root = ServletActionContext.getServletContext().getRealPath("/upload/headImg");
				System.out.println(root+photoImg.getName());
				String filename = photoImgFileName;
				int index = filename.indexOf("\\");
				if (index != -1){
					filename = filename.substring(index+1);
				}
				int code = filename.hashCode();//得到哈希码
				String hex = Integer.toHexString(code);//转化成16进制
				File dstDir = new File(root,hex.charAt(0)+"/"+hex.charAt(1));
				String saveFilename = Utils.createUUID()+filename;//防止文件重名
				String abstractPath = "/upload/headImg/"+hex.charAt(0)+"/"+hex.charAt(1)+"/"+saveFilename;
				File dstFile = new File(dstDir,saveFilename);
				System.out.println(dstFile.toPath());
				if (!dstFile.getParentFile().exists()){
					dstFile.getParentFile().mkdirs();
					FileUtils.copyFile(photoImg,dstFile);
					user.setPhotoUrl(abstractPath);
					ActionContext.getContext().put("message", "上传成功");
					return SUCCESS;
				}
			}
			userBiz.update(user);
		}
		
		return SUCCESS;
	}
	
	

}
