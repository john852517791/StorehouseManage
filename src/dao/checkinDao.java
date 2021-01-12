package dao;
import domain.Checkin;
import domain.Checkout;
import domain.Inventory;

import java.util.List;
import java.util.Map;

/**入库管理的Dao
 * 
 * @author ASUS
 *
 */
public interface checkinDao {
	
	public List<Checkin> findAll();
	public List<Checkout> findAll2();
	public List<Inventory> findAll3();

	/**
	 * 查询总记录数
	 * @param condition 
	 * @return
	 */
	int findTotalCount(Map<String, String[]> condition);
	int findTotalCount2(Map<String, String[]> condition);
	int findTotalCount3(Map<String, String[]> condition);

	/**
	 * 分页查询每页记录
	 * @param start
	 * @param rows
	 * @param condition 
	 * @return
	 */
	List<Checkin> findByPage(int start, int rows, Map<String, String[]> condition);
	List<Checkout> findByPage2(int start, int rows, Map<String, String[]> condition);
	List<Inventory> findByPage3(int start, int rows, Map<String, String[]> condition);

	
}
