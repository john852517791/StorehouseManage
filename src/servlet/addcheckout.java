package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import domain.checkoutw;
import domain.goods_name;
import service.storehouseservice;
import service.impl.storehouseserviceimpl;

@WebServlet("/addcheckout")
public class addcheckout extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置编码
		storehouse dao=new storehouseimpl();
		request.setCharacterEncoding("utf-8");
		//2.获取参数
		Map<String,String[]> map = request.getParameterMap();
		//3.封装对象
		checkoutw checkout = new checkoutw();
		try{
			BeanUtils.populate(checkout,map);
			} catch (IllegalAccessException e){
				e.printStackTrace();
				} catch (InvocationTargetException e){
					e.printStackTrace();
					}
		
		
		if(dao.nameexist(checkout)){//若货名存在
			if(dao.enough(checkout)){//若货库存足够
				storehouseservice service=new storehouseserviceimpl();
				service.addcheckout(checkout);
				//跳转页面
				response.sendRedirect(request.getContextPath()+"/findCheckoutByPageServlet");
				}
			else{
				//若库存不足
				response.sendRedirect(request.getContextPath()+"/error2.jsp");
				}
			}
		else{//若货名不存在
			response.sendRedirect(request.getContextPath()+"/error.jsp");
			}
		}
	}
