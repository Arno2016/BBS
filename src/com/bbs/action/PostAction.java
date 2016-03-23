package com.bbs.action;

import com.bbs.biz.PostBiz;
import com.bbs.model.Post;

public class PostAction extends BaseAction{
	private Integer postId;
	
	
	

	public Integer getPostId() {
		return postId;
	}


	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	PostBiz PostBiz;
	
	
	public void setPostBiz(PostBiz postBiz) {
		PostBiz = postBiz;
	}


	@Override
	public String execute() throws Exception {
		if (postId != null){
			System.out.println("id"+postId);
			Post post = PostBiz.getPostById(postId);
			if (post == null)
				return ERROR;
			getRequest().put("post", post);
			return SUCCESS;
		}
		return ERROR;
	}

}
