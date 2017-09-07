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

  </head>
  
  <body>
   <%--  <form action="admodifyPrinter" method="post">
    <table>
    	
    	<tr><td>编　号</td>   <td><input type="text" value="${printer.priNumber }" name="priNumber"></td></tr>
    	<tr><td>位　置</td>   <td><input type="text" value="${printer.priLocal }" name="priLocal"></td></tr>
    	<tr><td>设备名</td>   <td><input type="text" value="${printer.priName }" name="priName"></td></tr>
    	<tr><td>Ip及端口</td> <td><input type="text" value="${printer.priIp }" name="priIp"></td></tr>
    	<tr><td>状　态</td>   <td><input type="text" value=" ${printer.priState ==0}" name="priState"></td></tr>
    	<tr><td colspan="2" align="center"><input type="submit" value="修改"></td></tr>
    </table>
    	<input type="hidden" name="priId" value="${printer.id }"> 
    </form> --%>
    
    <div class="panel admin-panel">
  <div class="body-content">
    <form method="post" class="form-x" action="admodifyPrinter">  
      <div class="form-group">
        <div class="label">
          <label>打印机编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${printer.priNumber }" name="priNumber" data-validate="required:请输入ID" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>位置：</label>
        </div>
        <div class="field">
          <input type="text" id="url1"  name="priLocal" class="input tips" style="width:25%; float:left;"  value="${printer.priLocal }" data-place="right"  data-validate="required:请输入用户名"/>
        </div>
      </div> 
      
      <div class="form-group">
        <div class="label">
          <label>型号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${printer.priName }" name="priName" style="width:25%; float:left;"  value="" data-place="right"  data-validate="required:请输入型号"/>
          <div class="tips"></div>
        </div>    
      </div>
      <div class="form-group">
        <div class="label">
          <label>IP及端口：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${printer.priIp }" name="priIp" style="width:25%; float:left;"  data-place="right"  data-validate="required:请输入IP及端口"/>
          <div class="tips"></div>
        </div>    
      </div>
     <div class="form-group">
        <div class="label">
          <label>状态：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="priState" style="width:25%; float:left;"  value="${printer.priState ==0}" data-place="right"  data-validate="required:请输入状态"/>
          <div class="tips"></div>
        </div>    
      </div>
     
     
      
      <input type="hidden" name="priId" value="${printer.id }"> 
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
  </body>
</html>
