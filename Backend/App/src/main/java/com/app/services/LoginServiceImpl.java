package com.app.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserDAO;
import com.dtcc.app.App.User;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Transactional
	public String authenticateUser(User user) {
		return userDAO.authenticateUser(user);
	}

}
