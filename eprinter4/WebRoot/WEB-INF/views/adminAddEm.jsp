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
    <!-- <form action="addEm" method="post">
    	<table border="1">
  <tr>
    <th>信息</th>
    <th>填写</th>
  </tr>
  <tr>
    <td>姓名</td>
    <td><input type="text" id="name" name="name"></td>
  </tr>
   <tr>
    <td>员工号</td>
    <td><input type="text" id="emId" name="emId"></td>
  </tr>
   <tr>
    <td>邮箱</td>
    <td><input type="text" id="email" name="email"></td>
  </tr>
   <tr>
    <td>电话</td>
    <td><input type="text" id="tel" name="tel"></td>
  </tr>
  <tr ><td colspan="2" align="center"><input type="submit" value="提交"></td></tr>
</table>
    
    </form> -->
    
    <div class="panel admin-panel">
  <div class="body-content">
    <form method="post" class="form-x" action="addEm">  
      <div class="form-group">
        <div class="label">
          <label>用户ID：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="emId" id="emId" data-validate="required:请输入ID" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>用户名：</label>
        </div>
        <div class="field">
          <input type="text"  name="name" id="name" class="input tips" style="width:25%; float:left;"  value="" data-place="right"  data-validate="required:请输入用户名"/>
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label>邮箱：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="email" id="email" />
          <div class="tips"></div>
        </div>    
      </div>
      <div class="form-group">
        <div class="label">
          <label>电话：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="tel" id="tel" />
          <div class="tips"></div>
        </div>    
      </div>
     
      <div class="clear"></div>
      
      
      <div class="form-group" >
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
