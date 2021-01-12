<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><style type="text/css">
body{
    margin: 0;
    padding: 0;
    font-family: sans-serif;
    background-image: url("image/6.png");

}

.box{
    width: 300px;
    padding: 40px;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    background: rgba(0, 0, 1, 0.26);
    text-align: center;
}

.box h1{
    color: white;
    text-transform: uppercase;
    font-weight: 500;
}

.box input[type="text"],.box input[type="password"]{
    border: 0;
    background: none;
    display: block;
    margin: 20px auto;
    text-align: center;
    border: 2px solid #3498db;
    padding: 14px 10px;
    width: 200px;
    outline: none;
    color: white;
    border-radius: 24px;
    transition: 0.25s;
}

.box input[type="text"],.box input[type="password"]{
    width: 280px;
    border-color: #3498db;
}

.box input[type="submit"]{
    border: 0;
    background: none;
    display: block;
    margin: 20px auto;
    text-align: center;
    border: 2px solid #3498db;
    padding: 14px 40px;
    outline: none;
    color: white;
    border-radius: 24px;
    transition: 0.25s;
    cursor: pointer;
}

.box input[type="submit"]:hover{
    background: #00c3fa;
}
</style>

  <head>
  </head>
  
  <body>

<form class="box" method="post" action="${pageContext.request.contextPath}/enrollservlet">
     <input type="text" name="name" id="name" placeholder="请输入用户名">
     <input type="password" name="pw" id="pw" placeholder="请输入密码">
     
     
     
     <a href="${pageContext.request.contextPath}/index.jsp">放弃注册</a></td><td><input type="submit" value="提交">
     </form>

  </body>
</html>
