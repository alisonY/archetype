<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
	<title>ftl test page!</title>  
</head>  
	<body>  
	Hello ${name}  
	</BR>
	rootPath is ${rootPath}
	</BR>
	BasePath is ${BasePath}
	</BR>
	<img src = ${rootPath}${BasePath}/images/guidance.jpg />
	</BR>
	<a href="${rootPath}${BasePath}/muser/listUser.do">User List</a>
	
	<a href="${rootPath}${BasePath}/muser/getJson.do">Json List</a>
	
	</body>  
</html> 