package com.bbs.dao;

import java.util.List;

import com.bbs.model.MainForum;

public interface MainForumDao {

	public abstract void save(MainForum transientInstance);

	public abstract void delete(MainForum persistentInstance);

	public abstract MainForum findById(java.lang.Integer id);

	public abstract List findByExample(MainForum instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByTitle(Object title);

	public abstract List findByInfo(Object info);

	public abstract List findAll();

	public abstract MainForum merge(MainForum detachedInstance);

	public abstract void attachDirty(MainForum instance);

	public abstract void attachClean(MainForum instance);

}