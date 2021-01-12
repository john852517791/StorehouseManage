package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.changecheckin;
import domain.changecheckout;
import service.storehouseservice;
import service.impl.storehouseserviceimpl;

/**
 * Servlet implementation class findcheckoutservlet
 */
@WebServlet("/findcheckoutservlet")
public class findcheckoutservlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
			
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡid
		String id=request.getParameter("id");
		//2.����service��ѯ
		storehouseservice service=new storehouseserviceimpl();
		changecheckout checkout=service.findcheckout(id);
		//3.��user����request
		request.setAttribute("checkout",checkout);
		//4.ת����ʾ��jspҳ��
		request.getRequestDispatcher("/changecheckout.jsp").forward(request,response);
	}

}
