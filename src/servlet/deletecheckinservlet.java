package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.storehouseservice;
import service.impl.storehouseserviceimpl;



/**
 * Servlet implementation class deletecheckinservlet
 */
@WebServlet("/deletecheckinservlet")
public class deletecheckinservlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
			
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡcheckin_num
		String checkin_num= request.getParameter("id");
		//2.����service���ɾ������
		storehouseservice service=new storehouseserviceimpl();
		service.deletecheckin(checkin_num);
		//3.��ת�ص�ԭʼҳ��
		response.sendRedirect(request.getContextPath()+"/findCheckinByPageServlet");
	}

}
