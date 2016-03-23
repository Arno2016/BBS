package com.bbs.bizImpl;

import java.util.List;

import com.bbs.biz.AdminBiz;
import com.bbs.dao.AdminDao;
import com.bbs.model.Admin;
import com.bbs.model.User;
/**
 * 
 * @author 张建浩、卜凡、卢静、余莎、姚文娜
 * @version 1.0
 * 2016年3月23日上午11:32:27
 */
public class AdminBizImpl implements AdminBiz {
	private AdminDao adminDao;
	
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}



	/* (non-Javadoc)
	 * @see com.bbs.bizImpl.AdminBiz#login(java.lang.String, java.lang.String)
	 */
	@Override
	public int login(String username,String password){
		List<Admin> admins = adminDao.login(username);
		if (admins != null && admins.size() > 0){
			if (admins.get(0).getPassword().equals(password))
				return admins.get(0).getId();
			return -1;
		}else 
			return 0;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.bbs.bizImpl.AdminBiz#updateAdmin(com.bbs.model.Admin)
	 */
	@Override
	public void updateAdmin(Admin admin){
		adminDao.updateAdmin(admin);
	}
}
