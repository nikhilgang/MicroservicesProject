package com.rp.securityapp.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminWebController {

	@GetMapping("/test")
	public String doAdminTask()
	{
		return "admin task called ";
	}
}
