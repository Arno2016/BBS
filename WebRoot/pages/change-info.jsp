<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'change-info.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <jsp:include page="/pages/header.jsp"/>
     
     
     <div class="container user-info">
    <div class="row">
        <div class="col-xs-3">
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation" class="active"><a href="#">资料修改</a></li>
                <li role="presentation"><a href="#">我的帖子</a></li>
            </ul>

        </div>

        <div class="col-xs-9">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        个人信息修改
                    </h3>
                </div>
                <div class="panel-body">


                    <div class="column">


                        <div class="form-group">
                            <img alt="@zhangjianhao" class="avatar left" height="70" src="https://avatars0.githubusercontent.com/u/11853067?v=3&amp;u=fed7eb6359173869cb89a97ae62368a6a0adc76f&amp;s=140" width="70" />
                            请上传你的头像<br/>

                        </div>
                        <input type="file" id="inputfile"><br/>

                        <div class="form-group">
                            <label for="name">用户名</label>
                            <input type="text" class="form-control" id="name" width="200px" height="80px"
                                   placeholder="请输入名称">
                        </div>

                        <div class="form-group">
                            <label for="name">性 别</label><br/>
                            男<input type="radio" name="sex" value="0"> &nbsp &nbsp女<input type="radio" name="sex" value="1">


                        </div>


                        <dl class="form-group">
                            <dt><label for="user_profile_blog">邮箱</label></dt>
                            <dd><input type="email" class="form-control" id="user_profile_blog" name="" size="30" value="1519503862@qq.com" /></dd>
                        </dl>
                        <dl class="form-group">
                            <dt><label for="user_profile_company">密码</label></dt>
                            <dd><input class="form-control" id="user_profile_company" name="" size="30" type="password" width="200px" /></dd>
                        </dl>
                        <dl class="form-group">
                            <dt><label for="user_profile_location">重复密码</label></dt>
                            <dd><input class="form-control" id="user_profile_location" name="" size="30" type="password" width="200px" /></dd>
                        </dl>
                        <p><button type="submit" class="btn btn-primary">确认修改</button></p>
                    </div>
                    </form>
                </div>
            </div>




                </div>
            </div>
        </div>
    </div>
</div>
     
     
  </body>
</html>
