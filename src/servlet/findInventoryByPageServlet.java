package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Checkin;
import domain.Inventory;
import domain.PageBean;
import impl.checkinserviceImpl;
import service.checkinservice;

@WebServlet("/findInventoryByPageServlet")
public class findInventoryByPageServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
		
		//1.��ȡ����
		String currentPage = request.getParameter("currentPage");//��ǰҳ��
		String rows = request.getParameter("rows");//ÿҳ��ʾ����
		
		if(currentPage == null || "".equals(currentPage)){
			
			currentPage = "1";
		}
		if(rows == null || "".equals(rows)){
			rows = "5";
		}
	
		//��ȡ������ѯ����
		Map<String, String[]>condition = request.getParameterMap();
		
		//2.����service��ѯ
		checkinservice service = new checkinserviceImpl();
		PageBean<Inventory> pb = service.findInventoryByPage(currentPage,rows,condition);
		
		System.out.println(pb);
		
		//3.��PageBean����request
		request.setAttribute("pb",pb);
		request.setAttribute("condition", condition);//����ѯ��������request
		//4.ת����ruku_select.jsp
		request.getRequestDispatcher("/kucun_select.jsp").forward(request,response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
		
	}

}
