<%@ page language="java" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>库存管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; chorset=gb2312">
    <link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" media="screen">
  </head>
  <body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" maginheight="0">
   <table id="_01" width="900" height="120" border="0" cellpadding="0" cellspacing="0">
    <tr>

      <td colspan="7">
      <p style="text-align:center;background-color: black;color: white;font-family: 楷体;font-size: 40px;width:1500">欢迎使用<img src="image/2.png" style="height: 90px;">库存管理系统</p></td>
    </tr>
    <tr style="text-align:center;background-color: gray;color: white;">
      <td >
         <a href="${pageContext.request.contextPath}/findCheckinByPageServlet" style="cursor:hand;width:100;height:20;color:white;text-decoration:underline;font-size:30px">入库管理</a></td>
         <td>||</td>
      <td >
         <a href="${pageContext.request.contextPath}/findCheckoutByPageServlet" style="cursor:hand;width:100;height:20;color:white;text-decoration:underline;font-size: 30px">出库管理</a></td>
         <td>||</td>
      <td >
         <a href="${pageContext.request.contextPath}/findInventoryByPageServlet" style="cursor:hand;width:100;height:20;color:white;text-decoration:underline;font-size: 30px">库存管理</a></td>
         <td>||</td>
      <td >
         <a href="${pageContext.request.contextPath}/index.jsp" style="cursor:hand;width:100;height:20;color:white;text-decoration:underline;font-size: 30px">退出登录</a></td>
    </tr>
   </table>
   <div style="height: 500px; background-color: white;text-align: center">
         <img src="image/3.jpg" style="height: 600px;">
   </div>
   <div class="foot">xxxx</div>
  </body>
</html>
