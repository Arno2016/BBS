<%@page import="com.bbs.model.Post"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>

<html lang="en">
<head>
    <title>Title</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/search-result.css" rel="stylesheet"/>
    <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <link href="css/titlebar.css" rel="stylesheet">
    
</head>

  
  <body>
  <nav class="navbar navbar-inverse" role="navigation">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">BBS技术论坛</a>
            </div>
            <% String username  = (String)session.getAttribute("username");
            System.out.println("一登陆的用户名："+username);
            if (username == null){
             %>                                 
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<%=request.getContextPath()%>/login.jsp">登陆</a></li>
                <li><a href="<%=request.getContextPath()%>/regist.jsp">注册</a></li>
            </ul>
            <p class="navbar-text navbar-right">尊敬的游客您好！</p>
   
            <%}
            else {
             %>
               <ul class="nav navbar-nav navbar-right user">

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            张建浩 <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">设置</a></li>
                            <li><a href="#">个人中心</a></li>
                            <li class="divider"></li>
                            <li><a href="#">退出登陆</a></li>
                        </ul>
                    </li>
                </ul>
                 <p class="navbar-text navbar-right">尊敬的用户您好！</p>
                <%
                }
             %>
            </nav>
  
   <div class="list-group search-list">
    <a href="#" class="list-group-item active">
    
    <%
    	List<Post> posts = (List)request.getAttribute("posts");
    	if (posts.size()>0){
    %>
        搜索结果如下：
   
    <%}
    	else {
    %>
    抱歉！未找到符合的结果
    <%} %>
     </a>
    <%
        	for (Post post:posts){
     %>
    <a href="<%=path+"/postDetail.action?postId="+post.getId()%>" class="list-group-item">
            <h4 class="list-group-item-heading">
                [<%=post.getSubForum().getMainForum().getTitle() %>]
            </h4>
            <%=post.getTitle()%>&nbsp[<%=post.getSubForum().getTitle() %>]
            <p class="text-right post-date"><%=post.getSendDate()%></p>
    </a>
    <%} %>
</div>
  </body>
</html>
