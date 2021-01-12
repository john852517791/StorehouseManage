package service;

import domain.login;

public interface loginservice {

	domain.login login(login login);

	boolean nameexist(String name);

	void enroll(String name, String password);

}
