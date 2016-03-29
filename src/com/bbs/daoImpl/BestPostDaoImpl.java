package com.bbs.daoImpl;

import com.bbs.dao.BestPostDao;
import com.bbs.hibernate.factory.BaseHibernateDAO;
import com.bbs.model.BestPost;
import com.bbs.model.Post;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * BestPost entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bbs.model.BestPost
 * @author MyEclipse Persistence Tools
 */
public class BestPostDaoImpl extends BaseHibernateDAO implements BestPostDao{
	private static final Logger log = LoggerFactory
			.getLogger(BestPostDaoImpl.class);

private SessionFactory sessionFactory;
	
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getMySession(){
		return sessionFactory.openSession();
	}

	public void save(BestPost transientInstance) {
		log.debug("saving BestPost instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BestPost persistentInstance) {
		log.debug("deleting BestPost instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BestPost findById(java.lang.Integer id) {
		log.debug("getting BestPost instance with id: " + id);
		try {
			BestPost instance = (BestPost) getSession().get(
					"com.bbs.model.BestPost", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(BestPost instance) {
		log.debug("finding BestPost instance by example");
		try {
			List results = getSession()
					.createCriteria("com.bbs.model.BestPost")
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
		log.debug("finding BestPost instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BestPost as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all BestPost instances");
		try {
			String queryString = "from BestPost";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BestPost merge(BestPost detachedInstance) {
		log.debug("merging BestPost instance");
		try {
			BestPost result = (BestPost) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BestPost instance) {
		log.debug("attaching dirty BestPost instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BestPost instance) {
		log.debug("attaching clean BestPost instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public void insert(BestPost post) {
		Session session = getSession();
		Transaction beginTransaction = session.beginTransaction();
		session.save(post);
		beginTransaction.commit();
		 session.flush();
			session.close();
		
	}

	@Override
	public List<BestPost> getBestPosts(int pageIndex, int pageSize) {
		Session session = getSession();
		String sql = "from BestPost post order by post.applyDate desc";
		Query query = session.createQuery(sql);
		int startIndex = (pageIndex -1) * pageSize;
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		List list = query.list();
		 session.flush();
			session.close();
		return list;
	}

	@Override
	public void delete(int postId) {
		BestPost post = findById(postId);
		Session session = getSession();
		Transaction beginTransaction = session.beginTransaction();
		session.delete(post);
		beginTransaction.commit();
		 session.flush();
			session.close();
	}

	@Override
	public void updateState(Integer postId, int state) {
		Session session = getSession();
		String sql = "from BestPost p where p.post.id = ?";
		Query query = session.createQuery(sql);
		query.setInteger(0, postId);
		List<BestPost> posts = query.list();
		if (posts != null && posts.size()>0){
			BestPost post = posts.get(0);
			post.setState(state);
			Transaction beginTransaction = session.beginTransaction();
			session.update(post);
			beginTransaction.commit();	
			 session.flush();
				session.close();
		}
			
		
	}

	@Override
	public List<BestPost> getRecordsByUserId(int userId,int pageIndex,int pageSize) {
		Session session = getSession();
		String sql = "from BestPost p where p.user.id = ?";
		Query query = session.createQuery(sql);
		query.setInteger(0, userId);
		int startIndex = (pageIndex -1) * pageSize;
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		 List<BestPost>  bestPosts = query.list();
		 session.flush();
			session.close();
		System.out.println("数据库size："+bestPosts.size());
		return bestPosts;
	}

	@Override
	public boolean isExist(int postId) {
		Session session = getSession();
		String sql = "from BestPost p where p.post.id = ?";
		Query query = session.createQuery(sql);
		query.setInteger(0, postId);
		List<BestPost> posts = query.list();
		if (posts != null && posts.size()>0){
			session.flush();
			session.clear();
			return true;
		}
		session.flush();
		session.clear();
		return false;
	}
}