<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>

<form method="post" action="${pageContext.request.contextPath}/addcheckout">
     <table align="center">
     <tr>
     <td>客户:</td><td><input type="text" name="client" id="supplier" placeholder="请输入客户名称"></td>
     </tr>
     <tr>
     <td>货物名称:</td><td><input type="text" name="goods_name" id="goods_name" placeholder="请输入货物名称"></td>
     </tr>
     <tr>
     <td>数量:</td><td> <input type="text" name="quantity" id="quantity" placeholder="请输入数量"></td>
     </tr>
     <tr>
     <td>出库日期:</td><td> <input type="text" name="checkout_date" id="checkout_date" placeholder="请输入出库日期"></td>
     </tr>
     <tr>
     <td><a href="${pageContext.request.contextPath}/findCheckoutByPageServlet">放弃添加</a></td><td><input type="submit" value="提交"></td>
     </tr>     
     </table>
     </form>

  </body>
</html>
