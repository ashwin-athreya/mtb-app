package com.cg.mts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entity.User;
import com.cg.mts.exception.UserCreationError;
import com.cg.mts.repoImpl.QueryClass;
import com.cg.mts.repository.UserRepository;
import com.cg.mts.validator.InputValidator;

@Service
public class IUserServiceImpl implements IUserService {

	@Autowired
	UserRepository userrepo;

	@Autowired
	InputValidator validate;

	@Autowired
	QueryClass qcp;

	@Override
	public User addUser(User user) throws UserCreationError {
//		if (!validate.usernameValidator(user.getUsername()))
//			throw new UserCreationError("Check Username !!!!");
//		if (!validate.passwordValidator(user.getPassword()))
//			throw new UserCreationError("Cannot register this User with this password");
//		if (!validate.roleValidator(user.getRole()))
//			throw new UserCreationError("Role should be either ADMIN or CUSTOMER");
		return userrepo.save(user);
	}

	@Override
	public User removeUser(User user) {
		userrepo.delete(user);
		return user;
	}

}
