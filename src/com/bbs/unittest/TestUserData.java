package com.bbs.unittest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.bbs.constants.Constant;
import com.bbs.hibernate.factory.HibernateSessionFactory;
import com.bbs.model.User;
import com.bbs.utils.MailUtil;

/**
 * @author 张建浩、卜凡、卢静、余莎、姚文娜
 * @version 1.0
 * 2016年3月17日下午1:39:30
 */
public class TestUserData {

	@Test
	public void test() {
		
		testMail();
	}
	
	public void testHQL(){
		Session session = HibernateSessionFactory.getSession();
		String sql = "from User user where username=?";
		Query query = session.createQuery(sql);
		query.setString(0, "aa");
		List<User> users = query.list();
		System.out.println(users.size());
	}
	
	public void testMail(){
		Properties properties = new Properties();
		try {
			;
			URL uri = getClass().getClassLoader().getResource("com//bbs//unittest//mail.properties");
			if (uri == null)
				System.out.println("meiyou ");
			properties.load(this.getClass().getClassLoader().getResourceAsStream("com/bbs/utils/mail.properties"));
		} 
			catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String username = properties.getProperty("username");
	    String password = properties.getProperty("password");
	    String mailHost = properties.getProperty("mailHost");
	    String fromAddres = properties.getProperty("fromAddress");
	    
	    System.out.print(username+password);
	    
	    try {
	    	MailUtil mail = new MailUtil();
			mail.sendEmail("1519503862@qq.com", "12345", Constant.ACTIVE_EMAIL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
}
