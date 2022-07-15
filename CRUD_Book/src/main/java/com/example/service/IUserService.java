package com.example.service;

import com.example.entity.UserEntity;

public interface IUserService {
	public UserEntity addUser(UserEntity user);
	
	public UserEntity updateUser(String id, UserEntity user);
	
	public boolean delUser(String id);
	
}
