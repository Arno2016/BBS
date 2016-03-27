package com.bbs.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bbs.dao.AdminDao;
import com.bbs.hibernate.factory.BaseHibernateDAO;
import com.bbs.model.Admin;
import com.bbs.model.User;

public class AdminDaoImpl extends BaseHibernateDAO implements AdminDao{

	@Override
	public List<Admin> login(String username) {
		Session session = getSession();
		String sql = "from Admin admin where admin.userName=?";
		Query query = session.createQuery(sql);
		query.setString(0, username);
		return query.list();
	}

	@Override
	public void updateAdmin(Admin admin) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		session.update(admin);;
		transaction.commit();
	}

	@Override
	public boolean changePassword(int userId, int oldpasswod, int newpassword) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
