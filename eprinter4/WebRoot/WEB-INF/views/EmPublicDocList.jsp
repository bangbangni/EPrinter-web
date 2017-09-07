<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/pintuer.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/admin.css" type="text/css">
	<script src="<%=request.getContextPath() %>/resource/js/pintuer.js"></script> 
	<script src="<%=request.getContextPath() %>/resource/js/jquery.js"></script> 
  </head>
  
  <body>
    <form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <div class="search123">
        <!-- <li>
          <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li> -->
          <li>
          <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block ;border-radius:35px;border-style: inset;" />
          <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()">搜索</a></li>
        </div>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="5%"></th>
        <th width="40%">名称</th>
        <th width="">大小</th>
        <th width="8%">上传时间</th>
        <th width="310px">操作</th>
      </tr>
      <volist name="list" id="vo">
      <c:forEach var="file" items="${files}">
        <tr>
          <td style="text-align:left; padding-left:20px;"><input type="checkbox" name="id[]" value="" />
           </td>
          <td>${file.fileName}</td>
          <td>${file.fileSize}MB</td>
          <td>${file.uploadTime}</td>
          
          <td><div class="button-group" style="width:200px;"> <a class="button border-main" href="downloadfile?fileName=${file.fileName}"><span class="icon-download"></span> 下载</a>
          <a class="button border-main" href="printTransferSet?fileId=${file.id }"><span class="icon-print"></span> 打印选项</a> </div></td>
        </tr>
        </c:forEach>
      <tr>
        <td colspan="8"><div class="pagelist"> 
        <a href="EmPublicDoc?pageNow=1">首页</a> 
        <c:forEach var="i"  begin="1" end="${pageCount}">
        <span class="current"><a href="EmPublicDoc?pageNow=${i }">${i }</a></span>
        </c:forEach>
       <a href="EmPublicDoc?pageNow=${pageCount}">尾页</a> </div></td>
      </tr>
    </table>
  </div>
</form>


  </body>
</html>
