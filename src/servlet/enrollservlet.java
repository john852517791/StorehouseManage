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

@WebServlet("/enrollservlet")
public class enrollservlet extends HttpServlet {
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
		String password= request.getParameter("pw");
		
		
		loginservice service=new loginserviceimpl();
		boolean a = service.nameexist(name);
		if(a){
			response.sendRedirect(request.getContextPath()+"/error4.jsp");			
		}
		else{
			service.enroll(name,password);
			response.sendRedirect(request.getContextPath()+"/error5.jsp");
		}
		
		
		
	}

}
