package com.safetouch.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetouch.api.service.UserManagementService;
import com.safetouch.api.service.request.AlertRqType;
import com.safetouch.api.service.request.LoginRqType;
import com.safetouch.api.service.request.RegisterRqType;
import com.safetouch.api.service.response.AlertRsType;
import com.safetouch.api.service.response.CheckCaseRsType;
import com.safetouch.api.service.response.FindRsType;
import com.safetouch.api.service.response.LoginRsType;
import com.safetouch.api.service.response.RegisterRsType;
import com.safetouch.exceptions.BusinessException;

@RestController()
@RequestMapping("/user")
public class UserManagementController {

	@Autowired
	private UserManagementService userManagementService;

	@PostMapping("/login")
	public LoginRsType login(@RequestBody LoginRqType loginRqType) throws BusinessException {
		return userManagementService.login(loginRqType);
	}

	@PostMapping("/register")
	public RegisterRsType register(@RequestBody RegisterRqType registerRqType) throws BusinessException {
		return userManagementService.register(registerRqType);
	}

	@GetMapping("/find")
	public FindRsType find(@RequestParam(name = "email", required = true) String email) throws BusinessException {
		return userManagementService.find(email);
	}

	@PostMapping("/alert")
	public AlertRsType alert(@RequestBody AlertRqType alertRqType) throws BusinessException {
		return userManagementService.alert(alertRqType);
	}

	@GetMapping("/check-case")
	public CheckCaseRsType checkCase(@RequestParam(name = "caseNumber", required = true) String caseNumber) throws BusinessException {
		return userManagementService.checkCase(caseNumber);
	}
}
