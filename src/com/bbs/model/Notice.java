package com.bbs.model;

import java.sql.Timestamp;

/**
 * Notice entity. @author MyEclipse Persistence Tools
 */

public class Notice implements java.io.Serializable {

	// Fields

	private Integer id;
	private Admin admin;
	private String content;
	private Timestamp noticeDate;

	// Constructors

	/** default constructor */
	public Notice() {
	}

	/** minimal constructor */
	public Notice(Admin admin, Timestamp noticeDate) {
		this.admin = admin;
		this.noticeDate = noticeDate;
	}

	/** full constructor */
	public Notice(Admin admin, String content, Timestamp noticeDate) {
		this.admin = admin;
		this.content = content;
		this.noticeDate = noticeDate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getNoticeDate() {
		return this.noticeDate;
	}

	public void setNoticeDate(Timestamp noticeDate) {
		this.noticeDate = noticeDate;
	}

}