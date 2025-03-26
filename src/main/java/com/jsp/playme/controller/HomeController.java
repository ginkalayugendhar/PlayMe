package com.jsp.playme.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.playme.model.User;
import com.jsp.playme.service.UserService;

@Controller
@RequestMapping("/PlayMe")
public class HomeController
{
	@Autowired
	private UserService uService;

	@CrossOrigin(origins = "http://127.0.0.1:5501")
	@PostMapping("/user")
	public ResponseEntity<User> getUser(@RequestBody User user)
	{
		System.out.println(user);
		User u = uService.addNewUser(user);
		return ResponseEntity.ok(u);
	}

	@CrossOrigin(origins = "http://127.0.0.1:5501")
	@GetMapping("/checkMail")
	public ResponseEntity<String> checkMail(@RequestParam String mail)
	{
		System.out.println(mail);
		if (uService.checkEmail(mail))
		{
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin(origins = "http://127.0.0.1:5501")
	@GetMapping("/checkMobile")
	public ResponseEntity<String> checkMobile(@RequestParam String mobile)
	{
		System.out.println(mobile);
		if (uService.checkMobile(mobile))
		{
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin(origins = "http://127.0.0.1:5501")
	@PostMapping("/checkEmailLogin")
	public ResponseEntity<User> checkEmailLogin(@RequestBody Map<String, String> data)
	{
		String mail = data.get("mail");
		String password = data.get("password");
		User user = uService.checkMailLogin(mail, password);
		if (user != null)
		{
			System.out.println(user);
			return ResponseEntity.ok(user);
		}
		else
		{
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin(origins = "http://127.0.0.1:5501")
	@GetMapping("/checkMobileLogin")
	public ResponseEntity<User> checkMobileLogin(@RequestParam String mobile, @RequestParam String password)
	{
		User user = uService.checkMobileLogin(mobile, password);
		if (user != null)
		{
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
}
