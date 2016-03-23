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
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/ionicons.min.css">
<link rel="stylesheet" type="text/css" href="css/zzsc-demo.css">
<script src="js/modernizr-2.8.3.min.js"></script>

   <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <link href="css/titlebar.css" rel="stylesheet">

</head>
<style>
  * {

    margin:0 auto;
    padding: 0px;
    margin-left: 0px;
    margin-right: 0px;
    margin-top: 0px;
    
}
.top{
     padding: 3px 0px 0px 3%;
      height:30px;      
      background:#E0E0E0;
      margin:0 auto;
      width:1092.8px;
      border-bottom:1px solid #c6c7c6;   
      
}    
.top p{
     
      margin:3px;
}
.logo{
      width:1092.8px;
      height:105px;     
      margin:0 auto;
} 
#search_box { 
      width: 411px; 
      height: 40px; 
      border:2px solid #3ba018;
      margin: -42px 460px 40px 424px;
} 
#search_box #s { 
      float: left; 
      padding: 0; 
      margin: 6px 0 0 6px; 
      border: 0; 
      width:344px; 
      height:26px;
      background: none; 
      font-size: .8em; 
      
} 
#search_box #go { 
      float: right; 
      margin: 7px 10px 0 0; 
} 
.comment1{
      width:1092.8px;
      height:1200px;
      margin:0 auto;
       
       margin-top:-21px;
}
.focus{
      width:268px; 
      height:330px;
      border:1px solid #c1c1c1;
      float:right;
     
} 
.menu-container{
      width:1092.8px;
}
.fr{
      width:30px; 
      border:2px solid #eef4fa;
      }
.ri{
      width:717px;
      height:330px;
      float:left;
      border:1px solid #c1c1c1;
      
}
.kuang3{
      width:266px;
      height:30px;
      background-color:#dce9f8;
      
}

.kuang3 a {
      float:right;
      text-align: right;
      margin-right:13px;
}
.kuang3 p{
     padding:4px;
     font-weight:bold;
     
}
#start{ 
         position: absolute;
    margin:344px  0px 0px 864px;
     
}

.kuang{
      width:714.5px;
      height:30px;
      background-color:#dce9f8;
      
}
.list{
 margin: 0px 10px 10px;
 text-align: left; 
}
 <!--margin: top right bottom left -->
.list3 ul{
 
 padding: 0px;
}
.list3 li{
 margin: 4px 0px 0px 24px;
 width: 85% ;
 
}
.list3 li a{
 color: #777777;
 display: block;

}
.list3 li span{
 float: right;/*使span元素浮动到右面*/
 text-align: right;/*日期右对齐*/
}
.list3 li a:hover{
 color: #F00000;
}

.kuang a {
      float:right;
      text-align: right;
      margin-right:13px;
}
.kuang p{
     padding:4px;
     font-weight:bold;
     
}
.list{
 margin: 0px 10px 10px;
 text-align: left; 
}
 <!--margin: top right bottom left -->
.list ul{
 
 padding: 0px;
}
.list li{
 margin: 10px 0px -7px 50px;
 width: 80% ;
 
}
.list li a{
 color: #777777;
 display: block;
 padding: 2px 0px 4px 15px;
}
.list li span{
 float: right;/*使span元素浮动到右面*/
 text-align: right;/*日期右对齐*/
}
.list li a:hover{
 color: #F00000;
}

.ri1{    
      width:717px;    
      float:left;
      border:1px solid #c1c1c1;
      margin-top:20px;
}
.kuang1{
      width:714.5px;
      height:30px;
      background-color:#dce9f8;
      padding-top:3px;
}

.kuang1 a {
      float:right;
      text-align: right;
      margin-right:13px;
}
.kuang1 p{
     padding:4px;
     font-weight:bold;
}
.k{
  
  color:#606060; 
  font-weight:bold;
}
.k1{
  
  color:#606060; 
  font-weight:bold;
}
.k3{
  
  color:#606060; 
  font-weight:bold;
}
.list1{
 margin: 0px 10px 10px;
 text-align: left; 
}
 <!--margin: top right bottom left -->
