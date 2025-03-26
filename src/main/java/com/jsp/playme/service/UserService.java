package com.jsp.playme.service;

import com.jsp.playme.model.User;

public interface UserService
{

	User addNewUser(User user);

	boolean checkEmail(String mail);

	boolean checkMobile(String mobile);

	User checkMailLogin(String mail, String password);

	User checkMobileLogin(String mobile, String password);

}
