package com.bbs.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userName;
	private String password;
	private String photoUrl;
	private String email;
	private Integer type;
	private Timestamp registerDate;
	private String signature;
	private Integer level;
	private String activeCode;
	private Integer hasActive;
//	private Set posts = new HashSet(0);
//	private Set followcards = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userName, String password, String email, Integer type,
			Timestamp registerDate, Integer level) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.type = type;
		this.registerDate = registerDate;
		this.level = level;
	}

	/** full constructor */
	public User(String userName, String password, String photoUrl,
			String email, Integer type, Timestamp registerDate,
			String signature, Integer level, String activeCode,
			Integer hasActive) {
		this.userName = userName;
		this.password = password;
		this.photoUrl = photoUrl;
		this.email = email;
		this.type = type;
		this.registerDate = registerDate;
		this.signature = signature;
		this.level = level;
		this.activeCode = activeCode;
		this.hasActive = hasActive;
		
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhotoUrl() {
		return this.photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Timestamp getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getActiveCode() {
		return this.activeCode;
	}

	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}

	public Integer getHasActive() {
		return this.hasActive;
	}

	public void setHasActive(Integer hasActive) {
		this.hasActive = hasActive;
	}

	
}