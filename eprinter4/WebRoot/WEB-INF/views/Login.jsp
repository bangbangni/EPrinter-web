<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>登录</title>  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/pintuer.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/admin.css" type="text/css">
    <script src="resource/js/jquery.js"></script>
    <script src="resource/js/pintuer.js"></script>  
  </head>

  <body>
    <!-- <form action="employeelogin" method="post">
		id:<input type="text" name="emNumber" value=""></br>
		password:<input type="password" name="password" value=""></br>
		<input type="submit" value="提交">
	</form>
	</br></br> -->	
<!-- 	<form action="adminlogin" method="post">
		adminId:<input type="text" name="AdemNumber"></br>
		password:<input type="password" name="Adpassword"></br>
		<input type="submit" value="提交">
	</form> -->
	
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;">
            <div id="ProjectName">EPrinter Web</div>
            </div>
        <div class="media media-y margin-big-bottom">                    
            <form action="login" method="post">
            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top"><h1>登录</h1></div>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input input-big" name="AdemNumber" placeholder="请输入员工号" data-validate="required:请填写员工号" />
                            <span class="icon icon-user margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="password" class="input input-big" name="Adpassword" placeholder="请输入密码" data-validate="required:请填写密码" />
                            <span class="icon icon-key margin-small"></span>
                        </div>
                    </div>
                    <div class="text-center margin-big padding-big-top" style="position: relative;"> 
                    <div class="field" style="position: absolute; float: right; margin-left:140px;margin-top: -25px;">
                        <select name="selectId" class="input w5" style="margin-top:-5px;">
                             <option value="0">用户登录</option>
                             <option value="1">管理员登录</option>
                         </select>
                    </div>
                </div>
                </div>
                <div style="padding-left:15px;padding-right:15px;" ><input type="submit" class="button button-block bg-main text-big input-big" value="登录"></div>
            </div>
            </form>
            </div>
        </div>
    </div>
</div>
</div>
	
	

  </body>
</html>
