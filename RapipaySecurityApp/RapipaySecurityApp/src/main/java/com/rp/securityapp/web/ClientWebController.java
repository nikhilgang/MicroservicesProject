package com.rp.securityapp.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientWebController {

	@GetMapping("/profile")
	public String showCLientProfile()
	{
		return "Client Profile Render";
	}
}
