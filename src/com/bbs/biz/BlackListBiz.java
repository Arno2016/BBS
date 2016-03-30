package com.bbs.biz;

import com.bbs.model.BlackList;

public interface BlackListBiz {
	public  void save(BlackList transientInstance);

	public  int getLevel(int userId);

	

	public void update(BlackList blackList);

}
