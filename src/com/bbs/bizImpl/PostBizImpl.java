package com.bbs.bizImpl;

import java.util.List;
import java.util.Set;

import com.bbs.biz.PostBiz;
import com.bbs.dao.PostDao;
import com.bbs.model.Followcard;
import com.bbs.model.Post;

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
	 * @see com.bbs.bizImpl.PostBiz#getFollowCards(int)
	 */
	@Override
	public Set<Followcard> getFollowCards(int postId){
		return postDao.getFollowCards(postId);
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
	
	
	

}
