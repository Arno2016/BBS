package com.bbs.bizImpl;

import com.bbs.biz.BlackListBiz;
import com.bbs.dao.BlackListDao;
import com.bbs.model.BlackList;

public class BlackListBizImpl implements BlackListBiz {
	private BlackListDao blackListDao;
	

	

	

	public void setBlackListDao(BlackListDao blackListDao) {
		this.blackListDao = blackListDao;
	}

	@Override
	public void save(BlackList transientInstance) {
		blackListDao.save(transientInstance);
		
	}

	@Override
	public int getLevel(int userId) {
		return blackListDao.getLevel(userId);
	}

	

	@Override
	public void update(BlackList blackList) {
		blackListDao.update(blackList);
		
	}

}
