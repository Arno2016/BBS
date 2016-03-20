package com.bbs.daoImpl;

import java.util.List;

import com.bbs.dao.AdminDao;
import com.bbs.hibernate.factory.BaseHibernateDAO;
import com.bbs.model.User;

public class AdminDaoImpl extends BaseHibernateDAO implements AdminDao{

	@Override
	public boolean regist(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> login(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int activeUser(String activeCode) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateCode(String username, String code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean changePassword(int userId, int oldpasswod, int newpassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int isExist(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
