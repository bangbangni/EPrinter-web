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
    <div class="panel admin-panel">
  <div class="body-content">
    <form method="post" class="form-x" action="addEm">  
      
      <div class="form-group">
        <div class="label" >
        </div>
        <div class="field">
          <textarea name="content" class="input" style="height: 250px;border: 1px solid #ddd;margin-top: 25px;"></textarea>
        </div>
      </div>
      <div class="form-group">
      <div class="label"></div>
      <label></label>
      </div>
      <div class="field" style="float: right;right:  100px;">
        <button class="button bg-main icon-check-square-o" type="submit">提交</button>
      </div>
    </form>
  </div>
</div>
  </body>
</html>
