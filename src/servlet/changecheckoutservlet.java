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
		//1.设置编码
		request.setCharacterEncoding("utf-8");
		//2.获取map
		Map<String,String[]> map=request.getParameterMap();
		//3.封装对象
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
			//4.调用service修改
			
			if(dao.nameexist2(changecheckout)){//若货名存在
				if(dao.enough2(changecheckout)){//若货库存足够
					storehouseservice service=new storehouseserviceimpl();
					service.changecheckout(changecheckout);
					//跳转页面
					response.sendRedirect(request.getContextPath()+"/findCheckoutByPageServlet");
					}
				else{//若库存不足
					response.sendRedirect(request.getContextPath()+"/findCheckoutByPageServlet");
					}
				}
			else{//若货名不存在
				response.sendRedirect(request.getContextPath()+"/findCheckoutByPageServlet");
				}
				
			//5.跳转到主页面
			}
	
}
