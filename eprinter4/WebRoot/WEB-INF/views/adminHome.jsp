<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>  
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/pintuer.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/admin.css" type="text/css">
	<script src="<%=request.getContextPath() %>/resource/js/pintuer.js"></script> 
	<script src="<%=request.getContextPath() %>/resource/js/jquery.js"></script> 
  </head>
  
    <body style="background-color:#f2f9fd;">
   <%-- <h1>日期${loginTime}             用户名${admin.name}</h1>
    <a  href="adminManger">用户管理</a>
     <br>
    <a href="adminPrinterMa">打印机管理</a>
    <br>
    <a href="modifyAdmin">修改个人信息</a>
    <br>
    <a href="admPublicDocmentMa">公共文档</a> --%>   
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="resource/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
  </div>
  <div class="head-l"> &nbsp;&nbsp;<a class="button button-little bg-red" href="goOut"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
   <h2><a><span class="icon-user"></span></a>用户管理</h2>
  <ul style="display:block">
    <li><a href="adminManger" target="right"><span class="icon-caret-right"></span>添加/禁用用户</a></li>
    <li><a href="userpwManage" target="right"><span class="icon-caret-right"></span>用户密码管理</a></li>
    <li><a href="adSpcEmMa" target="right"><span class="icon-caret-right"></span>用户空间管理</a></li>   
  </ul>  


<h2><a><span class="icon-file"></span></a>公共文档</h2>
<ul>
  <li><a href="admPublicDocmentMa" target="right"><span class="icon-caret-right"></span>公共文档管理</a></li>
  
</ul>
<h2><a><span class="icon-print"></span></a>打印机</h2>
<ul>
  <li><a href="adminPrinterMa" target="right"><span class="icon-caret-right"></span>打印机管理</a></li>
</ul>
<h2><a><span class="icon-pencil-square-o"></span></a>密码</h2>
  <ul>
    <li><a href="modifyAdmin"><span class="icon-caret-right"></span>密码修改</a></li>
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
  <iframe scrolling="auto" rameborder="0" src="adminManger" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
</div>
</body>
</html>
