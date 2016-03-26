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
	public List<Followcard> getFollowCards(int postId,int pageIndex,int pageSize) {
		Session session = getSession();
		String sql = "from Followcard follow where follow.post.id=?";
		Query query = session.createQuery(sql);
		query.setInteger(0, postId);
		int startIndex = (pageIndex -1) * pageSize;
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		return query.list();
	}
	
	
	@Override
	public Post getPostById(int postId){
		Session session = getSession();
		String sql = "from Post post where post.id=?";
		Query query = session.createQuery(sql);
		query.setInteger(0, postId);
		List<Post> posts = query.list();
		if (posts != null && posts.size()>0)
			return posts.get(0);
		return null;
	}
	
	public List<Post> search(String keyword){
		
		Session session = getSession();
		String sql = "from Post post where post.title like ?";
		Query query = session.createQuery(sql);
		query.setString(0, '%'+keyword+'%');
		return query.list();
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
		String sql = "from Post p where p.postType = 1";
		Query query = session.createQuery(sql);
		int startIndex = (pageIndex -1) * pageSize;
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		return query.list();
	}
	
	public List<Post> getPostByType(int type,int pageIndex,int pageSize){
		if (type==1 || type==2 || type==3||type==4||type==5||type==6||type==7){
			Session session = getSession();
			String sql = "from Post post where post.subForum.mainForum.id=?";
			Query query = session.createQuery(sql);
			query.setInteger(0, type);
			int startIndex = (pageIndex -1) * pageSize;
			query.setFirstResult(startIndex);
			query.setMaxResults(pageSize);
			return query.list();
		}else if (type==8){
			return getLatestPosts(pageIndex, pageSize);
		}
		else if (type==9){
			return getBestPosts(pageIndex, pageSize);
		}
		
		return null;
		
	}


	@Override
	public List<Post> getPostByUserId(int userId,int pageIndex,int pageSize) {
		Session session = getSession();
		String sql = "from Post p where p.user.id = ?";
		Query query = session.createQuery(sql);
		query.setInteger(0, userId);
		int startIndex = (pageIndex -1) * pageSize;
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		return query.list();
	}
	
	


	


	

}
