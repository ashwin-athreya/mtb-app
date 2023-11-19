package com.cg.mts.service;

import org.springframework.stereotype.Service;

import com.cg.mts.exception.UserNotFoundException;


@Service
public interface IAdminService {

	public void registerAdmin(String username, String password) throws Exception;
	
	public void removeAdmin(int adminId) throws UserNotFoundException;
}