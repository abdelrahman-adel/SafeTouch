package com.safetouch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetouch.models.LoginInfo;
import com.safetouch.models.UserInfo;
import com.safetouch.services.UserManagementService;
import com.safetouch.services.interfaces.UserInfoRs;

@RestController
public class UserManagementController {

	@Autowired
	private UserManagementService UserManagementService;

	@PostMapping("/login")
	public UserInfoRs login(@RequestBody LoginInfo loginInfo) {
		return UserManagementService.login(loginInfo);
	}

	@PostMapping("/register")
	public UserInfoRs register(@RequestBody UserInfo userInfo) {
		return UserManagementService.register(userInfo);
	}

	@GetMapping("/find")
	public UserInfoRs find(@RequestParam(name = "email", required = true) String email) {
		return UserManagementService.find(email);
	}
}
