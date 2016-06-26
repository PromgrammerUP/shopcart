<%@page import="org.javachina.shopcart.dto.GoodsInfoDto"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
</head>
<body>
	<font size="8" face="楷体">购物车</font>
	<center>
		<form action="<%=request.getContextPath() %>/action">
		<input type="hidden" name="act" value="addToCart">
		<table width="100%" border="1">
			<tr>
				<td>商品ID</td><td>商品名称</td><td>商品单价</td><td>商品描述</td><td>剩余数量</td><td>购买数量</td><td>操作</td>
			</tr>
			<%
				ArrayList<GoodsInfoDto> all = (ArrayList<GoodsInfoDto>)request.getAttribute("all");
				for(int i=0;i<all.size();i++){
					GoodsInfoDto dto = all.get(i);
			 %>
			 <tr>
				<td><%=dto.getId() %></td><td><%=dto.getName() %></td><td><%=dto.getPrice() %></td><td><%=dto.getDescription() %></td><td><%=dto.getCount() %></td>
				<td><input type="text" name="count" size=10>
				<input type="hidden" name="id" value="<%=dto.getId()%>">
				<input type="hidden" name="name" value="<%=dto.getName()%>">
				<input type="hidden" name="price" value="<%=dto.getPrice()%>">
				</td>
				<td><input type="checkbox" name="no" value="<%=i %>" ></td>
			</tr>
			 <%
			 }
			  %>
			<tr>
				<td colspan="7" align="center"><input type="submit" value="加入购物车"></td>
			</tr>
		</table>
		</form>
	</center>
</body>
</html>