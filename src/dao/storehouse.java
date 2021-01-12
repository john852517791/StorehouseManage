package dao;
import org.util.*;
import domain.*;
public interface storehouse {

	void deletecheckin(int i);

	void deletecheckout(int i);

	changecheckout findcheckout(int id);

	changecheckin findcheckin(int id);

	void changecheckout(domain.changecheckout changecheckout);

	void changecheckin(domain.changecheckin changecheckin);

	boolean enough(checkoutw checkout);

	boolean nameexist(checkoutw checkout);

	void addcheckin(checkinw checkin);

	void addcheckout(checkoutw checkout);

	boolean enough2(changecheckout changecheckout);

	boolean nameexist2(changecheckout changecheckout);

	domain.login loginsuccess(String name, String password);

	boolean loginnameexist(String name);

	void enroll(String name, String password);
	
	
}
