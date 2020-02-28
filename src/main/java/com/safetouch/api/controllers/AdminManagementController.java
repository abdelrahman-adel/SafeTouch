package com.safetouch.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetouch.api.service.AdminManagementService;
import com.safetouch.api.service.request.LoginRqType;
import com.safetouch.api.service.request.RegisterRqType;
import com.safetouch.api.service.response.CheckNotificationRsType;
import com.safetouch.api.service.response.LoginRsType;
import com.safetouch.api.service.response.RegisterRsType;

@RestController
@RequestMapping("/admin")
public class AdminManagementController {

	@Autowired
	private AdminManagementService adminManagementService;

	@GetMapping("/checknotif")
	public CheckNotificationRsType checkNotification(@RequestParam(name = "email", required = true) String email) {
		return adminManagementService.checkNotification(email);
	}

	@PostMapping("/login")
	public LoginRsType login(@RequestBody LoginRqType loginRqType) {
		return adminManagementService.login(loginRqType);
	}

	@PostMapping("/register")
	public RegisterRsType register(@RequestBody RegisterRqType registerRqType) {
		return adminManagementService.register(registerRqType);
	}
}
