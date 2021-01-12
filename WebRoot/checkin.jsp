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

<form method="post" action="${pageContext.request.contextPath}/addcheckin">
     <table align="center">
     <tr>
     <td>供应商:</td><td><input type="text" name="supplier" id="supplier" placeholder="请输入供应商名称"></td>
     </tr>
     <tr>
     <td>货物名称:</td><td><input type="text" name="goods_name" id="goods_name" placeholder="请输入货物名称"></td>
     </tr>
     <tr>
     <td>数量:</td><td> <input type="text" name="quantity" id="quantity" placeholder="请输入数量"></td>
     </tr>
     <tr>
     <td>入库日期:</td><td> <input type="text" name="checkin_date" id="checkin_date" placeholder="请输入入库日期"></td>
     </tr>
     <tr>
     <td><a href="${pageContext.request.contextPath}/findCheckinByPageServlet">放弃添加</a></td><td><input type="submit" value="提交"></td>
     </tr>     
     </table>
     </form>

  </body>
</html>
