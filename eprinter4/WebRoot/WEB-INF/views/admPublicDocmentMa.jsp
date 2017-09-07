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
    <%-- <h1>文档</h1>
    
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
    	<a href="admPublicDocmentMa?pageNow=${i }">${i }</a>
    </c:forEach>	
    
    <form action="upDocPub" method="post" enctype="multipart/form-data">  
	<input type="file" name="file" /> <input type="submit" value="Submit" /></form>  
   ${error }
    
  </body> --%>
  
  <form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="padding border-bottom">
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="5%"></th>
        <th width="40%">名称</th>
        <th width="">大小</th>
        <th width="10%">上传时间</th>
        <th width="310">操作</th>
      </tr>
      <volist name="list" id="vo">
      <c:forEach var="file" items="${files}">
        <tr>
          <td style="text-align:left; padding-left:20px;"><input type="checkbox" name="id[]" value="" />
           </td>
          <td>${file.fileName}</td>
          <td>${file.fileSize}MB</td>
          <td>${file.uploadTime}</td>
          <td><div class="button-group"> <a class="button border-main" href="downloadfile?fileName=${file.fileName}"><span class="icon-download"></span> 下载</a>
               <a class="button border-red" href="FileDelete?fileId=${file.id}" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
        </tr>
     </c:forEach>
      <tr>
        <td colspan="8"><div class="pagelist"> <a href="admPublicDocmentMa?pageNow=1">首页</a> 
        <c:forEach var="i"  begin="1" end="${pageCount}">
        <span class="current"><a href="admPublicDocmentMa?pageNow=${i }">${i }</a></span>
        </c:forEach>
       <a href="admPublicDocmentMa?pageNow=${pageCount}">尾页</a> </div></td>
      </tr>
    </table>
      
  </div>
</form>
<div style="margin: 0 auto;">
   <form action="upDocPub" method="post" enctype="multipart/form-data">  
	 <input type="file" name="file" />
	  <input type="submit" value="Submit" />
   </form> 
    </div>
   ${error }
<script type="text/javascript">

//搜索
function changesearch(){	
		
}

//单个删除
function del(id,mid,iscid){
	if(confirm("您确定要删除吗?")){
		
	}
}

//全选
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

//批量删除
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
		$("#listform").submit();		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

//批量排序
function sorts(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){	
		
		$("#listform").submit();		
	}
	else{
		alert("请选择要操作的内容!");
		return false;
	}
}


//批量首页显示
function changeishome(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");		
	
		return false;
	}
}

//批量推荐
function changeisvouch(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");	
		
		return false;
	}
}

//批量下载
function changeistop(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){		
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");		
	
		return false;
	}
}


//批量移动
function changecate(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){		
		
		$("#listform").submit();		
	}
	else{
		alert("请选择要操作的内容!");
		
		return false;
	}
}

//批量复制
function changecopy(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){	
		var i = 0;
	    $("input[name='id[]']").each(function(){
	  		if (this.checked==true) {
				i++;
			}		
	    });
		if(i>1){ 
	    	alert("只能选择一条信息!");
			$(o).find("option:first").prop("selected","selected");
		}else{
		
			$("#listform").submit();		
		}	
	}
	else{
		alert("请选择要复制的内容!");
		$(o).find("option:first").prop("selected","selected");
		return false;
	}
}

</script>
  
</html>
