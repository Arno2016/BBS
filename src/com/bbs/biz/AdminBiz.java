package com.bbs.biz;

import com.bbs.model.Admin;
/**
 * 
 * @author 张建浩、卜凡、卢静、余莎、姚文娜
 * @version 1.0
 * 2016年3月23日上午11:35:37
 */
public interface AdminBiz {

	/**
	 * 用户登陆
	 * @param user 用户对象
	 * @return 
	 */
	public abstract int login(String username, String password);

	public abstract void updateAdmin(Admin admin);

}