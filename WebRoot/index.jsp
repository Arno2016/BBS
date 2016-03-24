<%@page import="com.bbs.model.Notice"%>
<%@page import="com.bbs.biz.NoticeBiz"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.bbs.model.Post"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bbs.bizImpl.PostBizImpl"%>
<%@page import="com.bbs.biz.PostBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh" class="no-js">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>技术论坛</title>
<link rel="stylesheet" type="text/css" href="css/zzsc-demo.css">

   <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <link href="css/index.css" rel="stylesheet">

</head>

<body>

		 <jsp:include page="/pages/header.jsp"/>
		 
		 <div class="container user-info">
    <div class="row">
        <div class="col-xs-12">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="img/2.jpg" alt="...">
                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div class="item">
                        <img src="img/1.jpg" alt="...">
                        <div class="carousel-caption">
                        </div>
                    </div>

                    <div class="item">
                        <img src="img/2.jpg" alt="...">
                        <div class="carousel-caption">
                        </div>
                    </div>
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>

   
<div class="container" style="margin-top: 30px;">
    <div class="row">
        <div class="col-md-9">

            <ul class="list-group">
                <div class="list-group-item active">
                    论坛新帖
                    <a href="<%=request.getContextPath() %>/more.action?type=8&&page=1" style="float: right;color: white">更多>></a>
                    <!--<p style="float: right"></p>-->
                </div>
                
					  <%
					    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                  	   PostBiz postBiz = (PostBiz)context.getBean("postBiz");
					   List<Post> latestPosts = postBiz.getLatestPosts(1,6);
					     for (Post post:latestPosts){
					   %>
				
                
                <a href="<%=request.getContextPath()%>/postDetail.action?postId=<%=post.getId()%>" class="list-group-item">
                    <h4 class="list-group-item-heading">[<%=post.getSubForum().getMainForum().getTitle()%>]</h4>
                    <%=post.getTitle() %><span class="badge">新</span>
                    <p class="text-right" style="float: right;margin-right: 20px">发表日期:<%=post.getSendDate()%></p>
                </a>
				<%}%>
            </ul>

        </div>

        <div class="col-md-3">
            <ul class="list-group">
                <div class="list-group-item active">
                    论坛公告
                </div>
                  <%
                  	   
                  	    NoticeBiz noticeBiz = (NoticeBiz)context.getBean("noticeBiz");
                  	    List<Notice> notices = noticeBiz.getNotice(1,5);
                  	    for (Notice notice:notices){
                   %>
                         <a href="<%=request.getContextPath()%>/notice.action?noticeId=<%=notice.getId() %>" class="list-group-item"><%=notice.getContent()%></a>
                    <%} %>
            </ul>
               <a href="<%=request.getContextPath()%>/pages/publish_post.jsp" ><button type="button" class="btn btn-primary" style="width: 200px;height:50px;margin-left: 30px">我要发帖</button></a>
        </div>

        <div class="row">
            <div class="col-md-9" style="margin-left: 15px">
                <ul class="list-group">
                    <div class="list-group-item active">
                        论坛热帖
                        <a href="<%=request.getContextPath() %>/more.action?type=8&&page=1" style="float: right;color: white">更多>></a>
                    </div>
                     <%
				   
				  	List<Post> posts = postBiz.getBestPosts(1,6);
				  	for (Post post:posts){
				   %>
                    <a href="<%=request.getContextPath()%>/postDetail.action?postId=<%=post.getId()%>" class="list-group-item">
                        <h4 class="list-group-item-heading">[<%=post.getSubForum().getMainForum().getTitle()%>]</h4>
                            <%=post.getTitle() %><span class="badge">热</span>
                        <p class="text-right" style="float: right;margin-right: 20px">发表日期:<%=post.getSendDate()%></p>
                    </a>
                    
                     <%} %>
                </ul>
            </div>

            
    </div>
     <h3 style="margin-top: 20px;margin-left: 15px">板块分类</h3>
    <hr/>
      <div  class="container">
        <div class="row">
            <div class="col-md-3 col-sm-12">
                <a href="<%=request.getContextPath() %>/more.action?type=1&&page=1">
                <div class="main-forum">
                    <h3>移动开发</h3>
                    <span class="label label-success">android</span>
                    <span class="label label-info">ios</span>
                </div>
                </a>

            </div>
             <div class="col-md-3 col-sm-12">
          		 <a href="<%=request.getContextPath() %>/more.action?type=2&&page=1">
	                <div class="main-forum">
	                    <h3>web开发</h3>
	                    <span class="label label-success">javaEE</span>
	                    <span class="label label-info">.net</span>
	                </div>
                </a>
           </div>
             <div class="col-md-3 col-sm-12">
          		 <a href="<%=request.getContextPath() %>/more.action?type=3&&page=1">
	                <div class="main-forum">
	                    <h3>云计算</h3>
	                    <span class="label label-success">android</span>
	                    <span class="label label-info">ios</span>
	                </div>
                </a>
           </div>
             <div class="col-md-3 col-sm-12">
          		 <a href="<%=request.getContextPath() %>/more.action?type=4&&page=1">
	                <div class="main-forum">
	                    <h3>开发语言框架</h3>
	                    <span class="label label-success">android</span>
	                    <span class="label label-info">ios</span>
	                </div>
                </a>
           </div>
        <div class="row">
			<div class="col-md-3 col-sm-12">
          		 <a href="<%=request.getContextPath() %>/more.action?type=5&&page=1">
	                <div class="main-forum">
	                    <h3>数据库开发</h3>
	                    <span class="label label-success">javaEE</span>
	                    <span class="label label-info">.net</span>
	                </div>
                </a>
           </div>
             <div class="col-md-3 col-sm-12">
          		 <a href="<%=request.getContextPath() %>/more.action?type=6&&page=1">
	                <div class="main-forum">
	                    <h3>硬件/嵌入式开发</h3>
	                    <span class="label label-success">android</span>
	                    <span class="label label-info">ios</span>
	                </div>
                </a>
           </div>
             <div class="col-md-3 col-sm-12">
          		 <a href="<%=request.getContextPath() %>/more.action?type=7&&page=1">
	                <div class="main-forum">
	                    <h3>Linux/Unix</h3>
	                    <span class="label label-success">android</span>
	                    <span class="label label-info">ios</span>
	                </div>
                </a>
           </div>
        </div>

    </div>
     
 


 

 
</body>
</html>