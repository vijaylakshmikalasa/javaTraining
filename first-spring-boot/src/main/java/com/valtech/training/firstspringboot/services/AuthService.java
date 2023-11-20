package com.valtech.training.firstspringboot.services;

import com.valtech.training.firstspringboot.entities.User;
import com.valtech.training.firstspringboot.models.ChangePassWordModel;
import com.valtech.training.firstspringboot.models.RegisterUserModel;

public interface AuthService {

	void populateUsers();

	User createUser(RegisterUserModel regUSerModel);

	boolean ChangePassword(ChangePassWordModel passwordModel);

	void upgradeUserToAdmin(long id);

	void enabledUser(long id);

	void disabledUser(long id);

}