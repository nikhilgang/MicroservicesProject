package com.rp.securityapp.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicWebController {

	@GetMapping("/home")
	public String getHomePage()
	{
		return "Welcome from Home Page";
	}
}
