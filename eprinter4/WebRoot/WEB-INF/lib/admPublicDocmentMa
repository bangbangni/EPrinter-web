<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>adPubDocMa</title>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  </head>
  
  <body>
    <h1>文档</h1>
    <table>
    <tr>
    	<td>名称</td>
    	<td>大小</td>
    	<td>时间</td>
    	<td>操作</td>
    </tr>
    <c:forEach var="file" items="${files}">
    <tr>
     	<td>${file.fileName}</td>
     	<td>${file.fileSize}MB</td>
     	<td>${file.uploadTime}</td>	
     	<td><a href="downloadfile?fileName=${file.fileName}">下载</a></td>
     	<td><a href="FileDelete?fileId=${file.id}">删除</a></td>
    </tr> 
    </c:forEach>
    </table> 
    <c:forEach var="i"  begin="1" end="${pageCount}">
    	<a href="adPubDocMa?pageNow=${i }">${i }</a>
    </c:forEach>	
    
    <form action="upDocPub" method="post" enctype="multipart/form-data">  
	<input type="file" name="file" /> <input type="submit" value="Submit" /></form>  
   ${error }
    
  </body>
</html>
