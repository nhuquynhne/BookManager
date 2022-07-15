package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.UserEntity;
import com.example.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService iUserService;
		
		//API add user
		@PostMapping("/")
		public UserEntity addUser(@RequestBody UserEntity user) {
			return iUserService.addUser(user);
		}
		
		//API update user
		@PutMapping("/{id}")
		public UserEntity updateUser(@PathVariable("id") String id, @RequestBody UserEntity user) {
			return iUserService.updateUser(id, user);
		}
		
		//API delete author
		@DeleteMapping("/{id}")
		public boolean delUser(@PathVariable("id") String id) {
			return iUserService.delUser(id);
		}
}
