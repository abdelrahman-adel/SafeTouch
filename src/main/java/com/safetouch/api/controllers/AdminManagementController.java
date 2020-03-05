package com.safetouch.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetouch.api.service.AdminManagementService;
import com.safetouch.api.service.request.LoginRqType;
import com.safetouch.api.service.request.ReactToNotificationRqType;
import com.safetouch.api.service.request.RegisterRqType;
import com.safetouch.api.service.response.CheckNotificationRsType;
import com.safetouch.api.service.response.LoginRsType;
import com.safetouch.api.service.response.ReactToNotificationRsType;
import com.safetouch.api.service.response.RegisterRsType;
import com.safetouch.exceptions.BusinessException;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminManagementController {

	@Autowired
	private AdminManagementService adminManagementService;

	@GetMapping("/check-notif")
	public CheckNotificationRsType checkNotifications(@RequestParam(name = "email", required = true) String email) throws BusinessException {
		return adminManagementService.checkNotifications(email);
	}

	@PostMapping("/react-notif")
	public ReactToNotificationRsType reactToNotification(@RequestBody ReactToNotificationRqType notificationRqType) throws BusinessException {
		return adminManagementService.reactToNotification(notificationRqType);
	}

	@PostMapping("/login")
	public LoginRsType login(@RequestBody LoginRqType loginRqType) throws BusinessException {
		return adminManagementService.login(loginRqType);
	}

	@PostMapping("/register")
	public RegisterRsType register(@RequestBody RegisterRqType registerRqType) throws BusinessException {
		return adminManagementService.register(registerRqType);
	}
}
