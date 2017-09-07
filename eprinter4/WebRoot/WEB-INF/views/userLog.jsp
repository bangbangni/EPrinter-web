<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户日志</title>
    
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  </head>
  
  <body>
   登录次数： ${Allnumber}
    <br>
    <%int i=0; %>
    <c:forEach var="number" items="${numbers}">
                第<%=++i %>月登录次数：
    	${number}<br>
    </c:forEach>
    <br>
    <h1>图像</h1>
     ${chart.setVisible(true)}
  </body>
</html>
