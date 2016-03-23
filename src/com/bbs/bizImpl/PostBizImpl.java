package com.bbs.bizImpl;

import java.util.List;
import java.util.Set;

import com.bbs.biz.PostBiz;
import com.bbs.dao.PostDao;
import com.bbs.model.Followcard;
import com.bbs.model.Post;


/**
 * 
 * @author 张建浩、卜凡、卢静、余莎、姚文娜
 * @version 1.0
 * 2016年3月23日上午11:32:57
 */
public class PostBizImpl implements PostBiz {
	private PostDao postDao;

	/* (non-Javadoc)
	 * @see com.bbs.bizImpl.PostBiz#setPostDao(com.bbs.dao.PostDao)
	 */
	@Override
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	
	/* (non-Javadoc)
	 * @see com.bbs.bizImpl.PostBiz#pushlish(com.bbs.model.Post)
	 */
	@Override
	public void pushlish(Post post){
		postDao.pushlish(post);
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.bbs.bizImpl.PostBiz#getBestPosts(int, int)
	 */
	@Override
	public List<Post> getBestPosts(int pageIndex,int pageSize){
		return postDao.getBestPosts(pageIndex, pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.bbs.bizImpl.PostBiz#getLatestPosts(int, int)
	 */
	@Override
	public List<Post> getLatestPosts(int pageIndex,int pageSize ){
		return postDao.getLatestPosts(pageIndex, pageSize);
	}
	
	public Post getPostById(int postId){
		return postDao.getPostById(postId);
	}

	@Override
	public List<Followcard> getFollowCards(int postId, int pageIndex,
			int pageSize) {
		return postDao.getFollowCards(postId, pageIndex, pageSize);
	}
	
	public List<Post> searchPosts(String keyword){
		return postDao.search(keyword);
		
	}

	
	
	
	

}
