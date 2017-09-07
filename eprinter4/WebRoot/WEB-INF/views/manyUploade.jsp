<%@ page pageEncoding="utf-8"%>  
<!DOCTYPE html>  
<html>  
<head>  
<meta charset="utf-8">  
<title>多文件上传</title>  
</head>  
<body>  
<form action="manyupload.do" method="post" enctype="multipart/form-data">  
file1:<input type="file" name="file" /> 
<br><br>
file2:<input type="file" name="file2" /> 
<br><br>
<input type="submit" value="Submit" />
</form>  
</body>  
</html> 