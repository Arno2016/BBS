package com.bbs.model;

/**
 * Active entity. @author MyEclipse Persistence Tools
 */

public class Active implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String activeCode;
	private int hasActive;
	
	/**
	 * @param userId
	 * @param activeCode
	 * @param hasActive
	 */
	public Active(Integer userId, String activeCode, int hasActive) {
		super();
		this.userId = userId;
		this.activeCode = activeCode;
		this.hasActive = hasActive;
	}
	/**
	 * 
	 */
	public Active() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return the activeCode
	 */
	public String getActiveCode() {
		return activeCode;
	}
	/**
	 * @param activeCode the activeCode to set
	 */
	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}
	/**
	 * @return the hasActive
	 */
	public int getHasActive() {
		return hasActive;
	}
	/**
	 * @param hasActive the hasActive to set
	 */
	public void setHasActive(int hasActive) {
		this.hasActive = hasActive;
	}
	

	
}