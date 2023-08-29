package com.coltroller.controller;


import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coltroller.entiry.User;
import com.coltroller.repo.UserRepo;

@Controller
@ResponseBody
//@RequestMapping("/user")
public class MyController {

	@Autowired
	UserRepo uRepo;
	
	@PostMapping("/add")
	public Set<User> addUser(@RequestBody User u) {
		return uRepo.addUser(u);
	}
	
	@PostMapping("/update/{id}")
	public Set<User> updateUser(@PathVariable("id") Long id, @RequestBody User u) {
		try {
			return uRepo.update(id, u);
		} catch (Exception e) {
			e.printStackTrace();
//			return e.getMessage();
			return null;
		}
	}

	@GetMapping("/")
	public Set<User> getAllUser() {
		return uRepo.getAll();
	}

	@GetMapping("/get/{id}")
	public List<User> getUser(@PathVariable("id") Long id) {

		return uRepo.findById(id);
	}
	@GetMapping("/delete/{id}")
	public Set<User> deleteUser(@PathVariable("id") Long id) {

		return uRepo.deleteById(id);
	}
	

	@GetMapping("/u")
	public String test() {
		return "Hello World!";
	}
	
}
