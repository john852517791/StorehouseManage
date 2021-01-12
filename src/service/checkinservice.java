package service;
import domain.PageBean;
import domain.Checkin;
import domain.Checkout;
import domain.Inventory;
import service.checkinservice;
import java.util.List;
import java.util.Map;

/**
 * �������ҵ��ӿ�
 * @author ASUS
 *
 */
public interface checkinservice {

	/**
	 * ��ѯ���������Ϣ
	 * @return
	 */
	public List<Checkin> findAll();
	public List<Checkout> findAll2();
	public List<Inventory> findAll3();
	
	/**
	 * ��ҳ������ѯ
	 * @param currentPage
	 * @param rows
	 * @param condition 
	 * @return
	 */
	 PageBean<Checkin> findCheckinByPage(String currentPage, String rows, Map<String, String[]> condition);
	 PageBean<Checkout> findCheckoutByPage(String currentPage, String rows, Map<String, String[]> condition);
	 PageBean<Inventory> findInventoryByPage(String currentPage, String rows, Map<String, String[]> condition);
}
