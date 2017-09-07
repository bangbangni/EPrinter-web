<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/pintuer.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/admin.css" type="text/css">
	<script src="<%=request.getContextPath() %>/resource/js/pintuer.js"></script> 
	<script src="<%=request.getContextPath() %>/resource/js/jquery.js"></script> 
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	

  </head>
  
  <body>
    <%-- <a >添加用户</a>
    <br>
     <table>
    <tr>
    	<td>工号</td>
    	<td>名字</td>
    	<td>角色</td>
    	<td>创建时间</td>
    	<td>状态</td>
    	<td>可用空间</td>
    	<td>操作</td>
    </tr>
    <c:forEach var="em" items="${employees}">
    <tr>
     	<td>${em.emNumber}</td>
     	<td>${em.emName}</td>
     	<td><c:if  test="${em.role ==0}"> 员工</c:if>
     		<c:if  test="${em.role !=0}"> 职员</c:if>
     	</td>
     	<td>${em.creteTime}</td>
     	<td><c:if  test="${em.isBlock ==0}"> 正常</c:if>
     		<c:if  test="${em.isBlock !=0}"> 禁用</c:if>
     	</td> 
     	<td>${em.emRoom}MB</td>
     	<td><a href="EmDelete?emId=${em.id}&block=${em.isBlock}">
     		<c:if  test="${em.isBlock ==0}"> 禁用</c:if>
     		<c:if  test="${em.isBlock !=0}"> 启用</c:if></a></td>
     	<td><a href="mangerEmLog?emId=${em.id}">查看日志</a></td>
    </tr> 
    </c:forEach>
    </table> 
    <c:forEach var="i"  begin="1" end="${pageCount}">
    	<a href="adminManger?pageNow=${i }">${i }</a>
    </c:forEach>	 --%>  
    
  <form method="post" action="">
  <div class="panel admin-panel">
    <div class="padding border-bottom">
      <ul class="search">
        <li>
          <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
          <button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button>
         <a class="button border-main icon-plus-square-o" href="adminAddEm"> 添加用户</a>

        </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>    	
        <th></th>
        <th width="20%">工号</th>
        <th>姓名</th>   
        <th>角色</th>    
        <th>创建时间</th>  
        <th>状态</th>
        <th>可用空间</th>
        <th>操作</th>  
      </tr>  
       <c:forEach var="em" items="${employees}">    
        <tr>
          <td><input type="checkbox" name="id[]" value="1" />
            </td>
          <td>${em.emNumber}</td>
          <td>${em.emName}</td>
          <td><c:if  test="${em.role ==0}"> 员工</c:if>
     		  <c:if  test="${em.role !=0}"> 职员</c:if></td>  
     	  <td>${em.creteTime}</td>
     	  <td><c:if  test="${em.isBlock ==0}"> 正常</c:if>
     		<c:if  test="${em.isBlock !=0}"> 禁用</c:if>
     	</td> 
          <td>${em.emRoom}MB</td>
          <td>
          <div style="width:150px;">
          <div class="button-group"> <a class="button border-blue" href="mangerEmLog?emId=${em.id}" onclick="return info(1)"><span class="icon-info"></span> 详情</a> </div>
          <div class="button-group"> <a class="button border-red" href="EmDelete?emId=${em.id}&block=${em.isBlock}" onclick="return del(1)"><span class="icon-pause"></span><c:if  test="${em.isBlock ==0}"> 禁用</c:if>
     		<c:if  test="${em.isBlock !=0}"> 启用</c:if></a> </div>
     		</div>
     		</td>
        </tr>
      </c:forEach>
      <tr>
        <td colspan="8"><div class="pagelist"> <a href="adminManger?pageNow=1">首页</a> 
        <c:forEach var="i"  begin="1" end="${pageCount}">
        <span class="pagelist"><a href="adminManger?pageNow=${i }">${i }</a></span>
        </c:forEach>
        <%-- <a href="adminManger?pageNow=${i }">下一页</a> --%>
       <a href="adminManger?pageNow=${pageCount}">尾页</a> </div></td>
      </tr>
    </table>
  </div>
</form>
<script type="text/javascript">

function del(id){
	if(confirm("您确定要禁用此用户吗?")){
		
	}
}

$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false; 		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

</script>
  </body>
</html>
