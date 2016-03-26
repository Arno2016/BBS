package com.bbs.bizImpl;

import java.util.List;

import com.bbs.biz.MainForumBiz;
import com.bbs.dao.MainForumDao;
import com.bbs.model.MainForum;

public class MainForumBizImpl implements MainForumBiz {
	private MainForumDao mainDao;
	

	public void setMainDao(MainForumDao mainDao) {
		this.mainDao = mainDao;
	}


	@Override
	public List<MainForum> getAllMainForums() {
		return mainDao.findAll();
	}

}
