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

<form method="post" action="${pageContext.request.contextPath}/changecheckoutservlet">
     <table align="center">
     <tr>
     <td>出库单号:</td><td><input type="text" name="checkout_num" id="checkout_num" readonly="readonly" value="${checkout.checkout_num}"></td>
     </tr>
     <tr>
     <td>客户名:</td><td><input type="text" name="client" id="client" value="${checkout.client}"></td>
     </tr>
     <tr>
     <td>货物名称:</td><td><input type="text" name="goods_name" id="goods_name" value="${checkout.goods_name}"></td>
     </tr>
     <tr>
     <td>数量:</td><td> <input type="text" name="quantity" id="quantity" value="${checkout.quantity}"></td>
     </tr>
     <tr>
     <td>出库日期:</td><td> <input type="text" name="checkout_date" id="checkout_date" value="${checkout.checkout_date}"></td>
     </tr>
     <tr>
     <td><a href="${pageContext.request.contextPath}/findCheckoutByPageServlet">放弃修改</a></td><td><input type="submit" value="提交"></td>
     </tr>     
     </table>
     </form>

  </body>
</html>
