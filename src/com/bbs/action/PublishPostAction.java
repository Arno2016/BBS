package com.bbs.action;

import java.sql.Timestamp;

import com.bbs.biz.BlackListBiz;
import com.bbs.biz.PostBiz;
import com.bbs.model.MainForum;
import com.bbs.model.Post;
import com.bbs.model.SubForum;
import com.bbs.model.User;

public class PublishPostAction extends BaseAction{
	private String title;
	private String content;
	private int mainForum;
	private int subForum;
	
	private PostBiz postBiz;
	
	private BlackListBiz blackListBiz;
	
	
	

	

	public void setBlackListBiz(BlackListBiz blackListBiz) {
		this.blackListBiz = blackListBiz;
	}

	public void setPostBiz(PostBiz postBiz) {
		this.postBiz = postBiz;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	public void setMainForum(int mainForum) {
		this.mainForum = mainForum;
	}

	public void setSubForum(int subForum) {
		this.subForum = subForum;
	}

	@Override
	public String execute() throws Exception {
		
		int userId = (Integer) getSession().get("userId");
		if (blackListBiz.getLevel(userId)<=3){
			this.addFieldError("limit", "您已被管理员限制发帖");
			return "publish";
		}
	
		Post post = new Post();
		post.setTitle(title);
		post.setCardContent(content);
		SubForum subFrom = new SubForum();
		subFrom.setId(subForum);
		MainForum main = new MainForum();
		main.setId(mainForum);
		subFrom.setMainForum(main);
		post.setSubForum(subFrom);
		User user  = new User();
		user.setId((Integer)getSession().get("userId"));
		post.setUser(user);
		post.setPostType(0);
		post.setReplyNum(0);
		post.setSendDate(new Timestamp(System.currentTimeMillis()));
		postBiz.pushlish(post);
		return SUCCESS;
	}
	
	
	

}
