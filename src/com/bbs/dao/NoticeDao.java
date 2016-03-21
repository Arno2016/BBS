package com.bbs.dao;

import java.util.List;

import com.bbs.model.Notice;

public interface NoticeDao {

	public  List<Notice> getNotice(int pageIndex, int pageSize);

	public  void publish(Notice notice);

}