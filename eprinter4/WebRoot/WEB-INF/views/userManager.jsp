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
<%--   账号：${employee.emNumber}<br>
 登录次数：${Allnumber}<br>
 上次登录时间：${lastIp}<br>
上次登录IP：${lastTime}<br>
  
 <form action="EmployeeModifyPassword" method="post">
      原始密码：<input type="password" name="password1">
  <br>
      新密　码：<input type="password" name="password2">
   <br>
      确　　认：<input type="password" name="password3">
   <br>
  <input type="submit" value="确认">
  </form> --%>
  
  <div class="panel admin-panel margin-top">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改密码</strong></div>
  <div class="body-content">
  <div class="panel admin-panel">
  <div class="body-content">
    <form method="post" class="form-x" action="EmployeeModifyPassword">  
      <div class="form-group">
        <div class="label">
          <label>账号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${employee.emNumber}" readonly name="priNumber"  />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>登录次数：</label>
        </div>
        <div class="field">
          <input type="text" id="url1"  name="priLocal" class="input w50"   value="${Allnumber}" readonly data-place="right"  />
        </div>
      </div> 
      
      <div class="form-group">
        <div class="label">
          <label>上次登录时间：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${lastTime}" name="priName"   value="" readonly data-place="right"  />
          <div class="tips"></div>
        </div>    
      </div>
      <div class="form-group">
        <div class="label">
          <label>上次登录IP：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${lastIp}" readonly name="priIp"   data-place="right"  />
          <div class="tips"></div>
        </div>    
      </div> 
      <input type="hidden" name="id"  value="" />  
      <div class="form-group">
        <div class="label">
          <label>原密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="password1" value="" data-validate="required:请输入原密码" />         
          <div class="tips"></div>
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label>新密码：</label>
        </div>
        <div class="field">
          <input type="password" id="url1" name="password2" class="input tips" style="width:25%; float:left;"  value="" data-toggle="hover" data-place="right" data-validate="required:请输入新密码" />
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>确认新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="password3" value="" data-validate="required:请再次输入新密码" />         
          <div class="tips"></div>
        </div>
      </div>       
      
    
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

    
  </div>
</div>
  
  
  </body>
</html>
