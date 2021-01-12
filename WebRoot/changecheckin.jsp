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
<form method="post" action="${pageContext.request.contextPath}/changecheckinservlet">
     <table align="center">
     <tr>
     <td>入库单号:</td><td><input type="text" name="checkin_num" id="checkin_num" readonly="readonly" value="${checkin.checkin_num}"></td>
     </tr>
     <tr>
     <td>供应商:</td><td><input type="text" name="supplier" id="supplier" value="${checkin.supplier}"></td>
     </tr>
     <tr>
     <td>货物名称:</td><td><input type="text" name="goods_name" id="goods_name" value="${checkin.goods_name}"></td>
     </tr>
     <tr>
     <td>数量:</td><td> <input type="text" name="quantity" id="quantity" value="${checkin.quantity}"></td>
     </tr>
     <tr>
     <td>入库日期:</td><td> <input type="text" name="checkin_date" id="checkin_date" value="${checkin.checkin_date}"></td>
     </tr>
     <tr>
     <td><a href="${pageContext.request.contextPath}/findCheckinByPageServlet">放弃修改</a></td><td><input type="submit" value="提交"></td>
     </tr>     
     </table>
     </form>

  </body>
</html>
