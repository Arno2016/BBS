package com.bbs.action;

import java.sql.Timestamp;

import com.bbs.biz.FollowcardBiz;
import com.bbs.model.Followcard;
import com.bbs.model.Post;
import com.bbs.model.User;

public class ReplyAction extends BaseAction{
	private int postId;
//	private int userId;
	private String content;
	private FollowcardBiz followcardBiz;
	
	
	
	public int getPostId() {
		return postId;
	}
	public void setFollowcardBiz(FollowcardBiz followcardBiz) {
		this.followcardBiz = followcardBiz;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	@Override
	public String execute() throws Exception {
		if (content != null){
			Followcard followcard = new Followcard();
			followcard.setFollowContent(content);
			Post post = new Post();
			post.setId(postId);
			followcard.setPost(post);
			followcard.setFollowDate(new Timestamp(System.currentTimeMillis()));
			User user = new User();
			int userId = (Integer) getSession().get("userId");
			user.setId(userId);
			System.out.println("user id:"+userId+user.getUsername());
			user.setUsername((String) getSession().get("username"));
			followcard.setUser(user);
			followcardBiz.addReply(followcard);
			getRequest().put("postId", postId);
			return SUCCESS;
		}
		return ERROR;
	}
	

}
