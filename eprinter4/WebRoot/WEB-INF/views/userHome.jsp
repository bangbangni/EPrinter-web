<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>用户界面</title>  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/pintuer.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/admin.css" type="text/css">
	<script src="<%=request.getContextPath() %>/resource/js/pintuer.js"></script> 
	<script src="<%=request.getContextPath() %>/resource/js/jquery.js"></script> 
</head>

<body style="background-color:#f2f9fd;">
	<%--   <h1>日期${loginTime}             用户名${employee.emName}</h1>
    <a  href="userManager">账户管理</a>
    <br>
    <a  href="Printdocument">打印文档</a>
      <br>
     <a href="FileManager">文档管理</a>
     <br>
    <a  href="userLog">统计日志</a> --%>
    <div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="resource/images/y1.jpg" class="radius-circle rotate-hover" height="50" />用户界面</h1>
  </div>
  <div class="head-l"> &nbsp;&nbsp;<a class="button button-little bg-green" href="main" target="_blank"><span class="icon-home"></span> 首页</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="goOut"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
   <h2><a href=""><span class="icon-user"></span></a>文档打印</h2>
  <ul style="display:block">
    <li><a href="EmPublicDoc" target="right"><span class="icon-caret-right"></span>公共文档打印</a></li>
    <li><a href="FileManager" target="right"><span class="icon-caret-right"></span>个人文档打印</a></li>   
  </ul>  

<h2><a><span class="icon-edit"></span></a>个人信息</h2>
<ul>
  <li><a href="userManager" target="right"><span class="icon-caret-right"></span>个人信息管理</a></li>
</ul>
<h2><a><span class="icon-arrow-up"></span></a>反馈</h2>
<ul>
  <li><a href="emFeedBack" target="right"><span class="icon-caret-right"></span>反馈信息</a></li>
</ul>
<h2><a><span class="icon-info"></span></a>日志记录</h2>
<ul>
  <li><a href="userLog" target="right"><span class="icon-caret-right"></span>日志详情</a></li>
</ul>

</div>



<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
    $(this).next().slideToggle(200);  
    $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
      $("#a_leader_txt").text($(this).text());
      $(".leftnav ul li a").removeClass("on");
    $(this).addClass("on");
  })
});
</script>

<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="FileManager" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
</div>
    


</body>
</html>
