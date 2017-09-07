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
    <div class="panel admin-panel">
  <div class="padding border-bottom">
  </div>
  <table class="table table-hover text-center">
    <tr>
      <th width="30%">ID</th>
      <th width="10%">姓名</th>
      <th width="45%">空间</th>
      <th width="35%">操作</th>
    </tr>
   <c:forEach var="employee" items="${employees}">
    <tr>
      <td>${employee.emNumber }</td>     
      <td>${employee.emName }</td>     
      <td>${employee.usedRoom }/${employee.emRoom }</td>
      <td><div class="button-group" style="width:150px;">
      <a class="button border-green" href="adAddEmSpc?emId=${ employee.id}"><span class="icon-plus"></span>扩充</a>
      <a class="button border-green" href="adSubEmSpc?emId=${ employee.id}"><span class="icon-minus"></span>减小</a>
      </div></td>
    </tr>
   </c:forEach> 
          <tr>
        <td colspan="8">
        <div class="pagelist">
         <a href="adSpcEmMa?pageNow=1">首页</a> 
         <c:forEach var="i"  begin="1" end="${pageCount}">
         <span class="current"><a href="adSpcEmMa?pageNow=${i }">${i }</a></span>
         </c:forEach>
         <a href="adSpcEmMa?pageNow=${pageCount }">尾页</a> 
         </div>
         </td>
      </tr>
  </table>
</div>
<script type="text/javascript">
function del(id,mid){
	if(confirm("您确定要删除吗?")){
	
	}
}
</script>


  </body>
</html>
