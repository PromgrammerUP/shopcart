<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="org.javachina.shopcart.dto.GoodsInfoDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生成订单</title>
</head>
<body>
	<font size="8" face="楷体">购物车内商品列表</font>
	<center>
		<table width="80%" border="1">
			<tr>
				<td>商品ID</td><td>商品名称</td><td>商品单价</td><td>商品数量</td>
			</tr>
			
			<%
				ArrayList<GoodsInfoDto> list = (ArrayList<GoodsInfoDto>)request.getSession().getAttribute("shopcart");
				for (GoodsInfoDto dto :list ){
				
			 %>
			<tr>
				<td><%=dto.getId() %></td><td><%=dto.getName() %></td><td><%=dto.getPrice() %></td><td><input type="text" size=10 name="count" value="<%=dto.getCount()%>"></td>
			</tr>
			<%
			}
			 %>
			<tr>
				<td colspan="4" align="right"><input type="submit" value="生产订单并提交"></td>
			</tr>
		</table>
	</center>
</body>
</html>