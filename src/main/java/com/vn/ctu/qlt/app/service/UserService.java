package com.vn.ctu.qlt.app.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.vn.ctu.qlt.app.model.UserModel;

/**
 * @author NTDSIVAL
 * @Date Dec 27, 2018
 */
@Service
public interface UserService extends UserDetailsService {

	public UserModel saveUser(UserModel userModel) throws Exception;

	public UserModel loadUserByUsername(String userName);
	
	public Optional<UserModel> getUserByUsername(String userName);
}
