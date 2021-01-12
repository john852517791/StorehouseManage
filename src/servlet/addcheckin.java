package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.checkinw;
import service.storehouseservice;
import service.impl.storehouseserviceimpl;


@WebServlet("/addcheckin")
public class addcheckin extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //1.���ñ���
		request.setCharacterEncoding("utf-8");
	  //2.��ȡ����
		Map<String,String[]> map = request.getParameterMap();
	 //3.��װ����
		checkinw checkin = new checkinw();
		try{
			BeanUtils.populate(checkin,map);
		} catch (IllegalAccessException e){
			e.printStackTrace();
		} catch (InvocationTargetException e){
			e.printStackTrace();
		}
		
	 //4.����Service����
		storehouseservice service=new storehouseserviceimpl();
		service.addcheckin(checkin);
		
	//5.��ת����ѯҳ��
		response.sendRedirect(request.getContextPath()+"/findCheckinByPageServlet");
	}

}