.list1 ul{
 
 padding: 0px;
}
.list1 li{
 margin: 10px 0px -7px 50px;
 width: 85% ;
 
}
.list1 li a{
 color: #777777;
 display: block;
 padding: 2px 0px 4px 15px;
}
.list1 li span{
 float: right;/*使span元素浮动到右面*/
 text-align: right;/*日期右对齐*/
}
.list1 li a:hover{
 color: #F00000;
}
.ri4 {
    width: 1092.8px;
    float: left;
    border: 1px solid #c1c1c1;
    margin-top: 20px;
}
.kuang4 {
    width: 1091px;
    height: 30px;
    background-color: #dce9f8;
}
.k4{
  
  color:#606060; 
  font-weight:bold;
}
table.gridtable {
    width: 1091px;
    font-family: verdana,arial,sans-serif;
    font-size:16px;
    color:#808080;
    border-width: 1px;
    border-color: #666666;
    border-collapse: collapse;
}
table.gridtable th {
    border-width: 1px;
    padding: 8px;
    border-style: solid;
    border-color: #666666;
    background-color: #dedede;
}
.gridtable  a {
    color: #777777;
    display: block;
    padding: 2px 0px 4px 15px;
}

table.gridtable a:hover{
 color: #F00000;
}
.logo img{
margin: 30px 0px 0px 20px;
}

</style>
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
 <!-- 这是放logo和搜索等功能 -->    
 <div class="logo"> 
   
  <img  src="img/logo.png " width="178" height="43"></img>
       <div id="search_box"> 
      
       <form id="search_form" method="post" action="<%=request.getContextPath()%>/search.action"> 
       <input type="text" id="s" name="keywords" class="swap_value" /> 
       <input type="image" src="img/btn_search_box.gif" width="27" height="24" id="go" alt="Search" title="Search" /> 
       </form> 
       </div> 
         </div>                 
      </div>   
<!-- 导航栏 -->

 <div class="menu-container">
	<div class="menu">
		<ul>
			<li><a href="#">首页</a></li>
			<li><a href="#">精选模板</a>
				<ul>
					<li><a href="#">移动开发</a>
						<ul>
							<li><a href="#">ios</a></li>
							<li><a href="#">Andriod</a></li>
							<li><a href="#">Qt</a></li>
							<li><a href="#">WP</a></li>
						</ul>
					</li>
					<li><a href="#">云计算</a>
						<ul>
							<li><a href="#">IaaS</a></li>
							<li><a href="#">Pass/SaaS</a></li>
							<li><a href="#">分布式计算/Hadoop</a></li>
						</ul>
					</li>
					<li><a href="#">Java技术</a>
						<ul>
							<li><a href="#">Java SE</a></li>
							<li><a href="#">Java Web 开发</a></li>
							<li><a href="#">Java EE</a></li>
							<li><a href="#">Java其他相关</a></li>
						</ul>
					</li>
					<li><a href="#">.NET技术</a>
						<ul>
							<li><a href="#">.NET Framework</a></li>
							<li><a href="#">C#</a></li>
							<li><a href="#">.NET分析与设计</a></li>
							<li><a href="#">ASP .NET</a></li>
							<li><a href="#">VB .NET</a></li>
						</ul>
					</li>
					
					<li><a href="#">Web开发</a>
						<ul>
							<li><a href="#">PHP</a></li>
							<li><a href="#">JavaScript</a></li>
							<li><a href="#">ASP</a></li>
							<li><a href="#">HTML(CSS)</a></li>
							<li><a href="#">HTML5</a></li>
							<li><a href="#">Apache</a></li>
						</ul>
					</li>
					<li><a href="#">开发语言/框架</a>
						<ul>
							<li><a href="#">Delphi</a></li>
							<li><a href="#">VC/MFC</a></li>
							<li><a href="#">VB</a></li>
							<li><a href="#">C/C++</a></li>
							<li><a href="#">C++ Builde</a></li>
							<li><a href="#">其他开发语言</a></li>
						</ul>
					</li>
					<li><a href="#">数据库开发</a>
						<ul>
							<li><a href="#">MS-SQL Server</a></li>
							<li><a href="#">Oracle</a></li>
							<li><a href="#">PowerBuilder</a></li>
							<li><a href="#">Informatica</a></li>
							<li><a href="#">其他数据库开发</a></li>
						</ul>
					</li>
					<li><a href="#">硬件/嵌入式开发</a>
						<ul>
							<li><a href="#">嵌入开发(WinCE)</a></li>
							<li><a href="#">驱动开发/核心开发</a></li>
							<li><a href="#">硬件设计</a></li>
							<li><a href="#">单片机/工控</a></li>
							<li><a href="#">汇编语言</a></li>
							<li><a href="#">VxWorks开发</a></li>
						</ul>
						
						<li><a href="#">Linux/Unix社区</a>
						<ul>
							<li><a href="#">嵌入开发(WinCE)</a></li>
							<li><a href="#">系统维护与使用区</a></li>
							<li><a href="#">应用程序开发区</a></li>
							<li><a href="#">内核源代码研究区</a></li>
							<li><a href="#">驱动程序开发区</a></li>
							<li><a href="#">>CPU和硬件区</a></li>
						</ul>
					</li>
				</ul>
			</li>
			<li><a href="#">论坛帮助</a>
				
			</li>
			<li><a href="#">关于我们</a></li>				
			
		</ul>
	</div>
