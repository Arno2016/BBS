package com.bbs.action;

import java.util.List;

import com.bbs.biz.PostBiz;
import com.bbs.model.Post;

public class MoreAction extends BaseAction {
	private int type;//1,2,3.4.5.6.7.
	private int page;
	private PostBiz postBiz;
	
	

	public void setType(int type) {
		this.type = type;
	}

	public void setPage(int page) {
		this.page = page;
	}


	public void setPostBiz(PostBiz postBiz) {
		this.postBiz = postBiz;
	}


	@Override
	public String execute() throws Exception {
		System.out.println("type"+":"+type+"page:"+page);
		String typename = null;
		switch (type) {
		case 1:
			typename = "移动开发";
			break;
		case 2:
			typename = "web开发";
			break;
		case 3:
			typename = "云计算";
			break;
		case 4:
			typename = "开发语言/框架";
			break;
		case 5:
			typename = "数据库开发";
			break;
		case 6:
			typename = "硬件/嵌入式开发";
			break;
		case 7:
			typename = "Linux/Unix";
			break;
		case 8:
			typename = "论坛新帖";
			break;
		case 9:
			typename = "论坛热帖";
			break;
		default:
			break;
		}
		if (type>0&&page>0){
			List<Post>posts = postBiz.getPostByType(type, page, 2);
//			for (Post post:posts){
//				System.out.println("差找到"+post.getTitle());
//			}
			getRequest().put("posts", posts);
			getRequest().put("page", page);
			getRequest().put("type", type);
			getRequest().put("typename", typename);
			return SUCCESS;
		}
		return ERROR;
	}
	

}
