package com.vn.ctu.qlt.app.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vn.ctu.qlt.app.controller.AuthController;
import com.vn.ctu.qlt.app.exceptions.UserExitException;
import com.vn.ctu.qlt.app.model.UserModel;
import com.vn.ctu.qlt.app.repository.UserRepository;
import com.vn.ctu.qlt.app.service.UserService;

/**
 * @author NTDSIVAL
 * @Date Dec 27, 2018
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserModel saveUser(UserModel userModel) {
		try {
			if (getUserByUsername(userModel.getUsername()).get() == null) {
				logger.debug("user don't exists, create user " + userModel.getUsername());
				userRepository.save(userModel);
				return userModel;
			} else {
				throw new UserExitException(String.format("User %s exits ", userModel.getUsername()));
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public UserModel loadUserByUsername(String userName) throws UsernameNotFoundException {
		return userRepository.findUserByUserName(userName).get();
	}

	@Override
	public Optional<UserModel> getUserByUsername(String userName) throws NoSuchElementException {
		return userRepository.selectUserByUserName(userName);
	}

}
