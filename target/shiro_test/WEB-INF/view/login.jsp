<%@page import="com.angsentech.ssm.util.PropertiesUtils"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String ctx = request.getContextPath();
	String backPath = PropertiesUtils.getContextProperty("base_url");
	String graduationPath = PropertiesUtils.getContextProperty("graduation_url");
	request.setAttribute("ctx", ctx);
	request.setAttribute("backPath", backPath);
	request.setAttribute("graduationPath", graduationPath);
%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
</head>
<body>
<center>
	<form action="${ctx}/login" method="post">
		用户名：<input type="text" name="userName"/><br/>
		密     码：<input type="password" name="passWord"/><br/>
		<input type="submit" value="登录"/>
		
	</form>
	<c:if test="${msg!=null}">
			${msg}
	</c:if>
</center>
</body>
</html>