package com.bbs.action;

public class PublishPostAction extends BaseAction{
	private String title;
	private String content;
	private String mainForum;
	private String subForum;
	public void setMainForm(String mainForm) {
		this.mainForum = mainForm;
	}

	
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
		System.out.println(title);
		System.out.println(content);
		System.out.println(mainForum);
		System.out.println(subForum);
		return super.execute();
	}
	
	
	

}
