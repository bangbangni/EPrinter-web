<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>  
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/pintuer.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/admin.css" type="text/css">
	<script src="<%=request.getContextPath() %>/resource/js/pintuer.js"></script> 
	<script src="<%=request.getContextPath() %>/resource/js/jquery.js"></script> 
  </head>
  
  <body>
    <%-- <a href="adminAddPrinter">添加打印机</a>
    <br>
    <a href="adminHome">返回首页</a>
    <table>
    <tr>
    	<td>编号</td>
    	<td>位置</td>
    	<td>型号</td>
    	<td>状态</td>
    	<td>操作</td>
    </tr>
     <c:forEach var="printer" items="${printers}">
    <tr>
     	<td>${printer.priNumber}</td>
     	<td>${printer.priLocal}</td>
     	<td>${printe.priName}</td>
     	<td><c:if  test="${printer.priState ==0}"> 正常</c:if>
     		<c:if  test="${printer.priState !=0}"> 禁用</c:if>
     	</td> 	
     	<td><a href="displayPrinter?priId=${printer.id }">修改信息</a></td>
     	
    </tr> 
    </c:forEach>
    </table>
    <c:forEach var="i"  begin="1" end="${pages}">
    	<a href="adminPrinterMa?pageNow=${i }">${i }</a>
    </c:forEach> --%>
    
    
    <div class="panel admin-panel">
  <table class="table table-hover text-center">
    <tr>
      <th width="5%">编号</th>     
      <th width="40%">位置</th>  
       <th>品牌</th> 
       <th>状态</th>  
      <th width="250">操作</th>
    </tr>
    <c:forEach var="printer" items="${printers}">
    <tr>
      <td>${printer.priNumber}</td>      
      <td>${printer.priLocal}</td>
      <td>${printer.priName}</td>  
      <td><c:if  test="${printer.priState ==0}"> 正常</c:if>
     		<c:if  test="${printer.priState !=0}"> 禁用</c:if>
     	</td>      
      <td>
      <div class="button-group">
      <a type="button" class="button border-main" href="displayPrinter?priId=${printer.id }"><span class="icon-edit"></span>修改</a>
       
      </div>
      </td>
    </tr> 
   </c:forEach>  
          <tr>
        <td colspan="8"><div class="pagelist"> <a href="adminPrinterMa?pageNow=1">首页</a> 
        <c:forEach var="i"  begin="1" end="${pages}">
        <span class="current"><a href="adminPrinterMa?pageNow=${i }">${i }</a></span>
        </c:forEach>
        <a href="adminPrinterMa?pageNow=${pages }">尾页</a> 
        </div></td>
      </tr>
  </table>
</div>
         <a class="button border-main icon-plus-square-o" href="adminAddPrinter"> 添加打印机</a>
    
    
  </body>
</html>
