<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>入库管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" media="screen">
	 <script>
    function deletecheckin(id){
    if(confirm("确定删除？")){
             location.href="${pageContext.request.contextPath}/deletecheckinservlet?id="+id;
    }
    }
    </script>

  </head>
  
  <body>
    <div class="container">
      <div class="header">入库信息列表</div>
      
      <div class="topnav" >
          <form action="${pageContext.request.contextPath}/findCheckinByPageServlet" method="post">
             <div class="topnavc">
                 <label for="exampleInputName3">入库编号</label>
                 <input type="text" name="checkin_num" value="${condition.checkin_num[0]}" class="form-control" id="exampleInputName3" >
             </div>
             <div class="topnava" >
                 <label for="exampleInputName2">供应商</label>
                 <input type="text" name="supplier" value="${condition.supplier[0]}" class="form-control" id="exampleInputName2" >
             </div>
             <div class="topnava">
                 <label for="exampleInputEmail2">货物名称</label>
                 <input type="text" name="goods_name" value="${condition.goods_name[0]}" class="form-control" id="exampleInputEmail2">
             </div>
                 <button class="button" type="submit" >查询</button>
          </form>
      </div>
      
      <div class="topnavb">
          <a class="btn btn-primary" href="${pageContext.request.contextPath}/head.jsp">返回首页</a>||
          <a class="btn btn-primary" href="${pageContext.request.contextPath}/findInventoryByPageServlet">库存信息</a>||
          <a class="btn btn-primary" href="${pageContext.request.contextPath}/findCheckoutByPageServlet">出库信息</a>||
          <a class="btn btn-primary" href="${pageContext.request.contextPath}/checkin.jsp">添加入库单</a>
       </div>
      
      <table border="1"id="customers">
         <tr >
            <th><input type="checkbox"></th>
            <th>入库编号</th>
            <th>供应商</th>
            <th>货物名称</th>
            <th>数量</th>
            <th>入库时间</th>
            <th>操作</th>
         </tr>
       <c:forEach items="${pb.list}" var="checkin" varStatus="s">
        <tr>
          <td><input type="checkbox" name="uid" value="${checkin.checkin_num}"></td>
          <td>${checkin.checkin_num}</td>
          <td>${checkin.supplier}</td>
          <td>${checkin.goods_name}</td>
          <td>${checkin.quantity}</td>
          <td>${checkin.checkin_date}</td>
          <td><a  href="${pageContext.request.contextPath}/findcheckinservlet?id=${checkin.checkin_num}">修改</a>
          <a href="javascript:deletecheckin(${checkin.checkin_num})">删除</a></td>
        </tr>
       </c:forEach>
            
      </table>
       <br>
      <div style="text-align:center;">
        
           <ul class="pagination">
           
           <c:if test="${pb.currentPage == 1}">
              <li class="disabled">
           </c:if>
           
           <c:if test="${pb.currentPage != 1}">
              <li>
           </c:if>
           
             
               <a href="${pageContext.request.contextPath}/findCheckinByPageServlet?currentPage=${pb.currentPage - 1}&rows=5&checkin_num=${condition.checkin_num[0]}&supplier=${condition.supplier[0]}&goods_name=${condition.goods_name[0]}" aria-label="Previous">
                  <span aria-hidden="true">&laquo;</span>
               </a>
            </li>
            
            <c:forEach begin="1" end="${pb.totalPage}" var="i" >
            
              <c:if test="${pb.currentPage == i}">
                <li><a class="active" href="${pageContext.request.contextPath}/findCheckinByPageServlet?currentPage=${i}&rows=5&checkin_num=${condition.checkin_num[0]}&supplier=${condition.supplier[0]}&goods_name=${condition.goods_name[0]}">${i}</a></li>
              </c:if>
              <c:if test="${pb.currentPage != i}">
                <li><a href="${pageContext.request.contextPath}/findCheckinByPageServlet?currentPage=${i}&rows=5&checkin_num=${condition.checkin_num[0]}&supplier=${condition.supplier[0]}&goods_name=${condition.goods_name[0]}">${i}</a></li>
              </c:if>
            
            </c:forEach>
            
            <li>
               <a href="${pageContext.request.contextPath}/findCheckinByPageServlet?currentPage=${pb.currentPage + 1}&rows=5&checkin_num=${condition.checkin_num[0]}&supplier=${condition.supplier[0]}&goods_name=${condition.goods_name[0]}"  aria-label="Next">
                 <span aria-hidden="true">&raquo;</span>
               </a>
            </li>
           
            <span style="font-size:20px;text-align:center;">
                         共${pb.totalCount}条记录，共${pb.totalPage}页
            </span>
         </ul>
       
      </div>
    </div>
    <div class="foot">汪智勇|陈龙|海江涛|罗健瑀</div>
  </body>
</html>
