<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车首页</title>
</head>
<body>
	用户购买<br>
	&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath() %>/action?leixingid=1001&act=buy">购买武术类书籍</a><br>
	&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath() %>/action?leixingid=1003&act=buy">购买法律类书籍</a><br>
	&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath() %>/action?leixingid=1004&act=buy">购买计算机类书籍</a><br>
	&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath() %>/action?leixingid=1002&act=buy">购买历史类书籍</a><br>
	用户结账<br>
	&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/action?act=charge">清算购物车</a><br>
</body>
</html>