package impl;
import dao.checkinDao;
import domain.Checkin;
import domain.Checkout;
import domain.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.util.JDBCUtils;

public class checkinDaoImpl implements checkinDao{
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	@Override
	public List<Checkin> findAll(){
		//使用JDBC操作数据库...
		//1.定义sql
		String sql = "select * from checkin";
		List<Checkin> checkins = template.query(sql,new BeanPropertyRowMapper<Checkin>(Checkin.class));
		
		return checkins;
		
	}
	@Override
	public List<Checkout> findAll2(){
		//使用JDBC操作数据库...
		//1.定义sql
		String sql = "select * from checkout";
		List<Checkout> checkouts = template.query(sql,new BeanPropertyRowMapper<Checkout>(Checkout.class));
		
		return checkouts;
		
	}
	@Override
	public List<Inventory> findAll3(){
		//使用JDBC操作数据库...
		//1.定义sql
		String sql = "select * from inventory";
		List<Inventory> inventorys = template.query(sql,new BeanPropertyRowMapper<Inventory>(Inventory.class));
		
		return inventorys;
		
	}
	
	@Override
	public int findTotalCount(Map<String, String[]> condition) {
		//定义模板初始化sql
		String sql = "select count(*) from checkin where 1 = 1 ";
		StringBuilder sb = new StringBuilder(sql);
		//遍历map
		Set<String> keySet = condition.keySet();
		//定义参数的集合
		List<Object> params = new ArrayList<Object>();
		for (String key : keySet){
			
			//排除分页条件参数
			if("currentPage".equals(key) || "rows".equals(key)){
				continue;
			}
			
			//获取value
			String value = condition.get(key)[0];
			//判断value是否有值
			if(value != null && !"".equals(value)){
				//有值			
				sb.append(" and "+key+" like ? ");
			    params.add("%"+value+"%");//加条件的值
			}
		}
		
		System.out.println(sb.toString());
		System.out.println(params);
		
		
		return template.queryForObject(sb.toString(),Integer.class,params.toArray());	
	}
	
	@Override
	public int findTotalCount2(Map<String, String[]> condition) {
		//定义模板初始化sql
		String sql = "select count(*) from checkout where 1 = 1 ";
		StringBuilder sb = new StringBuilder(sql);
		//遍历map
		Set<String> keySet = condition.keySet();
		//定义参数的集合
		List<Object> params = new ArrayList<Object>();
		for (String key : keySet){
			
			//排除分页条件参数
			if("currentPage".equals(key) || "rows".equals(key)){
				continue;
			}
			
			//获取value
			String value = condition.get(key)[0];
			//判断value是否有值
			if(value != null && !"".equals(value)){
				//有值			
				sb.append(" and "+key+" like ? ");
			    params.add("%"+value+"%");//加条件的值
			}
		}
		
		System.out.println(sb.toString());
		System.out.println(params);
		
		
		return template.queryForObject(sb.toString(),Integer.class,params.toArray());	
	}
	@Override
	public int findTotalCount3(Map<String, String[]> condition) {
		//定义模板初始化sql
		String sql = "select count(*) from inventory where 1 = 1 ";
		StringBuilder sb = new StringBuilder(sql);
		//遍历map
		Set<String> keySet = condition.keySet();
		//定义参数的集合
		List<Object> params = new ArrayList<Object>();
		for (String key : keySet){
			
			//排除分页条件参数
			if("currentPage".equals(key) || "rows".equals(key)){
				continue;
			}
			
			//获取value
			String value = condition.get(key)[0];
			//判断value是否有值
			if(value != null && !"".equals(value)){
				//有值			
				sb.append(" and "+key+" like ? ");
			    params.add("%"+value+"%");//加条件的值
			}
		}
		
		System.out.println(sb.toString());
		System.out.println(params);
		
		
		return template.queryForObject(sb.toString(),Integer.class,params.toArray());	
	}
	
	@Override
	public List<Checkin> findByPage (int start, int rows, Map<String, String[]> condition){
		String sql = "select * from checkin where 1 = 1 ";
		StringBuilder sb = new StringBuilder(sql);
		//遍历map
		Set<String> keySet = condition.keySet();
		//定义参数的集合
		List<Object> params = new ArrayList<Object>();
		for (String key : keySet){
			
			//排除分页条件参数
			if("currentPage".equals(key) || "rows".equals(key)){
				continue;
			}
			
			//获取value
			String value = condition.get(key)[0];
			//判断value是否有值
			if(value != null && !"".equals(value)){
				//有值			
				sb.append(" and "+key+" like ? ");
			    params.add("%"+value+"%");//加条件的值
			}
		}
		
		//添加分页查询
		sb.append(" limit ?,? ");
		//添加分页查询参数值
		params.add(start);
		params.add(rows);
		
		sql = sb.toString();
		System.out.println(sql);
		System.out.println(params);
		
		return template.query(sql,new BeanPropertyRowMapper<Checkin>(Checkin.class),params.toArray());
	}
	@Override
	public List<Checkout> findByPage2 (int start, int rows, Map<String, String[]> condition){
		String sql = "select * from checkout where 1 = 1 ";
		StringBuilder sb = new StringBuilder(sql);
		//遍历map
		Set<String> keySet = condition.keySet();
		//定义参数的集合
		List<Object> params = new ArrayList<Object>();
		for (String key : keySet){
			
			//排除分页条件参数
			if("currentPage".equals(key) || "rows".equals(key)){
				continue;
			}
			
			//获取value
			String value = condition.get(key)[0];
			//判断value是否有值
			if(value != null && !"".equals(value)){
				//有值			
				sb.append(" and "+key+" like ? ");
			    params.add("%"+value+"%");//加条件的值
			}
		}
		
		//添加分页查询
		sb.append(" limit ?,? ");
		//添加分页查询参数值
		params.add(start);
		params.add(rows);
		
		sql = sb.toString();
		System.out.println(sql);
		System.out.println(params);
		
		return template.query(sql,new BeanPropertyRowMapper<Checkout>(Checkout.class),params.toArray());
	}
	@Override
	public List<Inventory> findByPage3 (int start, int rows, Map<String, String[]> condition){
		String sql = "select * from inventory where 1 = 1 ";
		StringBuilder sb = new StringBuilder(sql);
		//遍历map
		Set<String> keySet = condition.keySet();
		//定义参数的集合
		List<Object> params = new ArrayList<Object>();
		for (String key : keySet){
			
			//排除分页条件参数
			if("currentPage".equals(key) || "rows".equals(key)){
				continue;
			}
			
			//获取value
			String value = condition.get(key)[0];
			//判断value是否有值
			if(value != null && !"".equals(value)){
				//有值			
				sb.append(" and "+key+" like ? ");
			    params.add("%"+value+"%");//加条件的值
			}
		}
		
		//添加分页查询
		sb.append(" limit ?,? ");
		//添加分页查询参数值
		params.add(start);
		params.add(rows);
		
		sql = sb.toString();
		System.out.println(sql);
		System.out.println(params);
		
		return template.query(sql,new BeanPropertyRowMapper<Inventory>(Inventory.class),params.toArray());
	}

}
