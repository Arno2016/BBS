package com.bbs.biz;

import java.util.List;
import java.util.Set;

import com.bbs.dao.PostDao;
import com.bbs.model.Followcard;
import com.bbs.model.Post;

public interface PostBiz {

	public abstract void setPostDao(PostDao postDao);

	/**
	 * 向帖子表中增加一条记录
	 * @param post 帖子
	 */
	public abstract void pushlish(Post post);

	/**
	 * 获取指定帖子的回复贴
	 * @param postId 帖子id
	 * @return 回复贴列表
	 */
	public abstract Set<Followcard> getFollowCards(int postId);

	/**
	 * 获取论坛精华帖
	 * @return
	 */
	public abstract List<Post> getBestPosts(int pageIndex, int pageSize);

	/**
	 * 分页查找最新发表的帖子
	 * @param pageIndex	页码，从1开始
	 * @param pageSize 页面大小
	 * @return
	 */
	public abstract List<Post> getLatestPosts(int pageIndex, int pageSize);

}