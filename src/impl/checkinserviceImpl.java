package impl;
import dao.checkinDao;
import service.checkinservice;
import domain.PageBean;
import domain.Checkin;
import domain.Checkout;
import domain.Inventory;

import java.util.List;
import java.util.Map;

import impl.checkinDaoImpl;
import impl.checkinserviceImpl;


public class checkinserviceImpl implements checkinservice{
	private checkinDao dao = new checkinDaoImpl();
	
	@Override
	public List<Checkin> findAll(){
		//调用DAO完成查询
		return dao.findAll();
	}
	@Override
	public List<Checkout> findAll2(){
		//调用DAO完成查询
		return dao.findAll2();
	}
	@Override
	public List<Inventory> findAll3(){
		//调用DAO完成查询
		return dao.findAll3();
	}
	
	
	@Override
	public PageBean<Checkin> findCheckinByPage(String _currentPage, String _rows, Map<String, String[]> condition){
		
		int currentPage = Integer.parseInt(_currentPage);
		int rows = Integer.parseInt(_rows);
		
		if(currentPage <=0){
			currentPage = 1;
		}
		
		//1.创建空的PageBean对象
		PageBean<Checkin> pb = new PageBean<Checkin>();
		//2.设置参数
		pb.setCurrentPage(currentPage);
		pb.setRows(rows);
		//3.调用dao查询总记录数
		int totalCount = dao.findTotalCount(condition);
		pb.setTotalCount(totalCount);
		//4.调用dao查询List集合
		//计算开始的记录索引
		int start = (currentPage - 1) * rows;
		List<Checkin> list = dao.findByPage(start,rows,condition);
	    pb.setList(list);
	    
	    //5.计算总页码
	    int totalPage = (totalCount % rows) == 0 ? totalCount/rows : (totalCount/rows) + 1;
	    pb.setTotalPage(totalPage);;
	    
	    return pb;
	}
	@Override
	public PageBean<Checkout> findCheckoutByPage(String _currentPage, String _rows, Map<String, String[]> condition){
		
		int currentPage = Integer.parseInt(_currentPage);
		int rows = Integer.parseInt(_rows);
		
		if(currentPage <=0){
			currentPage = 1;
		}
		
		//1.创建空的PageBean对象
		PageBean<Checkout> pb = new PageBean<Checkout>();
		//2.设置参数
		pb.setCurrentPage(currentPage);
		pb.setRows(rows);
		//3.调用dao查询总记录数
		int totalCount = dao.findTotalCount2(condition);
		pb.setTotalCount(totalCount);
		//4.调用dao查询List集合
		//计算开始的记录索引
		int start = (currentPage - 1) * rows;
		List<Checkout> list = dao.findByPage2(start,rows,condition);
	    pb.setList(list);
	    
	    //5.计算总页码
	    int totalPage = (totalCount % rows) == 0 ? totalCount/rows : (totalCount/rows) + 1;
	    pb.setTotalPage(totalPage);;
	    
	    return pb;
	}

	@Override
	public PageBean<Inventory> findInventoryByPage(String _currentPage, String _rows, Map<String, String[]> condition){
		
		int currentPage = Integer.parseInt(_currentPage);
		int rows = Integer.parseInt(_rows);
		
		if(currentPage <=0){
			currentPage = 1;
		}
		
		//1.创建空的PageBean对象
		PageBean<Inventory> pb = new PageBean<Inventory>();
		//2.设置参数
		pb.setCurrentPage(currentPage);
		pb.setRows(rows);
		//3.调用dao查询总记录数
		int totalCount = dao.findTotalCount3(condition);
		pb.setTotalCount(totalCount);
		//4.调用dao查询List集合
		//计算开始的记录索引
		int start = (currentPage - 1) * rows;
		List<Inventory> list = dao.findByPage3(start,rows,condition);
	    pb.setList(list);
	    
	    //5.计算总页码
	    int totalPage = (totalCount % rows) == 0 ? totalCount/rows : (totalCount/rows) + 1;
	    pb.setTotalPage(totalPage);;
	    
	    return pb;
	}


}
