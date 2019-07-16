package com.exam.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.DAO.UserDAO;
import com.exam.model.User;
import com.exam.service.NewRegisterService;

@Service("NewRegisterService")
public class NewRegisterServiceImpl implements NewRegisterService {
	
	@Autowired
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}



	@Override
	public boolean registerUser(User user) {
		boolean isRegister=false;
		boolean saveUser=getUserDAO().saveUser(user);
		if(saveUser) 
			isRegister=true;
		return isRegister;
		
		
	}

}
