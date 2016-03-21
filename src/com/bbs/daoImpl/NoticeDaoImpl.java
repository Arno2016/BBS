package com.bbs.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bbs.dao.NoticeDao;
import com.bbs.hibernate.factory.BaseHibernateDAO;
import com.bbs.model.Notice;

public class NoticeDaoImpl extends BaseHibernateDAO implements NoticeDao{
	
	/* (non-Javadoc)
	 * @see com.bbs.daoImpl.NoticeDao#getNotice(int, int)
	 */
	@Override
	public List<Notice> getNotice(int pageIndex,int pageSize){
		Session session = getSession();
		String sql = "from Notice notice order by notice.noticeDate desc ";
		Query query = session.createQuery(sql);
		int startIndex = (pageIndex -1) * pageSize;
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		return query.list();
	}
	
	/* (non-Javadoc)
	 * @see com.bbs.daoImpl.NoticeDao#publish(com.bbs.model.Notice)
	 */
	@Override
	public void publish(Notice notice){
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		session.save(notice);
		transaction.commit();	

	}

	
	

}