</div>

<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="js/megamenu.js"></script>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">

</div>
<!--论坛的主题部分  -->
<div class="comment1">
 <div class="focus">
        <div class="kuang3">
  
  <span class="k3">论坛公告</span> <a href="#" target="_blank">更多</a> 
   </div>   
                  <ul class="list3">
                  <%
                  	    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                  	    NoticeBiz noticeBiz = (NoticeBiz)context.getBean("noticeBiz");
                  	    List<Notice> notices = noticeBiz.getNotice(1,5);
                  	    for (Notice notice:notices){
                  	    
                  	
                   %>
                        <li><a href="<%=request.getContextPath()%>/notice.action?noticeId=<%=notice.getId() %>" class="title_style_black" target="_blank"><%=notice.getContent()%></a></li>
                       
                        <%} %>
                  </ul>
            </div>
<!-- 我要发帖 -->
   
     <form id="search_form" method="post" action="<%=request.getContextPath()%>/pages/publish_post.jsp"> 
     
      <input type="image" src="img/btn_ask.png" width="200" height="50" id="start"/> 
      
     </form> 
  
  <div class="ri">  
  <div class="kuang">  
  <span class="k">论坛热帖</span> <a href="#" target="_blank">更多</a> 
   </div>
  <ul class="list" >
  <%
    PostBiz postBiz = (PostBiz)context.getBean("postBiz");
  	List<Post> posts = postBiz.getBestPosts(1,10);
  	for (Post post:posts){
   %>
   <li><span><%=post.getSendDate()%></span><a href="<%=request.getContextPath()%>/postDetail.action?postId=<%=post.getId()%>"><%=post.getTitle() %></a></li>
    <%} %>
</ul>
 </div>

 <div class="ri1">
  <div class="kuang1">
   <span class="k1">论坛新帖</span> <a href="#" target="_blank">更多</a>
  </div>
  <ul class="list1">
  <% List<Post> latestPosts = postBiz.getLatestPosts(1,10);
     for (Post post:latestPosts){
   %>
   <li><span><%=post.getSendDate()%></span><a href="<%=request.getContextPath()%>/postDetail.action?postId=<%=post.getId()%>"><%=post.getTitle() %></a></li>
<%}%>

</ul>
</div>
 <!-- 友情链接 -->
 <div class="ri4">
 <div class="kuang4" >
 <span class="k4">友情链接</span> </div>
 <table class="gridtable">
<tr>
    <td><a href="#">Info Header 1</a></td>
    <td><a href="#">Info Header 1</a></td>
    <td><a href="#">Info Header 1</a></td>
    <td><a href="#">Info Header 1</a></td>
    <td><a href="#">Info Header 1</a></td>
    <td><a href="#">Info Header 1</a></td>
    <td><a href="#">Info Header 1</a></td>  
    </tr>
    <tr>
    <td><a href="#">Info Header 1</a></td>
    <td><a href="#">Info Header 1</a></td>
    <td><a href="#">Info Header 1</a></td>
     <td><a href="#">Info Header 1</a></td>
    <td><a href="#">Info Header 1</a></td>
    </tr>

</table>

 </div>
</div>

</body>
</html>