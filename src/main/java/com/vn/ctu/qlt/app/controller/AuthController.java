package com.vn.ctu.qlt.app.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vn.ctu.qlt.app.dto.UserLoginDto;
import com.vn.ctu.qlt.app.exceptions.UserExitException;
import com.vn.ctu.qlt.app.model.UserModel;
import com.vn.ctu.qlt.app.service.UserService;

/**
 * @author NTDSIVAL
 * @Date Dec 27, 2018
 */

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping("/register")
	private ResponseEntity<Void> register(@RequestBody UserModel request) {
		logger.debug("AuthController() method register");
		request.setDateCreate(new Date());
		request.setPassword(passwordEncoder.encode(request.getPassword()));
		request.setEnabled(false);
		request.setAccountNonExpired(false);
		request.setCredentialsNonExpired(false);
		try {
			userService.saveUser(request);
		} catch (UserExitException e) {
			logger.error(e.toString());
			throw e;
		} 
		catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/login")
	private ResponseEntity<Object> login(@RequestBody UserLoginDto userDto){
		
		return ResponseEntity.ok().build();
	}
}
