package com.jsp.playme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.playme.model.Admin;
import com.jsp.playme.service.AdminService;

@Controller
@RequestMapping("/PlayMe/admin")
public class AdminController
{
	@Autowired
	private AdminService aService;

	@CrossOrigin(origins = "http://127.0.0.1:5501")
	@GetMapping("/login")
	public ResponseEntity<Admin> checkMobileLogin(@RequestParam String mail, @RequestParam String password)
	{
		if (aService.checkAdminLogin(mail, password))
		{
			return new ResponseEntity<Admin>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
	}
}
