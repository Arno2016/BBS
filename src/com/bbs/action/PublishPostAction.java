package com.bbs.action;

public class PublishPostAction extends BaseAction{
	private String title;
	private String content;
	private String subForum;
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setSubForum(String subForum) {
		this.subForum = subForum;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	
	
	

}
