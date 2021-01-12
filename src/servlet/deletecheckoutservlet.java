package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.storehouseservice;
import service.impl.storehouseserviceimpl;

/**
 * Servlet implementation class deletecheckoutservlet
 */
@WebServlet("/deletecheckoutservlet")
public class deletecheckoutservlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
			
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡcheckin_num
		String checkout_num= request.getParameter("id");
		//2.����service���ɾ������
		storehouseservice service=new storehouseserviceimpl();
		service.deletecheckout(checkout_num);
		//3.��ת�ص�ԭʼҳ��
		response.sendRedirect(request.getContextPath()+"/findCheckoutByPageServlet");
	}

}
