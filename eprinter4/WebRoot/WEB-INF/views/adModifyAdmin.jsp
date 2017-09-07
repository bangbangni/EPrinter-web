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
<%--     <h1>密码修改</h1>
    <form action="confirmModify" method="post">
    <table border="2">
    	<tr><td>旧密码：</td> <td><input type="password" name="lastPwd"></td></tr>
    	<tr><td>新密码：</td> <td><input type="password" name="fristPwd"></td></tr>
    	<tr><td>确认输入：</td> <td><input type="password" name="secondPwd"></td></tr>
    	<tr><td colspan="2"><input type="submit" value="确认">  ${error}</tr>
    </table>
    	
    </form> --%>
    
    <div class="panel admin-panel margin-top">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改密码</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="confirmModify">   
      <input type="hidden" name="id"  value="" />  
      <div class="form-group">
        <div class="label">
          <label>原密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="lastPwd" value="" data-validate="required:请输入原密码" />         
          <div class="tips"></div>
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label>新密码：</label>
        </div>
        <div class="field">
          <input type="text" id="url1" name="fristPwd" class="input tips" style="width:25%; float:left;"  value="" data-toggle="hover" data-place="right" data-validate="required:请输入新密码" />
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>确认新密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="secondPwd" value="" data-validate="required:请再次输入新密码" />         
          <div class="tips"></div>
        </div>
      </div>       
      
    
     <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
          ${error}
        </div>
      </div>
    </form>
  </div>
</div>
    
  </body>
</html>
