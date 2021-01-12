package service.impl;

import dao.*;
import dao.impl.storehouseimpl;
import domain.changecheckin;
import domain.changecheckout;
import domain.checkinw;
import domain.checkoutw;
import service.storehouseservice;

public class storehouseserviceimpl implements storehouseservice{
	private storehouse dao=new storehouseimpl();
	
	@Override
	public void deletecheckin(String checkin_num) {
		// TODO Auto-generated method stub
		dao.deletecheckin(Integer.parseInt(checkin_num));
	}
	@Override
	public void deletecheckout(String checkout_num) {
		// TODO Auto-generated method stub
		dao.deletecheckout(Integer.parseInt(checkout_num));

	}
	@Override
	public changecheckout findcheckout(String id) {
		// TODO Auto-generated method stub
		return dao.findcheckout(Integer.parseInt(id));
	}
	@Override
	public changecheckin findcheckin(String id) {
		// TODO Auto-generated method stub
		return dao.findcheckin(Integer.parseInt(id));
	}
	@Override
	public void changecheckout(domain.changecheckout changecheckout) {
		// TODO Auto-generated method stub
		dao.changecheckout(changecheckout);
	}
	@Override
	public void changecheckin(domain.changecheckin changecheckin) {
		// TODO Auto-generated method stub
		dao.changecheckin(changecheckin);

	}
	@Override
	public void addcheckout(checkoutw checkout) {
		// TODO Auto-generated method stub
		dao.addcheckout(checkout);
	}
	@Override
	public void addcheckin(checkinw checkin) {
		// TODO Auto-generated method stub
		dao.addcheckin(checkin);
	}
	

}
