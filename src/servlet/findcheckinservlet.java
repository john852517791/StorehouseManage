package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.storehouseservice;
import service.impl.storehouseserviceimpl;
import domain.*;

/**
 * Servlet implementation class findcheckinservlet
 */
@WebServlet("/findcheckinservlet")
public class findcheckinservlet extends HttpServlet {
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
		changecheckin checkin=service.findcheckin(id);
		//3.��user����request
		request.setAttribute("checkin",checkin);
		//4.ת����ʾ��jspҳ��
		request.getRequestDispatcher("/changecheckin.jsp").forward(request,response);

	}

}
