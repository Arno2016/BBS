package com.bbs.daoImpl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bbs.dao.PostDao;
import com.bbs.hibernate.factory.BaseHibernateDAO;
import com.bbs.model.Followcard;
import com.bbs.model.Post;

/**
 * @author 张建浩、卜凡、卢静、余莎、姚文娜
 * @version 1.0
 * 2016年3月17日下午8:22:52
 */
public class PostDaoImpl extends BaseHibernateDAO implements PostDao{

	
	@Override
	public void pushlish(Post post) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		session.save(post);
		transaction.commit();		
	}

	
	@Override
	public Set<Followcard> getFollowCards(int postId) {
		Post post = new Post();
		post.setId(postId);
		return post.getFollowcards();		
	}

	
	

	
	@Override
	public List<Post> getLatestPosts(int pageIndex, int pageSize) {
		Session session = getSession();
		String sql = "from Post p order by p.sendDate desc";
		Query query = session.createQuery(sql);
		int startIndex = (pageIndex -1) * pageSize;
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		return query.list();
	}


	@Override
	public List<Post> getBestPosts(int pageIndex, int pageSize) {
		Session session = getSession();
		String sql = "from Post p order by p.postType asc";
		Query query = session.createQuery(sql);
		int startIndex = (pageIndex -1) * pageSize;
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		return query.list();
	}


	

}
