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
		//ʹ��JDBC�������ݿ�...
		//1.����sql
		String sql = "select * from checkin";
		List<Checkin> checkins = template.query(sql,new BeanPropertyRowMapper<Checkin>(Checkin.class));
		
		return checkins;
		
	}
	@Override
	public List<Checkout> findAll2(){
		//ʹ��JDBC�������ݿ�...
		//1.����sql
		String sql = "select * from checkout";
		List<Checkout> checkouts = template.query(sql,new BeanPropertyRowMapper<Checkout>(Checkout.class));
		
		return checkouts;
		
	}
	@Override
	public List<Inventory> findAll3(){
		//ʹ��JDBC�������ݿ�...
		//1.����sql
		String sql = "select * from inventory";
		List<Inventory> inventorys = template.query(sql,new BeanPropertyRowMapper<Inventory>(Inventory.class));
		
		return inventorys;
		
	}
	
	@Override
	public int findTotalCount(Map<String, String[]> condition) {
		//����ģ���ʼ��sql
		String sql = "select count(*) from checkin where 1 = 1 ";
		StringBuilder sb = new StringBuilder(sql);
		//����map
		Set<String> keySet = condition.keySet();
		//��������ļ���
		List<Object> params = new ArrayList<Object>();
		for (String key : keySet){
			
			//�ų���ҳ��������
			if("currentPage".equals(key) || "rows".equals(key)){
				continue;
			}
			
			//��ȡvalue
			String value = condition.get(key)[0];
			//�ж�value�Ƿ���ֵ
			if(value != null && !"".equals(value)){
				//��ֵ			
				sb.append(" and "+key+" like ? ");
			    params.add("%"+value+"%");//��������ֵ
			}
		}
		
		System.out.println(sb.toString());
		System.out.println(params);
		
		
		return template.queryForObject(sb.toString(),Integer.class,params.toArray());	
	}
	
	@Override
	public int findTotalCount2(Map<String, String[]> condition) {
		//����ģ���ʼ��sql
		String sql = "select count(*) from checkout where 1 = 1 ";
		StringBuilder sb = new StringBuilder(sql);
		//����map
		Set<String> keySet = condition.keySet();
		//��������ļ���
		List<Object> params = new ArrayList<Object>();
		for (String key : keySet){
			
			//�ų���ҳ��������
			if("currentPage".equals(key) || "rows".equals(key)){
				continue;
			}
			
			//��ȡvalue
			String value = condition.get(key)[0];
			//�ж�value�Ƿ���ֵ
			if(value != null && !"".equals(value)){
				//��ֵ			
				sb.append(" and "+key+" like ? ");
			    params.add("%"+value+"%");//��������ֵ
			}
		}
		
		System.out.println(sb.toString());
		System.out.println(params);
		
		
		return template.queryForObject(sb.toString(),Integer.class,params.toArray());	
	}
	@Override
	public int findTotalCount3(Map<String, String[]> condition) {
		//����ģ���ʼ��sql
		String sql = "select count(*) from inventory where 1 = 1 ";
		StringBuilder sb = new StringBuilder(sql);
		//����map
		Set<String> keySet = condition.keySet();
		//��������ļ���
		List<Object> params = new ArrayList<Object>();
		for (String key : keySet){
			
			//�ų���ҳ��������
			if("currentPage".equals(key) || "rows".equals(key)){
				continue;
			}
			
			//��ȡvalue
			String value = condition.get(key)[0];
			//�ж�value�Ƿ���ֵ
			if(value != null && !"".equals(value)){
				//��ֵ			
				sb.append(" and "+key+" like ? ");
			    params.add("%"+value+"%");//��������ֵ
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
		//����map
		Set<String> keySet = condition.keySet();
		//��������ļ���
		List<Object> params = new ArrayList<Object>();
		for (String key : keySet){
			
			//�ų���ҳ��������
			if("currentPage".equals(key) || "rows".equals(key)){
				continue;
			}
			
			//��ȡvalue
			String value = condition.get(key)[0];
			//�ж�value�Ƿ���ֵ
			if(value != null && !"".equals(value)){
				//��ֵ			
				sb.append(" and "+key+" like ? ");
			    params.add("%"+value+"%");//��������ֵ
			}
		}
		
		//��ӷ�ҳ��ѯ
		sb.append(" limit ?,? ");
		//��ӷ�ҳ��ѯ����ֵ
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
		//����map
		Set<String> keySet = condition.keySet();
		//��������ļ���
		List<Object> params = new ArrayList<Object>();
		for (String key : keySet){
			
			//�ų���ҳ��������
			if("currentPage".equals(key) || "rows".equals(key)){
				continue;
			}
			
			//��ȡvalue
			String value = condition.get(key)[0];
			//�ж�value�Ƿ���ֵ
			if(value != null && !"".equals(value)){
				//��ֵ			
				sb.append(" and "+key+" like ? ");
			    params.add("%"+value+"%");//��������ֵ
			}
		}
		
		//��ӷ�ҳ��ѯ
		sb.append(" limit ?,? ");
		//��ӷ�ҳ��ѯ����ֵ
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
		//����map
		Set<String> keySet = condition.keySet();
		//��������ļ���
		List<Object> params = new ArrayList<Object>();
		for (String key : keySet){
			
			//�ų���ҳ��������
			if("currentPage".equals(key) || "rows".equals(key)){
				continue;
			}
			
			//��ȡvalue
			String value = condition.get(key)[0];
			//�ж�value�Ƿ���ֵ
			if(value != null && !"".equals(value)){
				//��ֵ			
				sb.append(" and "+key+" like ? ");
			    params.add("%"+value+"%");//��������ֵ
			}
		}
		
		//��ӷ�ҳ��ѯ
		sb.append(" limit ?,? ");
		//��ӷ�ҳ��ѯ����ֵ
		params.add(start);
		params.add(rows);
		
		sql = sb.toString();
		System.out.println(sql);
		System.out.println(params);
		
		return template.query(sql,new BeanPropertyRowMapper<Inventory>(Inventory.class),params.toArray());
	}

}
