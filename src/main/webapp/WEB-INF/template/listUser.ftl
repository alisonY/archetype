<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8" />
<title>User list</title>
</head>
<body>
  	<h3>UserList</h3>
  	<a href="${rootPath}${BasePath}/muser/addUserPage.do">Add User</a><br/>
  	
	<table border="1" width="70%">
   		<tr>
   			<td>Id</td>
   			<td>Name</td>
   			<td>Age</td>
   			<td>Address</td>
   			<td>Delete</td>
   			<td>Update</td>
   		</tr>
	  	<#if MUser?? >
	  		<#list MUser as item>
		   		<tr>
		   			<td>${item.id }</td>
		   			<td>${item.name }</td>
		   			<td>${item.age }</td>
		   			<td>${item.address }</td>
		   			<td><a href="${rootPath}${BasePath}/muser/deleteUser.do?id=${item.id }">Delete</a></td>
		   			<td><a href="${rootPath}${BasePath}/muser/updateUserPage.do?id=${item.id }">Update</a></td>
		   		</tr>
	  		</#list>
	  	</#if>
   </table>
   
</body>
</html>