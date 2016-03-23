<%@page import="com.bbs.model.Followcard"%>
<%@page import="com.bbs.model.Post"%>
<%@page import="com.bbs.biz.PostBiz"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'post.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link href="css/titlebar.css" rel="stylesheet">

  </head>
  
  <body>
  
   <jsp:include page="/pages/header.jsp"/>
  	<%
  		Post post = (Post)request.getAttribute("post");
  		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
  		 PostBiz postBiz = (PostBiz)context.getBean("postBiz");
  	 %>
  	 发帖者：<%=post.getUser().getUsername()%><br/>
  	 帖子标题：<%=post.getTitle()%><br/>
  	 帖子内容：<%=post.getCardContent()%><br/>
  	 帖子所属板块：<%=post.getSubForum().getTitle()%><br/>
  	 楼主
  	 <hr/>
  	 <%
  	 	 List<Followcard> followcards = postBiz.getFollowCards(post.getId(), 1, 10);
  	 	 int floor = 1;
		for (Followcard followcard:followcards){
  	  %>
  	  回复者姓名：<%=followcard.getUser().getUsername()%><br/>
  	  回复内容：<%=followcard.getFollowContent()%><br/>
  	  第<%=floor%>楼
  	  <hr/>
  	  <%floor++;}%>

    回复 
    <form action="<%=path%>/reply.action" method="post">
    <input type="hidden" name="postId" value="<%=post.getId()%>">
    <input type="text" name="content">  	 
    <input type="submit" name="button" value="回复">
    </form>
    
  </body>
</html>
