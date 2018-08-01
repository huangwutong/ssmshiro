<%@page import="com.angsentech.ssm.util.PropertiesUtils"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="${ctx }/public/js/jquery-1.11.3.js"></script>
<script src="${ctx }/public/js/index.js"></script>
<title>首页</title>
</head>
<body>
<h1>欢迎您回来 ${shiroUser.realName}</h1>
<a href="${ctx}/logout">退出登录</a>

登录成功!

</body>
<script type="text/javascript">

</script>
</html>