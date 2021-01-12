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

import dao.storehouse;
import dao.impl.storehouseimpl;
import domain.changecheckin;
import domain.changecheckout;
import domain.goods_name;
import service.storehouseservice;
import service.impl.storehouseserviceimpl;

/**
 * Servlet implementation class changecheckoutservlet
 */
@WebServlet("/changecheckoutservlet")
public class changecheckoutservlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
			
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.���ñ���
		request.setCharacterEncoding("utf-8");
		//2.��ȡmap
		Map<String,String[]> map=request.getParameterMap();
		//3.��װ����
		changecheckout changecheckout=new changecheckout();
		try {
			BeanUtils.populate(changecheckout, map);
			} 
		catch (IllegalAccessException e) {				
				// TODO Auto-generated catch block
			e.printStackTrace();
			} 
		catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			};
			
			
			storehouse dao=new storehouseimpl();
			//4.����service�޸�
			
			if(dao.nameexist2(changecheckout)){//����������
				if(dao.enough2(changecheckout)){//��������㹻
					storehouseservice service=new storehouseserviceimpl();
					service.changecheckout(changecheckout);
					//��תҳ��
					response.sendRedirect(request.getContextPath()+"/findCheckoutByPageServlet");
					}
				else{//����治��
					response.sendRedirect(request.getContextPath()+"/findCheckoutByPageServlet");
					}
				}
			else{//������������
				response.sendRedirect(request.getContextPath()+"/findCheckoutByPageServlet");
				}
				
			//5.��ת����ҳ��
			}
	
}
