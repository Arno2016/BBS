package com.bbs.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbs.dao.AdminDao;
import com.bbs.hibernate.factory.BaseHibernateDAO;
import com.bbs.model.Admin;
import com.bbs.model.AdminDAO;
import com.bbs.model.User;

public class AdminDaoImpl extends BaseHibernateDAO implements AdminDao{
	private static final Logger log = LoggerFactory.getLogger(AdminDao.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String PASSWORD = "password";
	public static final String PHOTO_URL = "photoUrl";
	public static final String EMAIL = "email";
	public static final String TYPE = "type";
	public static final String SEX = "sex";

	public void save(Admin transientInstance) {
		log.debug("saving Admin instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Admin persistentInstance) {
		log.debug("deleting Admin instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Admin findById(java.lang.Integer id) {
		log.debug("getting Admin instance with id: " + id);
		try {
			Admin instance = (Admin) getSession()
					.get("com.bbs.model.Admin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Admin instance) {
		log.debug("finding Admin instance by example");
		try {
			List results = getSession().createCriteria("com.bbs.model.Admin")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Admin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Admin as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByPhotoUrl(Object photoUrl) {
		return findByProperty(PHOTO_URL, photoUrl);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}


	@Override
	public List<Admin> login(String username) {
		Session session = getSession();
		String sql = "from Admin admin where admin.userName=?";
		Query query = session.createQuery(sql);
		query.setString(0, username);
		List list = query.list();
		session.flush();
		session.close();
		return list;
	}

	@Override
	public void updateAdmin(Admin admin) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		session.update(admin);;
		transaction.commit();
		session.flush();
		session.close();
	}

	@Override
	public boolean changePassword(int userId, int oldpasswod, int newpassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin getAdminById(Integer adminId) {
		return findById(adminId);
	}

	@Override
	public int getAdminIdByUsername(String username) {
		List<Admin>admins = findByUserName(username);
		if (admins != null && admins.size()>0)
			return admins.get(0).getId();
		return -1;
	}

	@Override
	public int getAdminIdByEmail(String email) {
		List<Admin>admins = findByEmail(email);
		if (admins != null && admins.size()>0)
			return admins.get(0).getId();
		return -1;
	}

	@Override
	public int isExist(Admin admin) {
		if (findByUserName(admin.getUserName()).size()>0)
			return 1;
		else if (findByEmail(admin.getEmail()).size()>0)
			return 2;		
		return -1;
	}

	

}
