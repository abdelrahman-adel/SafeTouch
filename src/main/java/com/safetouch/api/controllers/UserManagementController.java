package com.safetouch.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetouch.api.models.LoginInfoType;
import com.safetouch.api.models.UserType;
import com.safetouch.api.services.UserManagementService;
import com.safetouch.api.services.interfaces.response.FindRsType;
import com.safetouch.api.services.interfaces.response.LoginRsType;
import com.safetouch.api.services.interfaces.response.RegisterRsType;

@RestController
public class UserManagementController {

	@Autowired
	private UserManagementService UserManagementService;

	@PostMapping("/login")
	public LoginRsType login(@RequestBody LoginInfoType loginInfo) {
		return UserManagementService.login(loginInfo);
	}

	@PostMapping("/register")
	public RegisterRsType register(@RequestBody UserType userInfo) {
		return UserManagementService.register(userInfo);
	}

	@GetMapping("/find")
	public FindRsType find(@RequestParam(name = "email", required = true) String email) {
		return UserManagementService.find(email);
	}
}
