package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.changecheckin;
import service.storehouseservice;
import service.impl.storehouseserviceimpl;

/**
 * Servlet implementation class changecheckinservlet
 */
@WebServlet("/changecheckinservlet")
public class changecheckinservlet extends HttpServlet {
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
		changecheckin changecheckin=new changecheckin();
		try {
			BeanUtils.populate(changecheckin, map);//����ҳ���������ݷ�װ��������������Ķ���
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//4.����service�޸�
		storehouseservice service=new storehouseserviceimpl();
		service.changecheckin(changecheckin);
		//5.��ת����ҳ��
		response.sendRedirect(request.getContextPath()+"/findCheckinByPageServlet");
		
	}

}
