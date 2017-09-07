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
<%-- 
		<h1>文档</h1>
		<a href="userHome">返回首页</a> <br>
		<form action="searchFile" method="post">
		搜索文档：<input type="text" name="filename" id="filename" value="文件名">
		<input type="submit" value="提交" >
		</form>
		<br>
    <table>
    <tr>
    	<td>名称</td>
    	<td>大小</td>
    	<td>时间</td>
    	<td>文件状态</td>
    	<td>操作</td>
    </tr>
    <c:forEach var="file" items="${files}">
    <tr>
     	<td>${file.fileName}</td>
     	<td>${file.fileSize}MB</td>
     	<td>${file.uploadTime}</td>
     	<td><c:if  test="${file.fileState ==0}"> 未打印</c:if>
     		<c:if  test="${file.fileState !=0}"> 已打印</c:if>
     	</td> 	
     	<td><a href="downloadfile?fileName=${file.fileName}">下载</a></td>
     	<td><a href="FileDelete?fileId=${file.id}">删除</a></td>
    </tr> 
    </c:forEach>
    </table> 
    <c:forEach var="i"  begin="1" end="${pageCount}">
    	<a href="FileManager?pageNow=${i }">${i }</a>
    </c:forEach>	 --%>
    
    <form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <div class="search123">
        <li>
          <input type="text" placeholder="请输入文档名" id="emDocName" name="emDocName" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a  class="button border-main icon-search" onclick="location.href='searchPublicFile?&emDocName='+document.getElementById('emDocName').value" > 搜索</a></li>
        </div>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="5%"></th>
        <th width="40%">名称</th>
        <th width="">大小</th>
        <th width="10%">上传时间</th>
        <th>状态</th>
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
          <td><c:if  test="${file.fileState ==0}"> 未打印</c:if>
     		  <c:if  test="${file.fileState !=0}"> 已打印</c:if>
     	  </td>
            <td><div class="button-group"><a class="button border-green" href="downloadfile?fileName=${file.fileName}" ><span class="icon-download"></span> 下载</a>
             <a class="button border-red" href="FileDelete?fileId=${file.id}" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a>
             <a class="button border-blue" href="printTransferSet?fileId=${file.id }" ><span class="icon-print"></span> 打印选项</a></div></td>
        </tr>
   		 </c:forEach>
      <tr>
        <td colspan="8"><div class="pagelist"> 
        <a href="searchFile?pageNow=1">首页</a> 
        <c:forEach var="i"  begin="1" end="${pageCount}">
        <span class="current"><a href="searchFile?pageNow=${i }">${i }</a></span>
        </c:forEach>
        <a href="searchFile?pageNow=${pageCount }">尾页</a> </div></td>
      </tr>
    </table>   
  </div>
</form>
    <form action="upload.do" method="post" enctype="multipart/form-data">  
<input type="file" name="file" /> <input type="submit" value="Submit" /></form>  
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

//批量置顶
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
  </body>
</html>
