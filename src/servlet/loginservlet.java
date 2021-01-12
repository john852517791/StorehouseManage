package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.changecheckin;
import domain.changecheckout;
import domain.login;
import service.storehouseservice;
import service.loginservice;

import service.impl.loginserviceimpl;
import service.impl.storehouseserviceimpl;

@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
			
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置编码
		request.setCharacterEncoding("utf-8");
		//2.获取数据
		String name= request.getParameter("name");
		String password= request.getParameter("password");
		//3.封装user对象
		login login= new login();
		login.setName(name);
		login.setPassword(password);
		
		
		//4.调用service查询
		loginservice service=new loginserviceimpl();
		login loginuser=service.login(login);
		//5.判断是否登陆成功
		if(loginuser!=null){
			response.sendRedirect(request.getContextPath()+"/head.jsp");
		}
		else{
			response.sendRedirect(request.getContextPath()+"/error3.jsp");
		}
		
		
	}

}
