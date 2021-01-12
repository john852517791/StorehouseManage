package dao.impl;
import java.util.Date;
import java.util.Formatter;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.util.JDBCUtils;
import org.util.*;

import dao.*;
import domain.Inventory;
import domain.changecheckin;
import domain.changecheckout;
import domain.checkinw;
import domain.checkoutw;
import domain.goods_name;
import domain.login;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class storehouseimpl implements storehouse{
	private JdbcTemplate template= new JdbcTemplate(JDBCUtils.getDataSource());

	@Override
	public void deletecheckin(int checkin_num) {
		// TODO Auto-generated method stub
		String sql1="update inventory set quantity=quantity-(select quantity from checkin where checkin_num =?) where goods_name=(select goods_name from checkin where checkin_num=?);";
		String sql2="delete from checkin where checkin_num="+checkin_num;
		template.update(sql1,checkin_num,checkin_num);
		template.execute(sql2);
	}

	@Override
	public void deletecheckout(int checkout_num) {
		// TODO Auto-generated method stub
		String sql1="update inventory set quantity=quantity+(select quantity from checkout where checkout_num =?) where goods_name=(select goods_name from checkout where checkout_num=?);";
		String sql2="delete from checkout where checkout_num="+checkout_num;
		template.update(sql1,checkout_num,checkout_num);
		template.execute(sql2);
	}

	@Override
	public changecheckout findcheckout(int id) {
		// TODO Auto-generated method stub
		String sql="select * from checkout where checkout_num=?";
		
		return template.queryForObject(sql, new BeanPropertyRowMapper<changecheckout>(changecheckout.class),id);
	}

	@Override
	public changecheckin findcheckin(int id) {
		// TODO Auto-generated method stub
		String sql="select * from checkin where checkin_num=?";

		return template.queryForObject(sql, new BeanPropertyRowMapper<changecheckin>(changecheckin.class),id);
	}

	@Override
	public void changecheckout(domain.changecheckout changecheckout) {
		// TODO Auto-generated method stub
		String sql1="UPDATE inventory SET quantity=quantity+? WHERE goods_name=?";
		String sql4="SELECT quantity FROM checkout WHERE checkout_num=?";
		String sql5="SELECT goods_name FROM checkout WHERE checkout_num =?";		
		String sql2="update checkout set client=?,goods_name=?,quantity=?,checkout_date=? where checkout_num=?;";
		String sql3="UPDATE inventory SET quantity=quantity-? WHERE goods_name=?";
		String sql6="SELECT quantity FROM checkout WHERE checkout_num=?";
		String sql7="SELECT goods_name FROM checkout WHERE checkout_num=?";
		String s=changecheckout.getCheckout_date();
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyyMMdd");
		try {
			Date date = formatter.parse(s);
			
			//获取之前出库单的货物数量
			Map<String, Object> map1=template.queryForMap(sql4,changecheckout.getCheckout_num());
			//获取之前出库单的货物名称
			Map<String, Object> map2=template.queryForMap(sql5,changecheckout.getCheckout_num());
			int aaa = (int) map1.get("quantity");
			String bbb = (String) map2.get("goods_name");
			//将之前出库单所修改的库存数据抹除
			template.update(sql1,aaa,bbb);
			//将新数据输入出库单中
			template.update(sql2,changecheckout.getClient(),changecheckout.getGoods_name(),changecheckout.getQuantity(),date,changecheckout.getCheckout_num());
			//获取新出库单的数量
			Map<String, Object> map3=template.queryForMap(sql6,changecheckout.getCheckout_num());
			//获取新出库单的货物名称
			Map<String, Object> map4=template.queryForMap(sql7,changecheckout.getCheckout_num());
			int ccc = (int) map3.get("quantity");
			String ddd = (String) map4.get("goods_name");
			//按照新出库单的数据更新库存信息
			template.update(sql3,ccc,ddd);

			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void changecheckin(domain.changecheckin changecheckin) {
		// TODO Auto-generated method stub
		String sql1="UPDATE inventory SET quantity=quantity-(SELECT quantity FROM checkin WHERE checkin_num=?) WHERE goods_name=(SELECT goods_name FROM checkin WHERE checkin_num =?);";
		String sql2="update checkin set supplier=?,goods_name=?,quantity=?,checkin_date=? where checkin_num=?;";
		String sql3="INSERT INTO inventory (goods_name,quantity) VALUES ((SELECT goods_name FROM checkin WHERE checkin_num=?),(SELECT quantity FROM checkin WHERE checkin_num=?)) ON DUPLICATE KEY UPDATE quantity=quantity+(SELECT quantity FROM checkin WHERE checkin_num=?);";
		//1.删除库存表中关于此入库单的货物数量信息
		//2.更新入库单信息
		//3.根据更新的入库单信息来更新库存表中的货物信息
		String s=changecheckin.getCheckin_date();
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyyMMdd");
		try {
			Date date = formatter.parse(s);
			template.update(sql1,changecheckin.getCheckin_num(),changecheckin.getCheckin_num());
			template.update(sql2,changecheckin.getSupplier(),changecheckin.getGoods_name(),changecheckin.getQuantity(),date,changecheckin.getCheckin_num());
			template.update(sql3,changecheckin.getCheckin_num(),changecheckin.getCheckin_num(),changecheckin.getCheckin_num());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addcheckin(checkinw checkin) {
		// TODO 自动生成的方法存根
		//1.定义sql
		String s=checkin.getCheckin_date();
		String sql1 = "INSERT INTO checkin VALUES(NULL,?,?,?,?)";
		String sql2 = "INSERT INTO inventory(goods_name,quantity) VALUES(?,?) ON DUPLICATE KEY UPDATE quantity=quantity+?";
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyyMMdd");
		try {
			Date date = formatter.parse(s);
			template.update(sql1,checkin.getSupplier(),checkin.getGoods_name(),checkin.getQuantity(),date);
			template.update(sql2,checkin.getGoods_name(),checkin.getQuantity(),checkin.getQuantity());
			} 
		catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			}	
		}
	@Override
	public void addcheckout(checkoutw checkout) {
		// TODO 自动生成的方法存根
		//1.定义sql
		String a=checkout.getCheckout_date();
		String sql3 = "INSERT INTO checkout VALUES(NULL,?,?,?,?)";
		String sql4 = "INSERT INTO inventory(goods_name,quantity) VALUES(?,?) ON DUPLICATE KEY UPDATE quantity=quantity-?";
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyyMMdd");
		try {
			Date date = formatter.parse(a);
			template.update(sql3,checkout.getClient(),checkout.getGoods_name(),checkout.getQuantity(),date);
			template.update(sql4,checkout.getGoods_name(),checkout.getQuantity(),checkout.getQuantity());
			} 
		catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			}	
		}
	@Override
	public boolean enough(checkoutw checkout) {
		// TODO 自动生成的方法存根
		//获取填入表单的数量
		int checkoutquantity=checkout.getQuantity();
		//获取数据库种关于出库货物的库存
		String sql="select quantity from inventory where goods_name=?";
		Map<String, Object> map=template.queryForMap(sql,checkout.getGoods_name());
		int inventoryquantity=(int) map.get("quantity");
		if(inventoryquantity>=checkoutquantity){
			return true;
			}else{
				return false;//货物数量不足
				}
		}
	@Override
	public boolean nameexist(checkoutw checkout) {
		// TODO 自动生成的方法存根
		String aaa=checkout.getGoods_name();
		try {
			String sql="select * from inventory where goods_name=?";
			Inventory a=template.queryForObject(sql, new BeanPropertyRowMapper<Inventory>(Inventory.class),aaa);
			return true;
		} catch (EmptyResultDataAccessException e){
			return false;
		}
		
	}
	
	
	@Override
	public boolean loginnameexist(String name) {
		// TODO Auto-generated method stub
		try{
			String sql="select * from login_infor where login_name=?";
			login login=template.queryForObject(sql, new BeanPropertyRowMapper<login>(login.class),name);
			return true;
			//说明用户名已存在
		}catch(EmptyResultDataAccessException e){
			return false;
		}
		
	}

	@Override
	public boolean enough2(domain.changecheckout changecheckout) {
		// TODO Auto-generated method stub
		//获取填入表单的数量
		int checkoutquantity=changecheckout.getQuantity();
		//获取数据库种关于出库货物的库存
		String sql="select quantity from inventory where goods_name=?";
		String sql1="select quantity from checkout where checkout_num=?";
		
		Map<String, Object> map=template.queryForMap(sql,changecheckout.getGoods_name());
		Map<String, Object> map1=template.queryForMap(sql1,changecheckout.getCheckout_num());
		int inventoryquantity=(int) map.get("quantity")+(int)map1.get("quantity");
		if(inventoryquantity>=checkoutquantity){
			return true;
			}else{
				return false;
				}
		}

	@Override
	public boolean nameexist2(domain.changecheckout changecheckout) {
		// TODO Auto-generated method stub
		try {
			String sql="select * from inventory where goods_name=?";
			template.queryForObject(sql, new BeanPropertyRowMapper<goods_name>(goods_name.class),
					changecheckout.getGoods_name());
			return true;
		} catch (EmptyResultDataAccessException e){
			return false;
		}
	}

	@Override
	public login loginsuccess(String name, String password) {
		// TODO Auto-generated method stub
		try{
			String sql="select * from login_infor where login_name = ? and login_pw = ?";
			login login=template.queryForObject(sql, new BeanPropertyRowMapper<login>(login.class),name,password);
			return login;
		}catch (EmptyResultDataAccessException e){
			return null;
		}
		
	}

	

	@Override
	public void enroll(String name, String password) {
		// TODO Auto-generated method stub
		String sql="insert into login_infor values(?,?)";
		template.update(sql,name,password);
	}


}
