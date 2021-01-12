package service;

import domain.changecheckin;
import domain.changecheckout;
import domain.checkinw;
import domain.checkoutw;

public interface storehouseservice {

	void deletecheckin(String checkin_num);

	void deletecheckout(String checkout_num);

	changecheckout findcheckout(String id);

	changecheckin findcheckin(String id);

	void changecheckout(changecheckout changecheckout);

	void changecheckin(changecheckin changecheckin);

	void addcheckout(checkoutw checkout);

	void addcheckin(checkinw checkin);


}
