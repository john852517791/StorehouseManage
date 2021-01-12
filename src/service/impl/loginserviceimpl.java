package service.impl;

import dao.storehouse;
import dao.impl.storehouseimpl;
import service.loginservice;

public class loginserviceimpl implements loginservice{
	private storehouse dao = new storehouseimpl();
	@Override
	public domain.login login(domain.login login) {
		// TODO Auto-generated method stub
		return dao.loginsuccess(login.getName(),login.getPassword());
	}
	@Override
	public boolean nameexist(String name) {
		// TODO Auto-generated method stub
		boolean a=dao.loginnameexist(name);
		if(a){
			return true;//用户名已存在
		}else{
			return false;
		}
		
	}
	@Override
	public void enroll(String name, String password) {
		// TODO Auto-generated method stub
		dao.enroll(name,password);
	}

}
