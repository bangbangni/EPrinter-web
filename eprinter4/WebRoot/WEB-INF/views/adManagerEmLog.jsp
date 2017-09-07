<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adManagerEmLog.jsp' starting page</title>
    
	    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table>
    <tr><td>员工号：</td>
    	<td>${em.emNumber }</td>
    <tr><td>员工名：</td>
    	<td>${em.emName }</td>
    </tr>
    <tr><td>所用纸张总数：</td>
    	<td>${pages}</td>
    </tr>
    </table>
    每月情况：
     <br>
    <%int i=0; %>
    <c:forEach var="number" items="${YMpages}">
                第<%=++i %>月打印纸张数：
    	${number}张<br>
    </c:forEach>
    <br>
  </body>
</html>
