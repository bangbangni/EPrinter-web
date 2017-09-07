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
    <%-- <h1>选择打印机</h1> <br>
    <table>
    <tr>
    	<td>型号</td>
    	<td>位置</td>
    	<td>操作</td>
    </tr>
    <c:forEach var="printer" items="${printers}">
    <tr>
     	<td>${printer.priNumber}</td>
     	<td>${printer.priLocal}</td>
     	<td>  
     		<select id="pageSizes" name="pageSizes">
            <option value="ISO_A4" >A4</option>
            <option value="ISO_A3">A3</option>
            </select>
     	 </td>
     	<td><a href="printFilePdf?printId=${printer.id}&pageSizes=A4">选择</a></td>
     	
    </tr>
    </c:forEach>
    </table> --%>
    <form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="padding border-bottom">
      
    </div>
    <table class="table table-hover text-center">
    
      <tr>
        <th width="5%"></th>
        <th width="40%">型号</th>
        <th width="20%">位置</th>
        <th>选择纸张</th>
        <th width="310">操作</th>
      </tr>
      <volist name="list" id="vo">
      <c:forEach var="printer" items="${printers}">
        <tr>
          <td style="text-align:left; padding-left:20px;"><input type="checkbox" name="id[]" value="" />
           </td>
          <td>${printer.priNumber}</td>
          <td>${printer.priLocal}</td>
          <td>
          <div class="field" style="margin-left:80px;">
          <select id="pageSizes" name="pid" class="input w5">
            <option value="A4">A4</option>
            <!-- <option value="">A1</option>
            <option value="">A2</option> -->
            <option value="A3">A3</option>
          </select>
    	</div></td>
          <td><div class="button-group"> 
          <a class="button border-main" onclick="location.href='printFilePdf?printId=${printer.id}&pageSizes='+document.getElementById('pageSizes').value"><span class="icon-print"></span> 打印</a> </div></td>
        </tr>
        </c:forEach>
     </volist>
    </table>
  </div>
</form>

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
</script>
  </body>
</html>
