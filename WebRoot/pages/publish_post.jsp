<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发布帖子</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link href="css/titlebar.css" rel="stylesheet">

  </head>
  
  <body>
  	
  	<script type="text/javascript" src="component/ckeditor/ckeditor.js"></script>
    <script type="text/javascript">
        //下拉框

        var $$ = function (id) {
            return document.getElementById(id);
        }
        window.onload = function () {
           
            var big_btnSelect = $$("big_btn_select");
            var big_curSelect = big_btnSelect.getElementsByTagName("button")[0];
            var big_oSelect = big_btnSelect.getElementsByTagName("select")[0];
            var big_aOption = big_btnSelect.getElementsByTagName("option");
            big_oSelect.onchange = function () {
                var text1 = big_oSelect.options[big_oSelect.selectedIndex].text;
                big_curSelect.innerHTML = text1;
            }
            var btnSelect = $$("small_btn_select");
            var curSelect = btnSelect.getElementsByTagName("button")[0];
            var oSelect = btnSelect.getElementsByTagName("select")[0];
            var aOption = btnSelect.getElementsByTagName("option");
            oSelect.onchange = function () {
                var text2 = oSelect.options[oSelect.selectedIndex].text;
                curSelect.innerHTML = text2;
            }
        }
       
      
    </script>
    <style type="text/css">
        .tb {
            margin: 0 auto;
        }



            .tb tr th, .tb tr td {
                BORDER-left: #c2daf2 1px solid;
                BORDER-top: #c2daf2 1px solid;
                font-weight: normal;
                color: #000;
                background-repeat: repeat-x;
                FONT-SIZE: 9pt;
                FONT-FAMILY: Arial, "宋体";
                padding: 10px;
            }

            .tb tr th {
                width: 180px;
                background-color: #eff5fb;
            }

            .tb tr td {
                width: 800px;
                background-color: #f5f5f5;
            }

            .tb tr input {
                width: 500px;
            }

            .tb tr span {
                color: red;
            }

        .tab {
            width: 80px;
            border: 1px solid #ddddde;
            height: 27px;
            background: -webkit-linear-gradient(#e3e3e3, #fff); /* Safari 5.1 - 6.0 */
            background: -o-linear-gradient(#e3e3e3, #fff); /* Opera 11.1 - 12.0 */
            background: -moz-linear-gradient(#e3e3e3, #fff); /* Firefox 3.6 - 15 */
            background: linear-gradient(#e3e3e3, #fff); /* 标准的语法 */
            text-align: center;
            line-height: 27px;
           
        }
           .tab:hover,.omg {
               background:#f5f5f5;
               border-bottom:1px solid #fff;
            }
        #small_btn_select {
            width: 120px;
          
        }
        #big_btn_select {
            width: 270px;
        }
        .btn-select {
            position: relative;
            display: inline-block;
           
            height: 35px;
          
            font: 14px/20px "Microsoft YaHei";
            color: #fff;
        }

            .btn-select .cur-select {
                position: absolute;
                display: block;
                width: 100%;
                height: 30px;
                
               text-align:center;
               
            }

           

            .btn-select select {
                position: absolute;
                top: 0;
                left: 0;
                width: 100%;
                height: 30px;
                opacity: 0;
                filter: alpha(opacity: 0;);
                font: 14px/20px "Microsoft YaHei";
                color: #000;
            }

                .btn-select select option {
                    text-indent: 10px;
                }

                    .btn-select select option:hover {
                        background-color: #f80;
                        color: #fff;
                    }
    </style>
    <table class="tb" cellspacing="0" cellpadding="3">
    <form method="post" action="<%=path%>/publish.action">
        <tr>
            <th>文章标题</th>
             
            <td>
                <input type="text" id="textfile" name="title" />
                <span>你可以输入30个字符</span>
            </td>
        </tr>
        <tr>
            <th>文章内容</th>
            <td>
                <button class="tab omg">编辑</button>
                 <button class="tab">预览</button>
                <input type="text" name="content" id="ckeditor"></input>
                <span style="float: right;">你还可以输入30000个字符</span>
            </td>
        </tr>
        <tr>
            <th>选择版块</th>
            <td>
                <div id="change" style="float:left">
                    <a class="btn-select" id="big_btn_select">
                        <button class="cur-select">-选择大版块-</button>
                        <select name="mainForum">
                            <option value="1">移动开发</option>
                            <option value="2">云计算</option>
                            <option value="3">Web开发</option>
                            <option value="4">开发语言框架</option>
                            <option value="5">数据库开发</option>
                            <option value="6">硬件/嵌入式开发</option>
                            <option value="7">Linux/Unix社区</option>
                        </select>
                    </a>
                     <a class="btn-select" id="small_btn_select">
                        <button class="cur-select">-选择小版块-</button>
                        <select name="subForum">
                            <option value="1">Android</option>
                            <option value="1">ios</option>
                            <option value="2">javaEE</option>
                            <option value="3">分布式计算</option>
                        </select>
                    </a>
                     
               
               <span style="float:left;line-height:35px;">请选择所要发帖的版块</span>
            </td>
        </tr>
        <tr>
            <th></th>
            <td>
               	<input type="submit" value="提交"/>
            </td>
        </tr>
        </form>
    </table>
    <script type="text/javascript">
        CKEDITOR.replace('ckeditor', { allowedContent: true });
    </script>
  </body>
</html>
